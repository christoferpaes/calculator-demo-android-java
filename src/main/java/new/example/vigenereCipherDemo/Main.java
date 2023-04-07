/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.regex.Matcher; 
import java.util.regex.Pattern;

public class Main
{
	public static void main(String[] args) {
	    String l = " At t ack@";
	    String k = "LEMON"; 
	    
	    char[] encryptMsg =encrypt(l,k);
	    
		System.out.println(encryptMsg);
      char [] decryptMsg  = decrypt(encryptMsg, k
      ); 
      System.out.println(decryptMsg); 
	}
	public static char[] encrypt(String plaintext, String keyword)
    {
        //Converting plaintext to char array
        
     
      
        System.out.println(plaintext);
       
        char msg;
        
        String textPlain = new String("");
        String textPlain2 = new String("");
       Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
       Matcher matcher = pattern.matcher(plaintext);
         boolean isStringContainsSpecialCharacter = matcher.find();
     
        for(int j = 0 ; j< plaintext.length() ; ++j){    
         if(checkIfWhiteSpace(plaintext, j)) {
             textPlain = plaintext.replaceAll("\\s", "");
            }
            else if(isStringContainsSpecialCharacter){
            textPlain = plaintext.replaceAll("[^a-zA-Z]", "") ;   
            }
            
            }
        
         int b = textPlain.length();
        char msgArray [] = new char[b ];
        System.out.println(textPlain);
        for(int i = 0 ; i < textPlain.length(); ++i)  {
           
            
            if(checkIfLowerCase(textPlain, i))  {
                msg = checkAndConvertToUpperCase(textPlain.charAt(i));
                System.out.println(msg+ "this is the line for debugging######2");
          msgArray[i]  = msg;
          
            }
            else {
                 msg = textPlain.charAt(i) ;
           msgArray[i]  = msg;
           System.out.println(msg+ "this is the line for debugging###########3");
            }
           
     
        }
       System.out.println(msgArray[1]+ "this is the line for debugging###########3");
        int i,j;

        // Creating new char arrays
        char key[] = new char[b];
        char encryptedMsg[] = new char[b];
        for(i = 0, j = 0; i < b; ++i, ++j)
        {
            if(j == keyword.length())
            {
                j = 0;
            }
            key[i] = keyword.charAt(j);

        }

        //encryption code
        for(i = 0; i < b; ++i)
            encryptedMsg[i] = (char) (((msgArray[i] + key[i]) % 26) + 'A');
        System.out.println(encryptedMsg);
    return encryptedMsg;
    }


    public static char[] decrypt(char encryptedMsg[], String keyword)
    {
        //Converting plaintext to char array

        int msgLen = encryptedMsg.length;
        int i,j;

        // Creating new char arrays
        char key[] = new char[msgLen];
        char decryptedMsg[] = new char[msgLen];
        for(i = 0, j = 0; i < msgLen; ++i, ++j)
        {
            if(j == keyword.length())
            {
                j = 0;
            }
            key[i] = keyword.charAt(j);
            System.out.println("\n"+key[i]);
        }


        //decryption code
        for(i = 0; i < msgLen; ++i)
            decryptedMsg[i] = (char)((((encryptedMsg[i] - key[i]) + 26) % 26) + 'A');


    return decryptedMsg;}

public static boolean checkIfLowerCase(String a, int i ) { 
    int l = a.codePointAt(i) ;
     if(l>= 97 && l<=122)   {
         return true;
     }
     else{
         return false;
     }
}



    public static char checkAndConvertToUpperCase(char a)  {
        char ch;
        int temp;
        temp = (int) a;
        if(temp>= 97 && temp<= 122) {
            temp = temp - 32;
            ch = (char) temp;
            return ch;
        }
        else{
            return a;
        }
    }
    public static char checkAndConvertToLowerCase(char a ) {
        char ch;
        int temp;
        temp = (int) a;

        if(temp>=65 && temp<=90) {

            temp = temp - 32;
            ch = (char) temp;
            return ch;
        }
        else{
            return a;
        }
    }
    public static boolean checkIfWhiteSpace(String a, int i) {
        int l = a.codePointAt(i);
       if(l==32) {
           return true;
       }
       else{
           return false;
       }
    }
    public static char removeWhiteSpace(char a ) {
        char ch;
        int temp;
        temp = (int) a;

        if(temp>=0 && temp<=32) {

            temp = 0;
            ch = (char) temp;
            return ch;
        }
        else{
              temp = 0;
            ch = (char) temp;
            return ch;
            
        }
    }
}
