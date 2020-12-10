/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rijndael.thread;

import rijndael.crypto.EncryptorAesGcm;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;

public class MyThread2 extends Thread{
   // VAR THREAD
   public Thread t;
   public String threadName;
   // VAR CRYPTO
   public byte[] input;
   public SecretKey secretKey;
   
   public String plain;
   public byte[] cipher;
   
   public String process;
   public boolean status = true;
   public EncryptorAesGcm aes;
   
   MyThread2(EncryptorAesGcm aes ,String name, byte[] input, String process) {
        // VAR THREAD
        threadName    = name;
        System.out.println("Creating " +  threadName );
        // VAR CRYPTO
        this.process = process;
        this.input   = input;
        this.aes     = aes;
    }
   
    @Override
    public void run() {
       System.out.println("PROCESS: "+process);
       System.out.println("Running " +  threadName );
        // DO ENCRYPTION   
        if(process == "e") {
            try {
                cipher = aes.encryptWithPrefixIV(input);
            } catch (Exception ex) {
                Logger.getLogger(MyThread2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //DO DECRYPTION
        else {
            try {
                plain = aes.decryptWithPrefixIV(input);
            } catch (Exception ex) {
                Logger.getLogger(MyThread2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
        System.out.println("Thread " +  threadName + " exiting.");
        status = false;
   }
   
   @Override
   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}
