package rijndael.client;

import java.net.URI;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.websocket.Session;
import org.glassfish.tyrus.client.ClientManager;
import rijndael.crypto.EncryptorAesGcm;
import rijndael.thread.ChatFrameSender;

public class Client {

    public static final String SERVER = "ws://localhost:8025/ws/chat";

    public static void main(String[] args) throws Exception {
        ClientManager client = ClientManager.createClient();
        String message;
        
        byte[] encoded = "1234567891029384".getBytes();
        SecretKey secretKey = new SecretKeySpec(encoded, "AES");
        byte[] iv        = "123456789101".getBytes();
        EncryptorAesGcm aes = new EncryptorAesGcm(secretKey, iv);

        ClientEndpoint cep = new ClientEndpoint();
        Session session = (Session) client.connectToServer(cep, new URI(SERVER));
        ChatFrameSender cfs = new ChatFrameSender(session, aes);
        cfs.setVisible(true);
        cep.frame = cfs;
    }
}
