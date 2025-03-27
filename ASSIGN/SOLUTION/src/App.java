import java.io.FileReader; 
import java.io.PrintWriter;
import java.math.BigInteger;
 
import java.util.Map; 
  
import java.security.*;
import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 

public class App {
    public static void main(String[] args) throws Exception {
         Object obj = new JSONParser().parse(new FileReader("src//input.json")); 
          
        JSONObject jo = (JSONObject) obj; 
          
       
    
           
        Map student = ((Map)jo.get("student")); 
          
        // iterating address Map 
        String first_name=(String) student.get("first_name");
        first_name.toLowerCase();
        String roll_number=(String) student.get("roll_number");
        roll_number.toLowerCase();
        MessageDigest m= MessageDigest.getInstance("MD5");
        m.reset();
        
        String result=first_name+roll_number;

        m.update(result.getBytes());
        byte digest[]=m.digest();

        BigInteger bigInt=new BigInteger(1,digest);
        String hashtext=bigInt.toString(16);
        
        while(hashtext.length()<32) {
            hashtext="0"+hashtext;
        }
        PrintWriter writer= new PrintWriter("output.txt","UTF-8");
        writer.println(hashtext);
        writer.close();
          
        
        
          
 
    }
}
