/*
 * EChequeRegisteration.java
 *
 * Created on May 19, 2007, 7:52 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 *
 * @author Saad 
 *
 * Fixed & Updated July 25th, 2016
 * By Tristan Lucas
 */

package eCheque;

import java.io.Serializable;

public class EChequeRegistration implements Serializable {
    
    private String bankName;
    private String bankAddress;
    private String accountNumber;
    private String clientName;
    private String eWalletLocation;
    private int userNameHash;
    private int passwordHash;
    
    /** Creates a new instance of EChequeRegisteration */
    public EChequeRegistration() {
    }
    
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }       
    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }    
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }    
    public void setEWalletLocation(String eWalletLocation) {
        this.eWalletLocation = eWalletLocation;
    }    
    public void setUserName(int userNameHash) {
        this.userNameHash = userNameHash;
    }    
    public void setPasword(int passwordHash) {
        this.passwordHash = passwordHash;
    }
    
    public String getBankName() {
        return bankName;
    }
    public String getBankAddress() {
         return bankAddress;
    }    
    public String getAccountNumber() {
        return accountNumber;
    }    
    public String getClientName() {
        return clientName;
    }    
    public String getEWalletLocation() {
        return eWalletLocation;
    }    
    public int getUserName() {
        return userNameHash;
    }    
    public int getPasword() {
        return passwordHash;
    }    
}