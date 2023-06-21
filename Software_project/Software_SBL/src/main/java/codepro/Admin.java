package codepro;

import java.util.logging.Logger;

public class Admin {
     String pass;
    private boolean logged;
    public emailServer e ;
    
    Logger logger
            = Logger.getLogger(Admin.class.getName());
    public  Admin(){
        this.setPass("adminadmin");
        this.setLogged(false);
    }
  


    

    
    public boolean loginFV(String enteredPass) {
    	if(enteredPass.equals(pass))
    		logged = true;
    	else logged = false;
    	return logged;
    }

    
    public void logoutFV() {
    	if (logged) {
    		logged = false; 
    	}
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public void setPass(String pass1) {
        this.pass = pass1;
        
    }
    public boolean getLogged() {
    	return logged;
    }
    public String getPass() {
    	return pass;
    }

}