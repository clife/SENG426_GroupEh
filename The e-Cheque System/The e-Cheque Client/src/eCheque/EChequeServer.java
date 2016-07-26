/*
 * EChequeServer.java
 *
 * Created on April 27, 2007, 8:17 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 *
 * @author Basel
 */ 
package eCheque;

//import com.sun.crypto.provider.AESCipher;
import java.net.*;
import java.io.* ;       
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.crypto.Cipher;
import java.security.*;

public class EChequeServer implements Runnable{
    
    /** Creates a new instance of EChequeServer */
    private ServerSocket serverSocket;
    private Socket serverConnection;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private InputStream socketInput;
    private OutputStream socketOutput;
    private JTextArea screenShell;
    private EChequeRegistration eChequeRegistration;
    private DigitalCertificate serverCertificate;
    private String walletPath;
    private int portID;
    private PrivateKey privateKey;

    public EChequeServer(JTextArea screen, DigitalCertificate digitalCertificate, String walletPath, PrivateKey privateKey, ServerSocket serverSocket){
        screenShell = screen;
        serverCertificate = digitalCertificate;
        this.walletPath = walletPath;
        this.privateKey = privateKey;
        this.serverSocket = serverSocket;
    }

    private void acceptConnection()throws IOException{
        serverConnection = serverSocket.accept();
    } 

    private void getSocketStream() throws Exception {
        socketOutput = serverConnection.getOutputStream();
        socketOutput.flush(); 
        socketInput = serverConnection.getInputStream() ;

        
        objectOutputStream = new ObjectOutputStream(serverConnection.getOutputStream());
        objectOutputStream.flush();
        objectInputStream = new ObjectInputStream(serverConnection.getInputStream());
    }

    private void processConnection()throws IOException, ClassNotFoundException, NoSuchAlgorithmException, 
                                            NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException,Exception {
       
        DigitalCertificate clientCertificate;          
        //exchange digital certificates
        clientCertificate = (DigitalCertificate)objectInputStream.readObject();
        objectOutputStream.writeObject(serverCertificate);
        objectOutputStream.flush();

        //get the wraeped key and uwraped it
        byte[] wrappedKey;
        byte[] unwrappedKey;
        Key sessionKey;
        int keyLength; 

        //read the session key form the socket
        keyLength = objectInputStream.readInt();
        wrappedKey = new byte[keyLength];
        socketInput.read(wrappedKey);

        //decrypt the session key with the user private key.
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.UNWRAP_MODE, privateKey);
        sessionKey = cipher.unwrap(wrappedKey,"AES",Cipher.SECRET_KEY);

        //
        Calendar currTime = new GregorianCalendar();
        String cheqName ="";
        cheqName += currTime.get(currTime.YEAR);
        cheqName += currTime.get(currTime.MONTH);
        cheqName += currTime.get(currTime.DAY_OF_MONTH);
        cheqName += currTime.get(currTime.HOUR_OF_DAY);
        cheqName += currTime.get(currTime.MILLISECOND);

        //read the cheque from the socket
        FileOutputStream chequeIn = new FileOutputStream(walletPath+"\\In Coming\\"+cheqName+".cry");
        byte[] buffer = new byte[1024];
        int numread;
        while ((numread = socketInput.read(buffer))>=0) {
           chequeIn.write(buffer, 0, numread);
        }

        chequeIn.close(); 

        //validate the received cheque.
        InputStream inputStream = new FileInputStream(walletPath+"\\In Coming\\"+cheqName+".cry");
        OutputStream outputStream = new FileOutputStream(walletPath+"\\My Cheques\\"+cheqName+".sec");

        //create AES object to decrypt the received cheque
        AESCrypt aesCrypt = new AESCrypt();
        Cipher aesCipher = aesCrypt.initializeCipher(sessionKey,1);
        aesCrypt.crypt(inputStream, outputStream, aesCipher);
        inputStream.close();
        outputStream.close();

        // verify the cheque siganture using the sender public key.
        DigitalSignature digitalSignature = new DigitalSignature();

        // load decrypted chequeObject.
        EChequeIO readCheque = new EChequeIO();
        ECheque receivedCheque = readCheque.readCheque(walletPath+"\\My Cheques\\"+cheqName+".sec");
        String chequeSignature = chequeReferenceString(receivedCheque);

        boolean verifySign = digitalSignature.verifySignature(receivedCheque.getDrawerSignature(), chequeSignature, clientCertificate.getPublicKey());

        if(verifySign){
              JOptionPane.showMessageDialog(null,"The signature is vaild", "e-Cheque Clear",
              JOptionPane.INFORMATION_MESSAGE);
        }
        else{
              JOptionPane.showMessageDialog(null,"The signature is not vaild", "e-Cheque not Clear",
              JOptionPane.WARNING_MESSAGE);
        }  
    }
       
    private void closeConnection() {        
        try
        {    
            socketOutput.close();
            socketInput.close();
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
 
    public void RunServer() {
        try {
            screenShell.append("\n>>Status: Starting The Sever");
            //startServer(); 
            screenShell.append("\n>>Status: Wating for connection");
            acceptConnection();
            screenShell.append("\n>>Status: connection accepted");
            getSocketStream();
            screenShell.append("\n>>Status: Socket I/O complete");
            screenShell.append("\n>>Status: processing started");
            processConnection ();
            screenShell.append("\n>>Status: process complete");
        }

        catch(Exception error)
        {
           JOptionPane.showMessageDialog(null,error.getMessage());
           error.printStackTrace();
        }
        finally
        {
            closeConnection();
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
       RunServer();
    }
}