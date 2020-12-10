package rijndael.client;

import com.sun.tools.javac.util.StringUtils;
import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.security.NoSuchAlgorithmException;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import rijndael.crypto.EncryptorAesGcm;
import rijndael.model.Message;
import rijndael.model.MessageDecoder;
import rijndael.model.MessageEncoder;
import rijndael.thread.ChatFrameSender;
import rijndael.thread.MyThread2;
import rijndael.util.CryptoUtils;
import static rijndael.util.TextUtil.doSplit;
import rijndael.thread.Rijndael;

@javax.websocket.ClientEndpoint(encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ClientEndpoint {
    public ChatFrameSender frame;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    private String OUTPUT_FORMAT = "%-30s:%s";

    @OnOpen
    public void onOpen(Session session) {
        System.out.println(format("Connection established. session id: %s", session.getId()));
    }

    @OnMessage
    public void onMessage(Message message) throws NoSuchAlgorithmException, Exception {
        int jumlah_thread = Integer.parseInt(message.getContent().substring(message.getContent().length() - 1));
        String encryptedMessage = message.getContent().substring(0, message.getContent().length() - 1);
        byte[] decodedMessage = Base64.getDecoder().decode(encryptedMessage);
        
        if (jumlah_thread == 1) {
            long elapsedTimeEnc = System.currentTimeMillis() - frame.startEnc;
            frame.logArea.append("\n\n------ AES GCM Decryption ------\n");
            frame.logArea.append(String.format(OUTPUT_FORMAT, "Input (hex)", CryptoUtils.hex(message.getContent().getBytes(UTF_8)))  + "\n");
            frame.logArea.append(String.format(OUTPUT_FORMAT, "Input (hex) (block = 16)", CryptoUtils.hexWithBlockSize(message.getContent().getBytes(UTF_8), 16))  + "\n");

            double elapsedTimeInSecondEnc = (double) elapsedTimeEnc / 1000F;
            frame.waktuEnkripsi.setText(Double.toString(elapsedTimeInSecondEnc) + " detik");

            long startDec = System.currentTimeMillis();
            String decryptedText = frame.aes.decryptWithPrefixIV(Base64.getDecoder().decode(encryptedMessage));

            long elapsedTimeDec = System.currentTimeMillis() - startDec;
            double elapsedTimeInSecondDec = (double) elapsedTimeDec / 1000F;
            frame.waktuDekripsi.setText(Double.toString(elapsedTimeInSecondDec) + " detik");

            long elapsedTimeTotal = System.currentTimeMillis() - frame.startEnc;
            frame.waktuPengirimanPesan.setText(Double.toString((double) elapsedTimeTotal / 1000F) + " detik");

            frame.logArea.append(String.format(OUTPUT_FORMAT, "Decrypted (plain text)", decryptedText)  + "\n");
            frame.penerima.append(format("[%s:%s] %s", simpleDateFormat.format(message.getReceived()), message.getSender(), decryptedText) + "\n");
        } else if (jumlah_thread == 2) {
            long startDec = System.currentTimeMillis();
            // CREATE THREAD FOR DECRYPTION
            
            byte[][] totalByte = new byte[jumlah_thread][decodedMessage.length / jumlah_thread];
            System.arraycopy(decodedMessage, 0, totalByte[0] ,0, decodedMessage.length / jumlah_thread);
            System.arraycopy(decodedMessage, 1 * decodedMessage.length / jumlah_thread, totalByte[1], 0, decodedMessage.length / jumlah_thread);
//            List<String> teks_part = doSplit(decodedMessage.toString(),  2);
            List<EncryptorAesGcm> aes = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                System.out.println("masuk perulangan");
                aes.add(new EncryptorAesGcm(frame.aes.secretKey, frame.aes.iv));
            }
            
            System.out.println("enrkipsi masuk ke thread");
            
            List<MyThread2> ThreadDecrypt = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                ThreadDecrypt.add(new MyThread2(
                        aes.get(i),
                        "Thread-"+(i+1), totalByte[i],
                        "d"
                ));
                ThreadDecrypt.get(i).start();
            }
            
            // TUNGGU THREAD SELESAI
            Rijndael.waitThreadEnd(ThreadDecrypt);
            System.out.println("Thread selesai");
            
            byte[] hasilDekripsi = new byte[0];
            // HASIL ENKRIPSI
            for (int i = 0; i < 2; i++){
                byte[] c = new byte[hasilDekripsi.length + ThreadDecrypt.get(i).cipher.length];
                System.arraycopy(hasilDekripsi, 0, c, 0, hasilDekripsi.length);
                System.arraycopy(ThreadDecrypt.get(i).cipher, 0, c, hasilDekripsi.length, ThreadDecrypt.get(i).cipher.length);
                hasilDekripsi = c;
            }
            System.out.println(hasilDekripsi);
        } else {
            
        }
    }
}
