package Utils;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class hashPass {

    public static String doHash(String passWord) {
        try {
            MessageDigest messageDisget = MessageDigest.getInstance("MD5");
            messageDisget.update(passWord.getBytes());
            byte[] resultByteArray = messageDisget.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : resultByteArray) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
   

}
