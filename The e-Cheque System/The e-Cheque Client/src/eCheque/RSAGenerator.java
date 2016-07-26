/*
 * RSAGenerator.java
 *
 * Created on March 28, 2007, 4:44 PM
 */

/**
 * @author SaaD
 */
package eCheque;

import java.security.*;
// This class generates PKI keys using RSA with key size 1024

public class RSAGenerator {

	public RSAGenerator(){
	}

	public KeyPair GenerateRSAKeys()throws NoSuchAlgorithmException 
	{
		SecureRandom SecRandom = new SecureRandom();
		KeyPairGenerator KeyGenerator = KeyPairGenerator.getInstance("RSA");
		KeyGenerator.initialize(1024, SecRandom);
		KeyPair RSAKeys = KeyGenerator.generateKeyPair();
		
		return RSAKeys;
	}
	
}
