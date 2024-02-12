import java.util.Scanner;
public class ED{
  public static void main(String[] args) {
        String Sc="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s="abcdefghijklmnopqrstuvwxyz";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Input text");
        String inputext=sc.nextLine();
        System.out.println("Enter the secret key");
        int ky=sc.nextInt();
        String cipherext="";
        for(int i=0;i<inputext.length();i++){
            char a=inputext.charAt(i);
            if(Character.isUpperCase(a)){
                cipherext+=Sc.charAt((Sc.indexOf(a)+ky)%26);
            }
            else{
                cipherext+=s.charAt((s.indexOf(a)+ky)%26);
            }
        }
        System.out.println(" Encrypted Cipher text is "+cipherext);
        System.out.println("Enter the Input text");
        String inputtext=sc.next();
        System.out.println("Enter the secret key");
        int key=sc.nextInt();
        String ciphertext="";
        for(int i=0;i<inputtext.length();i++){
            char a=inputtext.charAt(i);
            int b=0;
            if(Character.isUpperCase(a)){
                b=(Sc.indexOf(a)-key)%26;
                if(b<0)
                ciphertext+=Sc.charAt(b+26);
                else
                 ciphertext+=Sc.charAt(b);
            }
            else{
                b=(s.indexOf(a)-key)%26;
                if(b<0)
                ciphertext+=s.charAt(b+26);
                else
                 ciphertext+=s.charAt(b);
            }
        }
        System.out.println("Decrypted Plain Text is "+ciphertext);
    }
}
