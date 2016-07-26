/*
 * Echqueserver.java
 *
 * Created on April 27, 2007, 8:17 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor. 
 *
 * @author Basel
 *
 */ 

package eCheque;

import java.net.*;
import java.io.* ;       

public class EChequeServer implements Runnable {
    
    /** Creates a new instance of EChequeServer */
    private Socket serverConnection;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public EChequeServer(Socket socket){
        serverConnection = socket;
    }

    private void getSocketStream() throws Exception {
        objectOutputStream = new ObjectOutputStream(serverConnection.getOutputStream());
        objectOutputStream.flush();
        objectInputStream = new ObjectInputStream(serverConnection.getInputStream());
    }

    private void processConnection() throws IOException,ClassNotFoundException {       
        int code = objectInputStream.readInt();
    
        switch (code) {
            case 0:
                registerClientInfo();
                break;
            case 1:
                depositCheque();
                break;
            case 2:
                cancelCheque();
                break;
            default:
                break;
        }
    }
 
    private void registerClientInfo() throws IOException, ClassNotFoundException {
        
        EChequeRegistration registerClient;
        registerClient = (EChequeRegistration)objectInputStream.readObject();
        // get user account ID
        String accountID = "'" + registerClient.getAccountNumber() + "',";
        String certificate = "'" + registerClient.getClientName()+"DC.edc" + "',";
        String clientName = "'" + registerClient.getClientName() + "',";

        DigitalCertificate registerDigitalCertificate = (DigitalCertificate)objectInputStream.readObject();

        String registerStatement = "insert into accounts(accountID,clientName,dcPath,balance) values("
                                    + accountID+clientName+certificate+100000+")";

        //Starting database
        EChequeDB eChequeDatabase = new EChequeDB();
        eChequeDatabase.runDatabase(1, registerStatement);

        //store client digital certificate
        DigitalCertificateIO digitalCertificateIO = new DigitalCertificateIO();
        digitalCertificateIO.saveDigitalCertificate(registerDigitalCertificate, "Bank\\"+registerClient.getClientName()+"DC.edc");

        objectOutputStream.writeObject("Registeration Complete");
        objectOutputStream.flush();      
    }
 
    private void depositCheque()throws IOException,ClassNotFoundException {

        EChequeDB eChequeDB = new EChequeDB();
        ECheque receivedCheque = (ECheque)objectInputStream.readObject();   //read cheque from socket
        String depositAccount = (String)objectInputStream.readObject();     //read deposit Account number.
        String withdrawStatement = "Select balance from accounts where accountID = " + receivedCheque.getAccountNumber();     
        String chequeUpdate = "";
        String depositResult = "";  
        double[] balanceValue = new double[1];  //this is needed because balanceValue is passed by reference        
        
        if(eChequeDB.runDatabase(0, withdrawStatement, balanceValue)){
            //check if the balance sufficient
            double chequeMoney = Double.parseDouble(receivedCheque.getMoney());   
            if(chequeMoney<=balanceValue[0]){
                // cheque that the cheque is not canceld
                withdrawStatement = "Select * from cancelledCheque where accountID = '" + receivedCheque.getAccountNumber()
                                    +"'and chequeID ='"+receivedCheque.getChequeNumber()+"'";
                if(!eChequeDB.runDatabase(0, withdrawStatement)){
                    withdrawStatement = "Select * from eChequeOut where chequeID = '" + receivedCheque.getChequeNumber()
                                        +"'and accountID='"+receivedCheque.getAccountNumber()+"'";
                    if(!eChequeDB.runDatabase(0, withdrawStatement)){
                        withdrawStatement = "Update accounts set balance = balance -" + chequeMoney + "where accountID = "
                                            +receivedCheque.getAccountNumber();
                        eChequeDB.runDatabase(1, withdrawStatement);
                        withdrawStatement =  "Update accounts set balance = balance +" + chequeMoney + "where accountID = "
                                            +depositAccount;
                        eChequeDB.runDatabase(1, withdrawStatement);

                        // update cheque out and in table
                        chequeUpdate = "Insert into eChequeOut(chequeID, accountID, balance) values('" + receivedCheque.getChequeNumber()
                                        + "','" + receivedCheque.getAccountNumber()+"',"+chequeMoney+")";
                        eChequeDB.runDatabase(1, chequeUpdate);

                        chequeUpdate = "Insert into eChequeIN(chequeID, accountID, balance) values('" + receivedCheque.getChequeNumber()+
                                        "','" + receivedCheque.getAccountNumber()+"',"+chequeMoney+")";
                        eChequeDB.runDatabase(1, chequeUpdate);

                       //report the deposit result
                       depositResult = "Your acoount recieves the deposit cheque\nyour balance incremented by" + receivedCheque.getMoney();
                    }
                    else{
                        depositResult = "This cheque is already deposit, sorry we can not deposit it twice";
                    }
                } 
                else{
                   depositResult = "This cheque is canceled by the drawer\nSorry we can not deposit it";
                }
            }
            else{
                depositResult = "Drawer Balance is not sufficient for withdrawing\n";
            }
        }
        else{
            depositResult = "This cheque does not belong to one of our customers\nyou have to connect to the drawer bank server";
        }
        objectOutputStream.writeObject(depositResult);
        objectOutputStream.flush();
    } 
 
    private void cancelCheque()throws IOException,ClassNotFoundException{
     
         ECheque receivedCheque = (ECheque)objectInputStream.readObject();
         String cancelChequeStatement;         
         cancelChequeStatement = "insert into cancelledCheque (accountID,chequeID) values('"
                               +receivedCheque.getAccountNumber()+"','"+receivedCheque.getChequeNumber()+"')";
         
         EChequeDB eChequeDatabase = new EChequeDB();
         
         if(eChequeDatabase.runDatabase(1, cancelChequeStatement)) {
            objectOutputStream.writeObject("cheque canceld done");
            objectOutputStream.flush();         
         }
         else {
            objectOutputStream.writeObject("sorry cheque not canceled");
            objectOutputStream.flush();
         }         
    }
 
    private void closeConnection() {        
        try
        {    
            objectInputStream.close();
            objectOutputStream.close();
            serverConnection.close();
        }
        catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null,e.getMessage());
            e.printStackTrace();
        }     
    } 

    private String chequeReferenceString(ECheque eCheque){
        
        String reference;
        reference = eCheque.getAccountNumber() + eCheque.getAccountHolder()+eCheque.getBankName();
        reference += eCheque.getChequeNumber() + eCheque.getMoney() + eCheque.getCurrencyType();
        reference += eCheque.getEarnDay() + eCheque.getGuaranteed() + eCheque.getPayToOrderOf();
       
        return reference;    
    }
     
    public void run(){        
        
        try {          
            getSocketStream();
            processConnection();
        }
        catch(Exception error) {
            //JOptionPane.showMessageDialog(null,error.getMessage());
            error.printStackTrace();
        }     
        finally {
            closeConnection();
        }
    }
}