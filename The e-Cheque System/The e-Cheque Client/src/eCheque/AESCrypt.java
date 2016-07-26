/*
 * SecretKeyGenerateRandomAESKey.java
 *
 * Created on May 6, 2007, 2:29 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author SAAD
 */
package eCheque;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;

/** Creates a new instance of SecretKeyGenerateRandomAESKey */
public class AESCrypt {
	
	
	public SecretKey GenerateRandomAESKey() throws Exception {

		KeyGenerator KeyGen = KeyGenerator.getInstance("AES");
		SecureRandom random = new SecureRandom();
		KeyGen.init(random);
		SecretKey key = KeyGen.generateKey();
		
		return key;
	}
	
	
	public Cipher initializeCipher(Key key, int mode) throws Exception{

		int cipherMode;
		Cipher cipherObj; 

		if (mode == 0) {
			cipherMode = Cipher.ENCRYPT_MODE;
		}
		else if (mode == 1) {
			cipherMode = Cipher.DECRYPT_MODE;
		}
		else if (mode == 2) {
			cipherMode = Cipher.WRAP_MODE;
		}
		else {
			cipherMode = Cipher.UNWRAP_MODE;
		}   

		if((mode == 0) || (mode == 1)) {
			cipherObj = Cipher.getInstance("AES");
		}
		else {
			cipherObj =Cipher.getInstance("RSA");
		}
		
		cipherObj.init(cipherMode,key);
		
		return cipherObj;
	}
	
	
	public void crypt(InputStream inStream, OutputStream outStream, Cipher cipherObj) throws Exception {
		
		int blockSize = cipherObj.getBlockSize();
		int outputSize = cipherObj.getOutputSize(blockSize);
		byte[] inBytes = new byte[blockSize];
		byte[] outBytes = new byte[outputSize];
		int inLength = 0;
		boolean more = true;

		while (more) {
			inLength = inStream.read(inBytes);
			
			if(inLength == blockSize) {
				int outLength = cipherObj.update(inBytes, 0, blockSize, outBytes);
				outStream.write(outBytes, 0, outLength);
			}
			else {
				more = false ;
			}
		}
		
		if (inLength > 0) {
			outBytes = cipherObj.doFinal(inBytes, 0, inLength);
		}
		else {
			outBytes = cipherObj.doFinal();
		}
		
		outStream.write(outBytes);
	}
	
	
	public SecretKeySpec inilizeAESKeyByPassword(String password){
		byte[] KeyData = password.getBytes();
		
		SecretKeySpec aesKey = new SecretKeySpec(KeyData,"AES");
		
		return aesKey;
	}
}