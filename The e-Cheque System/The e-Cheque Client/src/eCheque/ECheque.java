/*
 * ECheque.java
 *
 * Created on March 27, 2007, 10:33 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 *
 * @author Basel
 * Fixed & Updated July 25th, 2016
 * By Tristan Lucas
 */

package eCheque;

import java.io.Serializable;

//this class  for inter data cheque form user
public class ECheque implements Serializable {
    
     private String accountHolder;
     private String accountNumber;
     private String bankName;
     private String payToOrderOf ;
     private String amountOfMoney;
     private String currencyType;
     private String chequeNumber;
     private boolean guaranteed;
     private String earnDay;
     private byte[] bankSignature;
     private byte[] drawerSignature;     
     
     //to ener data we use set function 
    /** Creates a new instance of ECheque */
    public ECheque() {        
    }
    
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;     
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;        
    }  
    public void setPayToOrderOf(String payToOrderOf) {
        this.payToOrderOf = payToOrderOf;        
    }    
    public void setAmountOfMoney(String amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }    
    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;        
    }
    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }
    public void setGuaranteed(boolean guaranteed) {
        this.guaranteed = guaranteed;        
    }
    public void setEarnDay(String earnDay) {
        this.earnDay = earnDay;     
    }
    public void setBankSignature(byte[] bankSignature) {
        this.bankSignature = bankSignature;     
    }    
    public void setDrawerSignature(byte[] drawerSignature) {
        this.drawerSignature = drawerSignature;     
    }   
    
    //to extracting data we use get function;
    public String getMoney() {
        return amountOfMoney;
    }
    public String getAccountHolder() {
        return accountHolder;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getBankName() {
        return bankName ;  
    }        
    public String getPayToOrderOf() {
        return payToOrderOf;   
    }    
    public String getCurrencyType() {
        return currencyType;   
    }
    public String getChequeNumber() {
        return chequeNumber;
    } 
    public boolean getGuaranteed() {        
        return guaranteed ;
    }
    public String getEarnDay() {
        return earnDay;
    }    
    public byte[] getBankSignature() {
        return  bankSignature;
    }    
    public byte[] getDrawerSignature() {
        return drawerSignature;
    }   
}