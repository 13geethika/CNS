import java.security.*;
import javax.crypto.*;
public class PKCS1_5Example {
    public static void main(String[] args) throws Exception {
        KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        String message = "Hello, this is a secret message!";
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedMessage = cipher.doFinal(message.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        String decryptedMessage = new String(cipher.doFinal(encryptedMessage));
        System.out.println("Encrypted message: " + bytesToHex(encryptedMessage));
        System.out.println("Decrypted message: " + decryptedMessage);
    }
    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) result.append(String.format("%02X", b));
        return result.toString();
    }
}
