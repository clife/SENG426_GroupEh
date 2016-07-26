/*
 * DigitalCertificateIO.java
 *
 * Fixed & Updated July 25th, 2016
 * By Tristan Lucas
 */
package eCheque;

import java.io.*;

public class DigitalCertificateIO {   

    /** Creates a new instance of DigitalCertificateIO */
    public DigitalCertificateIO () {        
    } 
    
    public void saveDigitalCertificate(DigitalCertificate digitalCertificate, String filePath)throws IOException {
        //To create a new file to store Digtial Certificate Object.
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File(filePath)));        
        outputStream.writeObject(digitalCertificate);        
        outputStream.close();    
    }
    
    public DigitalCertificate readDigitalCertificate(String filePath) throws IOException, ClassNotFoundException {
        DigitalCertificate digitalCertificate;  
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File(filePath)));
        
        digitalCertificate =(DigitalCertificate)inputStream.readObject();        
        inputStream.close();
        
        return digitalCertificate;        
    } 
}