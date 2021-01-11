package rijndael.crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sulthan
 */
public class FileEncryption
{
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date date = new Date(System.currentTimeMillis());
 
  public static String encoder(String imagePath) throws Exception
  {
    String base64Image = "";
    File file = new File(imagePath);
    
    try (FileInputStream imageInFile = new FileInputStream(file))
    {
      // Reading a Image file from file system
      byte imageData[] = new byte[(int) file.length()];
      imageInFile.read(imageData);
      base64Image = Base64.getEncoder().encodeToString(imageData);
    }
    catch (FileNotFoundException e)
    {
        Logger.getLogger(FileEncryption.class.getName()).log(Level.SEVERE, null, e);
    }
    catch (IOException e)
    {
        Logger.getLogger(FileEncryption.class.getName()).log(Level.SEVERE, null, e);
    }
    return base64Image;
  }
 
  public void decoder(String base64Image, String pathFile)
  {
    try (FileOutputStream imageOutFile = new FileOutputStream(pathFile))
    {
      // Converting a Base64 String into Image byte array
      byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
      imageOutFile.write(imageByteArray);
      
      String fileName = "Result file - "  + date + ".zip";

      FileOutputStream fos = new FileOutputStream("/home/sulthan/Documents/Skripsi/Program/data/Decoded/"+fileName, true);
      fos.write(imageByteArray);
    }
    catch (FileNotFoundException e) {
        Logger.getLogger(FileEncryption.class.getName()).log(Level.SEVERE, null, e);
    }
    catch (IOException e) {
        Logger.getLogger(FileEncryption.class.getName()).log(Level.SEVERE, null, e);
    }
  }
}
