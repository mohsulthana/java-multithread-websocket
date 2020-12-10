/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rijndael.thread;

import java.io.IOException;
import static java.lang.String.format;
import rijndael.crypto.FileEncryption;
import rijndael.util.CryptoUtils;
import rijndael.crypto.EncryptorAesGcm;
import java.net.URISyntaxException;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.websocket.DeploymentException;
import javax.websocket.OnMessage;
import static rijndael.thread.Rijndael.waitThreadEnd;
import static rijndael.util.TextUtil.doSplit;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author sulthan
 */
public class ChatFrameSender extends javax.swing.JFrame {
    public long startEnc;
    public long elapsedTimeEnc;
    public String teks;
    public String OUTPUT_FORMAT = "%-30s:%s";
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date date = new Date(System.currentTimeMillis());

    public ChatFrameSender() throws URISyntaxException, DeploymentException, NoSuchAlgorithmException {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kirimSingleThread = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        logArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pengirimField = new javax.swing.JTextArea();
        kirimPengirim1 = new javax.swing.JButton();
        kirimPengirim2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        penerima = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        waktuDekripsi = new javax.swing.JLabel();
        waktuEnkripsi = new javax.swing.JLabel();
        waktuPengirimanPesan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kirimSingleThread.setText("Kirim - 1");
        kirimSingleThread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kirimSingleThreadActionPerformed(evt);
            }
        });

        logArea.setColumns(20);
        logArea.setRows(5);
        jScrollPane1.setViewportView(logArea);

        jLabel1.setText("Pengirim");

        pengirimField.setColumns(20);
        pengirimField.setRows(5);
        jScrollPane2.setViewportView(pengirimField);

        kirimPengirim1.setText(" Kirim - 2");
        kirimPengirim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kirimPengirim1ActionPerformed(evt);
            }
        });

        kirimPengirim2.setText("Kirim - 3");
        kirimPengirim2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kirimPengirim2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Logger");

        jButton1.setText("Select File - 1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        penerima.setColumns(20);
        penerima.setRows(5);
        jScrollPane4.setViewportView(penerima);

        jLabel5.setText("Penerima");

        jButton2.setText("Select File - 2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Select File - 3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Waktu enkripsi");

        jLabel3.setText("Waktu dekripsi");

        jLabel6.setText("Waktu pengiriman pesan");

        waktuDekripsi.setText("0s");

        waktuEnkripsi.setText("0s");

        waktuPengirimanPesan.setText("0s");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel1))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(kirimSingleThread, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(kirimPengirim1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(kirimPengirim2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel4))
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(waktuPengirimanPesan)
                                    .addComponent(waktuEnkripsi)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(waktuDekripsi)))
                                .addGap(71, 71, 71))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kirimSingleThread)
                    .addComponent(kirimPengirim1)
                    .addComponent(kirimPengirim2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(waktuPengirimanPesan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jLabel2)
                            .addComponent(waktuEnkripsi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(waktuDekripsi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kirimSingleThreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kirimSingleThreadActionPerformed
        // TODO add your handling code here:
        try
        {
            teks = pengirimField.getText();
            startEnc = System.currentTimeMillis();
            EncryptorAesGcm aes = new EncryptorAesGcm();
            byte[] encryptedText = aes.encryptWithPrefixIV(teks.getBytes(UTF_8));
            elapsedTimeEnc = System.currentTimeMillis() - startEnc;

            logArea.setText("\n------ AES GCM Encryption ------\n");
            logArea.append(String.format(OUTPUT_FORMAT, "Input (plain text)", teks) + "\n");
            logArea.append(String.format(OUTPUT_FORMAT, "Encrypted (hex) ", CryptoUtils.hex(encryptedText))  + "\n");
            logArea.append(String.format(OUTPUT_FORMAT, "Encrypted (hex) (block = 16)", CryptoUtils.hexWithBlockSize(encryptedText, 16))  + "\n");

            double elapsedTimeInSecondEnc = (double) elapsedTimeEnc / 1000F;
            waktuEnkripsi.setText(Double.toString(elapsedTimeInSecondEnc) + " detik");

            long startDec = System.currentTimeMillis();
            String decryptedText = aes.decryptWithPrefixIV(encryptedText);
            long elapsedTimeDec = System.currentTimeMillis() - startDec;
            double elapsedTimeInSecondDec = (double) elapsedTimeDec / 1000F;
            waktuDekripsi.setText(Double.toString(elapsedTimeInSecondDec) + " detik");

            long elapsedTimeTotal = System.currentTimeMillis() - startEnc;
            waktuPengirimanPesan.setText(Double.toString((double) elapsedTimeTotal / 1000F) + " detik");

            
            logArea.append("\n\n------ AES GCM Decryption ------\n");
            logArea.append(String.format(OUTPUT_FORMAT, "Input (hex)", CryptoUtils.hex(encryptedText))  + "\n");
            logArea.append(String.format(OUTPUT_FORMAT, "Input (hex) (block = 16)", CryptoUtils.hexWithBlockSize(encryptedText, 16))  + "\n");
            logArea.append(String.format(OUTPUT_FORMAT, "Key (hex)", CryptoUtils.hex(aes.secretKey.getEncoded())));
            logArea.append(String.format(OUTPUT_FORMAT, "Decrypted (plain text)", decryptedText)  + "\n");

            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            penerima.append(format("[%s:%s] %s", formatter.format(date), "Sulthan", decryptedText) + "\n");
            pengirimField.setText("");
        }
        catch (NoSuchAlgorithmException ex)
        {
            Logger.getLogger(ChatFrameSender.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception ex)
        {
            Logger.getLogger(ChatFrameSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kirimSingleThreadActionPerformed

    @OnMessage
    private void kirimPengirim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kirimPengirim1ActionPerformed
        String plaintext    = pengirimField.getText();
        List<String> teks_part = doSplit(plaintext, 2);
        
        try {
            // BUAT AES SEBANYAK JUMLAH THREAD
            List<EncryptorAesGcm> aes = new ArrayList<EncryptorAesGcm>();
            for (int i = 0; i < 2; i++) {
                aes.add(new EncryptorAesGcm());
            }
            long startEnc = System.currentTimeMillis();
                   
            // CREATE THREAD FOR ENCRYPTION
            List<MyThread2> ThreadEncrypt = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                byte[] plain = teks_part.get(i).getBytes(UTF_8);
                ThreadEncrypt.add(new MyThread2(
                        aes.get(i),
                        "Thread-"+(i+1),
                        plain,
                        "e"
                ));
                ThreadEncrypt.get(i).start();
            }
            
            waitThreadEnd(ThreadEncrypt); // TUNGGU THREAD SELESAI
            long elapsedTimeEnc = System.currentTimeMillis() - startEnc;
            double elapsedTimeInSecondEnc = (double) elapsedTimeEnc / 1000F;
            
            // HASIL ENKRIPSI
            byte[] encryptedText = new byte[0];
            for (int i = 0; i < 2; i++){
                byte[] c = new byte[encryptedText.length + ThreadEncrypt.get(i).cipher.length];
                System.arraycopy(encryptedText, 0, c, 0, encryptedText.length);
                System.arraycopy(ThreadEncrypt.get(i).cipher, 0, c, encryptedText.length, ThreadEncrypt.get(i).cipher.length);
                encryptedText = c;
            }
            long startDec = System.currentTimeMillis();
            
            // CREATE THREAD FOR DECRYPTION
            List<MyThread2> ThreadDecrypt = new ArrayList<>();
            for (int i = 0; i < ThreadEncrypt.size(); i++) {
                ThreadDecrypt.add(new MyThread2(
                        aes.get(i),
                        "Thread-"+(i+1),
                        ThreadEncrypt.get(i).cipher,
                        "d"
                ));
                ThreadDecrypt.get(i).start();
            }
            
            waitThreadEnd(ThreadDecrypt); // TUNGGU THREAD SELESAI
            long elapsedTimeDec = System.currentTimeMillis() - startDec;
            double elapsedTimeInSecondDec = (double) elapsedTimeDec / 1000F;
            long elapsedTimeTotal = System.currentTimeMillis() - startEnc; // FULL TIME
            
            // HASIL DEKRIPSI
            String decryptedText = "";
            for (int i = 0; i < 2; i++)
                decryptedText += ThreadDecrypt.get(i).plain;
            
            // SET TEXT SECTION
            waktuEnkripsi.setText(Double.toString(elapsedTimeInSecondEnc) + " detik");
            waktuDekripsi.setText(Double.toString(elapsedTimeInSecondDec) + " detik");
            waktuPengirimanPesan.setText(Double.toString((double) elapsedTimeTotal / 1000F) + " detik");

            logArea.setText("\n------ AES GCM Encryption ------\n");
            logArea.append(String.format(OUTPUT_FORMAT, "Input (plain text)", plaintext) + "\n");
            logArea.append(String.format(OUTPUT_FORMAT, "Encrypted (hex) ", CryptoUtils.hex(encryptedText))  + "\n");
            logArea.append(String.format(OUTPUT_FORMAT, "Encrypted (hex) (block = 16)", CryptoUtils.hexWithBlockSize(encryptedText, 16))  + "\n");
            
            penerima.append(format("[%s:%s] %s", formatter.format(date), "Sulthan", decryptedText) + "\n");
            pengirimField.setText("");
            
            logArea.append("\n\n------ AES GCM Decryption ------\n");
            logArea.append(String.format(OUTPUT_FORMAT, "Input (hex)", CryptoUtils.hex(encryptedText))  + "\n");
            logArea.append(String.format(OUTPUT_FORMAT, "Input (hex) (block = 16)", CryptoUtils.hexWithBlockSize(encryptedText, 16))  + "\n");
            logArea.append(String.format(OUTPUT_FORMAT, "Decrypted (plain text)", decryptedText)  + "\n");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ChatFrameSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kirimPengirim1ActionPerformed

    private void kirimPengirim2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kirimPengirim2ActionPerformed
        
        String plaintext    = pengirimField.getText();
        List<String> teks_part = doSplit(plaintext, 3);
        
        try {
            // BUAT AES SEBANYAK JUMLAH THREAD
            List<EncryptorAesGcm> aes = new ArrayList<EncryptorAesGcm>();
            for (int i = 0; i < 3; i++) {
                aes.add(new EncryptorAesGcm());
            }
            long startEnc = System.currentTimeMillis();
                   
            // CREATE THREAD FOR ENCRYPTION
            List<MyThread2> ThreadEncrypt = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                byte[] plain = teks_part.get(i).getBytes(UTF_8);
                ThreadEncrypt.add(new MyThread2(
                        aes.get(i),
                        "Thread-"+(i+1),
                        plain,
                        "e"
                ));
                ThreadEncrypt.get(i).start();
            }
            
            waitThreadEnd(ThreadEncrypt); // TUNGGU THREAD SELESAI
            long elapsedTimeEnc = System.currentTimeMillis() - startEnc;
            double elapsedTimeInSecondEnc = (double) elapsedTimeEnc / 1000F;

            // HASIL ENKRIPSI
            byte[] encryptedText = new byte[0];
            for (int i = 0; i < 2; i++){
                byte[] c = new byte[encryptedText.length + ThreadEncrypt.get(i).cipher.length];
                System.arraycopy(encryptedText, 0, c, 0, encryptedText.length);
                System.arraycopy(ThreadEncrypt.get(i).cipher, 0, c, encryptedText.length, ThreadEncrypt.get(i).cipher.length);
                encryptedText = c;
            }
            
            long startDec = System.currentTimeMillis();
            
            List<MyThread2> ThreadDecrypt = new ArrayList<>(); // CREATE THREAD FOR DECRYPTION
            for (int i = 0; i < ThreadEncrypt.size(); i++) {
                ThreadDecrypt.add(new MyThread2(
                        aes.get(i),
                        "Thread-"+(i+1),
                        ThreadEncrypt.get(i).cipher,
                        "d"
                ));
                ThreadDecrypt.get(i).start();
            }
            
            waitThreadEnd(ThreadDecrypt); // TUNGGU THREAD SELESAI
            
            // HASIL DEKRIPSI
            String decryptedText = "";
            for (int i = 0; i < 2; i++)
                decryptedText += ThreadDecrypt.get(i).plain;
            
            long elapsedTimeDec = System.currentTimeMillis() - startDec;
            double elapsedTimeInSecondDec = (double) elapsedTimeDec / 1000F;
            long elapsedTimeTotal = System.currentTimeMillis() - startEnc; // FULL TIME
            
            // SET TEXT SECTION
            waktuEnkripsi.setText(Double.toString(elapsedTimeInSecondEnc) + " detik");
            waktuDekripsi.setText(Double.toString(elapsedTimeInSecondDec) + " detik");
            waktuPengirimanPesan.setText(Double.toString((double) elapsedTimeTotal / 1000F) + " detik");

            logArea.setText("\n------ AES GCM Encryption ------\n");
            logArea.append(String.format(OUTPUT_FORMAT, "Input (plain text)", plaintext) + "\n");
            logArea.append(String.format(OUTPUT_FORMAT, "Encrypted (hex) ", CryptoUtils.hex(encryptedText))  + "\n");
            logArea.append(String.format(OUTPUT_FORMAT, "Encrypted (hex) (block = 16)", CryptoUtils.hexWithBlockSize(encryptedText, 16))  + "\n");
            
            penerima.append(format("[%s:%s] %s", formatter.format(date), "Sulthan", decryptedText) + "\n");
            pengirimField.setText("");
            
            logArea.append("\n\n------ AES GCM Decryption ------\n");
            logArea.append(String.format(OUTPUT_FORMAT, "Input (hex)", CryptoUtils.hex(encryptedText))  + "\n");
            logArea.append(String.format(OUTPUT_FORMAT, "Input (hex) (block = 16)", CryptoUtils.hexWithBlockSize(encryptedText, 16))  + "\n");
            logArea.append(String.format(OUTPUT_FORMAT, "Decrypted (plain text)", decryptedText)  + "\n");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ChatFrameSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kirimPengirim2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("ZIP Files", "zip");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                String imagePath = chooser.getSelectedFile().getAbsolutePath();
                String base64Image = FileEncryption.encoder(imagePath);
                
                EncryptorAesGcm aes = new EncryptorAesGcm();
                long startEnc = System.currentTimeMillis();                
                
                byte[] encryptedText = aes.encryptWithPrefixIV(base64Image.getBytes(UTF_8));
                
                long elapsedTimeEnc = System.currentTimeMillis() - startEnc;
                double elapsedTimeInSecondEnc = (double) elapsedTimeEnc / 1000F;

                long startDec = System.currentTimeMillis();
                
                String decryptedText = aes.decryptWithPrefixIV(encryptedText);
                
                long elapsedTimeDec = System.currentTimeMillis() - startDec;
                double elapsedTimeInSecondDec = (double) elapsedTimeDec / 1000F;
                
                long elapsedTimeTotal = System.currentTimeMillis() - startEnc;

                
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                Date date = new Date(System.currentTimeMillis());
                
                // SET TEXT SECTION                
                waktuEnkripsi.setText(Double.toString(elapsedTimeInSecondEnc) + " detik");
                waktuPengirimanPesan.setText(Double.toString((double) elapsedTimeTotal / 1000F) + " detik");
                waktuDekripsi.setText(Double.toString(elapsedTimeInSecondDec) + " detik");

                logArea.setText("\n------ AES GCM Encryption File Single Thread ------\n");
                logArea.append(String.format(OUTPUT_FORMAT, "Input (plain text)", base64Image) + "\n");
                logArea.append(String.format(OUTPUT_FORMAT, "Encrypted (hex) ", CryptoUtils.hex(encryptedText))  + "\n");
                logArea.append(String.format(OUTPUT_FORMAT, "Encrypted (hex) (block = 16)", CryptoUtils.hexWithBlockSize(encryptedText, 16))  + "\n");

                logArea.append("\n\n------ AES GCM Decryption File Single Thread ------\n");
                logArea.append(String.format(OUTPUT_FORMAT, "Input (hex)", CryptoUtils.hex(encryptedText))  + "\n");
                logArea.append(String.format(OUTPUT_FORMAT, "Input (hex) (block = 16)", CryptoUtils.hexWithBlockSize(encryptedText, 16))  + "\n");
                logArea.append(String.format(OUTPUT_FORMAT, "Decrypted (plain text)", decryptedText)  + "\n");
                penerima.append(format("[%s:%s] %s", formatter.format(date), "Sulthan", decryptedText) + "\n");
            }
            catch (Exception ex)
            {
                Logger.getLogger(ChatFrameSender.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("ZIP", "zip");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            String imagePath = chooser.getSelectedFile().getAbsolutePath();
            String base64Image = FileEncryption.encoder(imagePath);
            
            // INIT VARIABLE
            String plaintext    = base64Image;
            int jumlah_thread   = 2;
            // SPLIT TEKS
            List<String> teks_part = doSplit(plaintext, jumlah_thread);

            try {
                // BUAT AES SEBANYAK JUMLAH THREAD
                List<EncryptorAesGcm> aes = new ArrayList<>();
                for (int i = 0; i < jumlah_thread; i++) {
                    aes.add(new EncryptorAesGcm());
                }
                
                long startEnc = System.currentTimeMillis();
                // CREATE THREAD FOR ENCRYPTION
                List<MyThread2> ThreadEncrypt = new ArrayList<>();
                for (int i = 0; i < jumlah_thread; i++) {
                    byte[] plain = teks_part.get(i).getBytes(UTF_8);
                    ThreadEncrypt.add(new MyThread2(
                            aes.get(i),
                            "Thread-"+(i+1),
                            plain,
                            "e"
                    ));
                    ThreadEncrypt.get(i).start();
                }
                // TUNGGU THREAD SELESAI
                waitThreadEnd(ThreadEncrypt);
                
                long elapsedTimeEnc = System.currentTimeMillis() - startEnc;
                double elapsedTimeInSecondEnc = (double) elapsedTimeEnc / 1000F;
                waktuEnkripsi.setText(Double.toString(elapsedTimeInSecondEnc) + " detik");
                long startDec = System.currentTimeMillis();
                // CREATE THREAD FOR DECRYPTION
                List<MyThread2> ThreadDecrypt = new ArrayList<>();
                for (int i = 0; i < ThreadEncrypt.size(); i++) {
                    ThreadDecrypt.add(new MyThread2(
                            aes.get(i),
                            "Thread-"+(i+1),
                            ThreadEncrypt.get(i).cipher,
                            "d"
                    ));
                    ThreadDecrypt.get(i).start();
                }
                // TUNGGU THREAD SELESAI
                waitThreadEnd(ThreadDecrypt);
                
                long elapsedTimeDec = System.currentTimeMillis() - startDec;
                double elapsedTimeInSecondDec = (double) elapsedTimeDec / 1000F;
                waktuDekripsi.setText(Double.toString(elapsedTimeInSecondDec) + " detik");
                
                long elapsedTimeTotal = System.currentTimeMillis() - startEnc;
                waktuPengirimanPesan.setText(Double.toString((double) elapsedTimeTotal / 1000F) + " detik");

            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ChatFrameSender.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("ZIP", "zip");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            String imagePath = chooser.getSelectedFile().getAbsolutePath();
            String base64Image = FileEncryption.encoder(imagePath);
            
            // INIT VARIABLE
            String plaintext    = base64Image;
            int jumlah_thread   = 3;
            // SPLIT TEKS
            List<String> teks_part = doSplit(plaintext, jumlah_thread);

            try {
                // BUAT AES SEBANYAK JUMLAH THREAD
                List<EncryptorAesGcm> aes = new ArrayList<EncryptorAesGcm>();
                for (int i = 0; i < jumlah_thread; i++) {
                    aes.add(new EncryptorAesGcm());
                }
                
                long startEnc = System.currentTimeMillis();
                // CREATE THREAD FOR ENCRYPTION
                List<MyThread2> ThreadEncrypt = new ArrayList<>();
                for (int i = 0; i < jumlah_thread; i++) {
                    byte[] plain = teks_part.get(i).getBytes(UTF_8);
                    ThreadEncrypt.add(new MyThread2(
                            aes.get(i),
                            "Thread-"+(i+1),
                            plain,
                            "e"
                    ));
                    ThreadEncrypt.get(i).start();
                }
                // TUNGGU THREAD SELESAI
                waitThreadEnd(ThreadEncrypt);
                
                long elapsedTimeEnc = System.currentTimeMillis() - startEnc;
                double elapsedTimeInSecondEnc = (double) elapsedTimeEnc / 1000F;
                waktuEnkripsi.setText(Double.toString(elapsedTimeInSecondEnc) + " detik");
                long startDec = System.currentTimeMillis();
                // CREATE THREAD FOR DECRYPTION
                List<MyThread2> ThreadDecrypt = new ArrayList<>();
                for (int i = 0; i < ThreadEncrypt.size(); i++) {
                    ThreadDecrypt.add(new MyThread2(
                            aes.get(i),
                            "Thread-"+(i+1),
                            ThreadEncrypt.get(i).cipher,
                            "d"
                    ));
                    ThreadDecrypt.get(i).start();
                }
                // TUNGGU THREAD SELESAI
                waitThreadEnd(ThreadDecrypt);
                
                long elapsedTimeDec = System.currentTimeMillis() - startDec;
                double elapsedTimeInSecondDec = (double) elapsedTimeDec / 1000F;
                waktuDekripsi.setText(Double.toString(elapsedTimeInSecondDec) + " detik");
                
                long elapsedTimeTotal = System.currentTimeMillis() - startEnc;
                waktuPengirimanPesan.setText(Double.toString((double) elapsedTimeTotal / 1000F) + " detik");

            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ChatFrameSender.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws URISyntaxException, DeploymentException, IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatFrameSender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatFrameSender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatFrameSender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatFrameSender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ChatFrameSender().setVisible(true);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(ChatFrameSender.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DeploymentException ex) {
                    Logger.getLogger(ChatFrameSender.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(ChatFrameSender.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton kirimPengirim1;
    private javax.swing.JButton kirimPengirim2;
    private javax.swing.JButton kirimSingleThread;
    public javax.swing.JTextArea logArea;
    public javax.swing.JTextArea penerima;
    public javax.swing.JTextArea pengirimField;
    public javax.swing.JLabel waktuDekripsi;
    public javax.swing.JLabel waktuEnkripsi;
    public javax.swing.JLabel waktuPengirimanPesan;
    // End of variables declaration//GEN-END:variables
}
