/*
 * savecheque.java
 *
 * Created on March 4, 2007, 9:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 *
 * @author Basel
 *
 * Fixed & Updated July 25th, 2016
 * By Tristan Lucas
 */

package eCheque;

import java.io.*;

public class EChequeIO
{
    /* Creates a new instance of EChequeIO */
    public EChequeIO() {   
    }    
   
    public void saveCheque(ECheque eCheque, String fileName) throws IOException {       
        ObjectOutputStream outputStream =new ObjectOutputStream(new FileOutputStream(new File(fileName)));    
        outputStream.writeObject(eCheque);       
        outputStream.close();        
    }
   
    public ECheque readCheque(String fileName) throws IOException, ClassNotFoundException {
       ECheque eCheque;
       ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File(fileName)));     
       eCheque = (ECheque)inputStream.readObject();
       inputStream.close();
      
       return eCheque;
    }   
 }
