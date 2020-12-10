/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rijndael.thread;

import rijndael.util.CryptoUtils;
import rijndael.crypto.EncryptorAesGcm;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;

/**
 *
 * @author sulthan
 */

public class MyThread extends Thread{
   public Thread t;
   public String threadName;
   public String plain;
   public byte[] cipher;
   public String process;
   SecretKey secret;
   public boolean status = true;
   
   private static final int IV_LENGTH_BYTE = 12;
   
   public MyThread(String name, String str, String p, SecretKey key) {
        threadName    = name;
        process       = p;
        secret        = key;
        System.out.println("Creating " +  threadName );
        
        // JIKA ENKRIPSI, MAKA STR ADALAH PLAINTEXT
        if("e".equals(process))
            plain = str;
        // JIKA DEKRIPSI, MAKA STR ADALAH CIPHERTEXT
        else
            cipher = str.getBytes();
        
   }
   
   @Override
    public void run() {
        byte[] iv = CryptoUtils.getRandomNonce(IV_LENGTH_BYTE);
        try {
            // DO ENCRYPTION
            if("e".equals(process)) {
                cipher = EncryptorAesGcm.encryptWithPrefixIV(plain.getBytes(UTF_8));
            }
            //DO DECRYPTION
            else
            {
                plain = EncryptorAesGcm.decryptWithPrefixIV(cipher);
            }
            
            status = false;
        } catch (Exception ex) {
           Logger.getLogger(MyThread2.class.getName()).log(Level.SEVERE, null, ex);
       }
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