/*
 * certificate.java
 *
 * Created on March 28, 2007, 3:26 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Abu^S3ooD
 */
package eCheque;

import java.io.Serializable;
import java.security.*;
// this class generates Digital Signature

// this class generates a Digital Certificate
public class DigitalCertificate implements Serializable { 
    
    private String holderName;
    private String subject ;
    private String issuer ;
    private String serialNumber;
    private String validFrom;
    private String validTo;
    private PublicKey publicKey;
    private byte[] issuerSignature;
    
    /** Creates a new instance of certificate */
    public DigitalCertificate() {        
    }
    
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    public void setValidFrom (String validFrom) {
        this.validFrom = validFrom;
    }
    public void setValidTo (String validTo) {
        this.validTo = validTo;
    }
    public void setPublicKey (PublicKey publicKey) {
        this.publicKey = publicKey;
    }
    public void setIssuerSignature (byte [] issuerSignature) {
        this.issuerSignature = issuerSignature;
    }
    
    public String getHolderName() {
        return holderName ;
    }
     public String getSubject() {
        return subject ;
    }
    public String getIssuer() {
        return issuer;
    }
    public String getSerialNumber() {
        return serialNumber;
    }
    public String getValidFrom() {
        return validFrom;
    }
    public String getValidTo() {
        return validTo;
    }
    public PublicKey getPublicKey() {
        return publicKey;
    }
    public byte[] getIssuerSignature() {
        return issuerSignature;
    }
}