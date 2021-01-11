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

public class MyThread extends Thread{
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
   
   MyThread(EncryptorAesGcm aes ,String name, byte[] input, String process) {
        threadName    = name;
        this.process = process;
        this.input   = input;
        this.aes     = aes;
    }
   
    @Override
    public void run() {
        // DO ENCRYPTION   
        if(process == "e") {
            try {
                cipher = aes.encrypt(input);
            } catch (Exception ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //DO DECRYPTION
        else {
            try {
                plain = aes.decrypt(input);
            } catch (Exception ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        status = false;
   }
   
   @Override
   public void start () {
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}
