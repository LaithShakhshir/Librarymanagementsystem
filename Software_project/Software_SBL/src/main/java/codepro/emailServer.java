package codepro;
import java.io.*;

public class emailServer {
	
	
    public void sendEmail(String email , String subject , String body ) throws IOException {
    	 FileWriter f = new FileWriter("email.txt");
         BufferedWriter bw = new BufferedWriter(f);
    	try {
    	
         bw.write(email);
         bw.append("\n");
         bw.append(subject);
         bw.append("\n");
         bw.append(body);
         bw.close();
         f.close();
    	}
    	catch(Exception e) {
    		
    	}
 	finally {
    	bw.close();
        f.close();
    }
	
	
    }
}