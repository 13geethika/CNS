import java.util.Scanner;
public class CryptAnalysis{
  public static void main(String[] args) {
        String Sc="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s="abcdefghijklmnopqrstuvwxyz";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Input text");
        String it=sc.nextLine();
        it = it.replaceAll(" ", "");
        System.out.println("Enter the secret key");
        int k=sc.nextInt();
        String ct="";
        for(int i=0;i<it.length();i++){
            char a=it.charAt(i);
            if(Character.isSpaceChar(a)){
              ct+=" ";}
            if(Character.isUpperCase(a)){
                ct+=Sc.charAt((Sc.indexOf(a)+k)%26);
            }
            else{
                ct+=s.charAt((s.indexOf(a)+k)%26);
            }
        }
        System.out.println("Cipher text is "+ct);
        System.out.println("CryptAnalysis.....");
        for(int key=1;key<27;key++){
            String pt="";
            for(int i=0;i<ct.length();i++){
                char ai=ct.charAt(i);
                int b=0;
               // if(ai==s.charAt(key-1))
                //  pt+=" ";
                if(ai==' '){
                   pt+=" ";
                }
                else if(Character.isUpperCase(ai)){
                    b=(Sc.indexOf(ai)-key)%26;
                    if(b<0)
                      pt+=Sc.charAt(b+26);
                   else
                      pt+=Sc.charAt(b);
                }
                else{
                    b=(s.indexOf(ai)-key)%26;
                    if(b<0)
                      pt+=s.charAt(b+26);
                    else
                        pt+=s.charAt(b);
                }
           }
           System.out.println("At key "+key+" The plaintext is "+pt);
          if(pt.equals(it)){
                  System.out.println("Plain text is matched at the key "+key+" and the plaintext is "+pt);
                  return;
          }
        }
    }
}
