package rijndael.crypto;


import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import rijndael.util.CryptoUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sulthan
 */
public class EncryptorAesGcm {
    private static final String ENCRYPT_ALGO = "AES/GCM/NoPadding";
    private static final int TAG_LENGTH_BIT  = 128;
    private static final int IV_LENGTH_BYTE  = 12;
    private static final int AES_KEY_BIT     = 128;
    
    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    
    public static SecretKey secretKey;
    private static byte[] iv;
    
    public EncryptorAesGcm() throws NoSuchAlgorithmException{
//        secretKey = CryptoUtils.getAESKey(AES_KEY_BIT);
        byte[] encoded = "1234567891029384".getBytes();
        secretKey = new SecretKeySpec(encoded, "AES");
//        iv        = CryptoUtils.getRandomNonce(IV_LENGTH_BYTE);
        iv        = "123456789101".getBytes();
    }
    
    public static byte[] encrypt(byte[] pText) throws Exception
    {
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new GCMParameterSpec(TAG_LENGTH_BIT, iv));
        byte[] encryptedText = cipher.doFinal(pText);
        return encryptedText;
    }
    
    public static byte[] encryptWithPrefixIV(byte[] pText) throws Exception
    {
        
        byte[] cipherText = encrypt(pText);
        byte[] cipherTextWithIv = ByteBuffer.allocate(iv.length + cipherText.length)
                .put(iv)
                .put(cipherText)
                .array();
        return cipherTextWithIv;
    }
    
    public static String decrypt(byte[] cText) throws Exception
    {
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new GCMParameterSpec(TAG_LENGTH_BIT, iv));
        byte[] plainText = cipher.doFinal(cText);
        return new String(plainText, UTF_8);
        
//        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
//        cipher.init(Cipher.DECRYPT_MODE, secretKey, new GCMParameterSpec(TAG_LENGTH_BIT, iv));
//        ByteBuffer byteBuffer = ByteBuffer.wrap(cText);
//        byteBuffer.get(iv);
//        byte[] encrypted = new byte[byteBuffer.remaining()];
//        byteBuffer.get(encrypted);
//        
//        byte[] plainText = cipher.doFinal(encrypted);
//        return new String(plainText, UTF_8);
    }
    
    public static String decryptWithPrefixIV(byte[] cText) throws Exception
    {
        ByteBuffer bb =  ByteBuffer.wrap(cText);
        
        byte[] iv = new byte[IV_LENGTH_BYTE];
        bb.get(iv);
//        bb.get(iv, 0, iv.length);
        
        byte[] cipherText = new byte[bb.remaining()];
        bb.get(cipherText);
        
        String plainText = decrypt(cipherText);
                System.out.println(plainText);
        return plainText;
    }
    
    public static void main(String[] args) throws Exception
    {
        String OUTPUT_FORMAT = "%-30s:%s"; 
       
        String plainText = "Hello World AES-GCM, Welcome to Cryptography!";
        SecretKey secretKey = CryptoUtils.getAESKey(AES_KEY_BIT);
        
        byte[] encryptedText = EncryptorAesGcm.encryptWithPrefixIV(plainText.getBytes(UTF_8));
        
        System.out.println("\n------ AES GCM Encryption ------");
        System.out.println(String.format(OUTPUT_FORMAT, "Input (plain text)", plainText));
        System.out.println(String.format(OUTPUT_FORMAT, "Key (hex)", CryptoUtils.hex(secretKey.getEncoded())));
        System.out.println(String.format(OUTPUT_FORMAT, "Encrypted (hex) ", CryptoUtils.hex(encryptedText)));
        System.out.println(String.format(OUTPUT_FORMAT, "Encrypted (hex) (block = 16)", CryptoUtils.hexWithBlockSize(encryptedText, 16)));
        
        System.out.println("\n------ AES GCM Decryption ------");
        System.out.println(String.format(OUTPUT_FORMAT, "Input (hex)", CryptoUtils.hex(encryptedText)));
        System.out.println(String.format(OUTPUT_FORMAT, "Input (hex) (block = 16)", CryptoUtils.hexWithBlockSize(encryptedText, 16)));
        System.out.println(String.format(OUTPUT_FORMAT, "Key (hex)", CryptoUtils.hex(secretKey.getEncoded())));
        
        String decryptedText = EncryptorAesGcm.decryptWithPrefixIV(encryptedText);
        
        System.out.println(String.format(OUTPUT_FORMAT, "Decrypted (plain text)", decryptedText));
        
    }
}
