/*
 * EchequeClient.java
 *
 * Created on April 27, 2007, 8:38 PM
 *
 * @author SAAD
 * 
 */

package eCheque;

import java.net.*;
import java.io.* ;   
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class EChequeClient implements Runnable {
	
	private Socket clientConnection;
	private ObjectInputStream socketInputObject;
	private ObjectOutputStream socketOutputObject;
	private InputStream socketInput;
	private OutputStream socketOutput;
	private DigitalCertificate clientCertificate;
	private EChequeRegistration registrationData;
	private ECheque depositCheque;
	private JTextArea screenShell;
	private Key sessionKey;
	private String chequePath;
	private String walletPath;
	private String hostname;
	private int portID;
	private int bankmode;
	private boolean getServerConnection;
	private boolean getSocketConnection;
	private boolean getProcessConnection;
	private boolean bankConnection;


	/** Creates a new instance of EchequeClient */
	public EChequeClient(JTextArea screen, DigitalCertificate DC, Key aesKey, String wPath, String cPath, String host, int port) {
	    screenShell = screen;
	    clientCertificate = DC;
	    sessionKey = aesKey;
	    walletPath = wPath;
	    chequePath = cPath;
	    hostname = host;
	    portID = port;
	    screenShell = screen;
	    getServerConnection = false;
	    getSocketConnection = false;
	    getProcessConnection= false;
	    bankConnection = false;
	}

	/** Creates a new instance of EchequeClient */
	public EChequeClient(int port, int mode, String host, EChequeRegistration register, DigitalCertificate DC) {
		portID = port;
		bankmode = mode;
		hostname = host;
		registrationData = register;
		clientCertificate = DC;
		bankConnection = true;
	}
	
	/** Creates a new instance of EchequeClient */
	public EChequeClient(int port, int mode, String host,EChequeRegistration register, ECheque chq) {
		portID = port;
		bankmode = mode;
		hostname = host;
		registrationData = register;
		depositCheque = chq;
		bankConnection = true;
	}     
	
	/** Initializes server and triggers connection */
	private void connectToServer() throws Exception {	    
		clientConnection = new Socket(InetAddress.getByName(hostname),portID);
		getServerConnection = true;
	}
	
	/** Gets input data */
	private void getSocketStream() throws Exception {
		socketInput = clientConnection.getInputStream() ;
		socketOutput = clientConnection.getOutputStream();
		socketOutput.flush();
		socketInputObject = new ObjectInputStream(clientConnection.getInputStream());
		socketOutputObject = new ObjectOutputStream(clientConnection.getOutputStream());
		socketOutputObject.flush();
		
		getServerConnection = true;
	}

	/** Processes server output while session active */
	private void processConnection() throws IOException,Exception, ClassNotFoundException,
	NoSuchAlgorithmException, NoSuchPaddingException {
	
		DigitalCertificate serverCerit;
		boolean sessionDone = false;
		
		if(!sessionDone) {
			// Exchange the Digital Certificates
			socketOutputObject.writeObject(clientCertificate);
			socketOutputObject.flush();
			
			serverCerit = (DigitalCertificate)socketInputObject.readObject();
			
			// Send session key
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.WRAP_MODE, serverCerit.getPublicKey());
			byte[] wrappedKey = cipher.wrap(sessionKey);
			int keyLength = wrappedKey.length;
			
			socketOutputObject.writeInt(keyLength);
			socketOutputObject.flush();
			
			socketOutput.write(wrappedKey);
			socketOutput.flush();
			
			// Send encrypted cheque.
			FileInputStream cheqOut = new FileInputStream(chequePath);
			byte[] buffer = new byte[1024];
			int numread;
			
			while( (numread=cheqOut.read(buffer)) >=0 ) {
				socketOutput.write(buffer, 0, numread);
			}
			
			cheqOut.close(); 
		}
		
		getProcessConnection = true;  
	}
		
	/** Closes one or both active connection(s) */
	private void closeConnection() {
		try {
			if(getSocketConnection) {
				socketInput.close();
				socketOutput.close();
				socketInputObject.close();
				socketOutputObject.close();
			} 
			
			if(getServerConnection) {
				clientConnection.close();
			}
		} 
		
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Illegal close for communication channel", "Connection Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/** Determines bank type; processes bank object to output and other actions */
	private void processBankConection() throws IOException, ClassNotFoundException {	            
		String confirm;
		socketOutputObject.writeObject("Hello");
		socketOutputObject.flush();
		socketOutputObject.writeInt(bankmode);
		socketOutputObject.flush();
		
		if(bankmode == 0) {
			socketOutputObject.writeObject(registrationData);
			socketOutputObject.flush();
			socketOutputObject.writeObject(clientCertificate);
			socketOutputObject.flush();
			// save registration data.
			ObjectOutputStream outObj = new ObjectOutputStream(new FileOutputStream("Config.epc"));
			outObj.writeObject(registrationData);
			outObj.close();  
			
		} else if(bankmode == 1) {
			socketOutputObject.writeObject(depositCheque);
			socketOutputObject.flush();
			socketOutputObject.writeObject(registrationData.getAccountNumber());
			socketOutputObject.flush();
			JOptionPane.showMessageDialog(null,"Send info for deposit done");
		
		} else if(bankmode == 2) {
			socketOutputObject.writeObject(depositCheque);
			socketOutputObject.flush();
		}
		
		confirm = (String)socketInputObject.readObject();
		JOptionPane.showMessageDialog(null, confirm);
	}

	/** Determine connection type; connect and process */
	public void runClient() {    
		try {
			if(!bankConnection) {
				screenShell.append("\n\n>> Connecting to ECheque host");
			}
			
			connectToServer();
			
			if(!bankConnection) {
				screenShell.append("\n\n>> You are connected");
			}
			
			getSocketStream();
			   
			if(!bankConnection) {
				screenShell.append("\n\n>> You are connected");
			}
			
			if(!bankConnection) {
				screenShell.append("\n\n>> Starting cheque transfer");
				processConnection();
			
			} else {
				processBankConection();
			
			}
		}
	
		catch(Exception error) {
			JOptionPane.showMessageDialog(null, error.getMessage(), "Connection Error", JOptionPane.ERROR_MESSAGE);
		}
		
		finally {
			closeConnection();
		}
	}

	/** Run client */
	public void run() {
		runClient();
	}
}
