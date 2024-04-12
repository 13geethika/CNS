import java.security.*;
import javax.crypto.*;
import java.math.BigInteger;
import java.util.Base64;

public class DiffieHellmanExample {
    public static void main(String[] args) throws Exception {
        KeyPair aliceKeyPair = generateKeyPair();
        KeyPair bobKeyPair = generateKeyPair();

        byte[] aliceSharedSecret = generateSharedSecret(aliceKeyPair, bobKeyPair.getPublic());
        byte[] bobSharedSecret = generateSharedSecret(bobKeyPair, aliceKeyPair.getPublic());

        String aliceSharedSecretBase64 = bytesToBase64(aliceSharedSecret);
        String bobSharedSecretBase64 = bytesToBase64(bobSharedSecret);

        System.out.println(aliceSharedSecretBase64.equals(bobSharedSecretBase64) ? "Shared secrets match!" : "Shared secrets do not match!");
        System.out.println("Shared secret (Alice): " + aliceSharedSecretBase64);
        System.out.println("Shared secret (Bob): " + bobSharedSecretBase64);
    }

    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DH");
        keyPairGenerator.initialize(2048); // Using default parameters
        return keyPairGenerator.generateKeyPair();
    }

    public static byte[] generateSharedSecret(KeyPair keyPair, PublicKey publicKey) throws Exception {
        KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
        keyAgreement.init(keyPair.getPrivate());
        keyAgreement.doPhase(publicKey, true);
        return keyAgreement.generateSecret();
    }

    public static String bytesToBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }
}
