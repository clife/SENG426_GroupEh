/*
 * Digitalsigneture.java
 *
 * Created on March 28, 2007, 4:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 * @author Basel
 *
 * Fixed & Updated July 25th, 2016
 * By Tristan Lucas
 */
package eCheque;

import java.security.*;

public class DigitalSignature {
    
     public DigitalSignature(){
     }
     
//this function use to sign  cheque data by  RSA algorthem 
    public byte[] signature(String message, PrivateKey privKey)throws Exception {
         Signature signatureMessage = Signature.getInstance("SHA1withRSA");
         signatureMessage.initSign(privKey);
         signatureMessage.update(message.getBytes());
         byte[] signature = signatureMessage.sign();
         
         return signature;                
    }
    
    //this function use to verifay sign  to cheque data by  RSA algorthem     
    public boolean verifySignature(byte[] messageSignature, String message, PublicKey pubKey)
    throws Exception {
        Signature signatureMessage = Signature.getInstance("SHA1withRSA");
        signatureMessage.initVerify(pubKey);
        signatureMessage.update(message.getBytes());
        
        return signatureMessage.verify(messageSignature);
    }             
}    
    
    
    
    
    
 
    
    

