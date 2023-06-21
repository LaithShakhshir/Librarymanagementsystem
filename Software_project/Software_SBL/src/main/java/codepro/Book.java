package codepro;


import java.util.logging.Logger;

    public class Book {
    Logger logger
            = Logger.getLogger(Book.class.getName());
    private   String author;
    private  String title;
    private String signature;
    private boolean isBorrowed;
    private DateServer d;

    public boolean getIsBorrowed() {
		return isBorrowed;
	}


	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	
	public void setDateServer(DateServer d) {
		this.d = d;
	}


	public void setAuthor(String author) {
        this.author = author;
    }
    

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAuthor() {
        return author;
    }
    
    public DateServer getDateServer() {
        return d;
    }

    public  String getTitle() {
        return title;
    }
    
    public String getSignature() {
    	return signature; 
    }

    public Book() {
    }

    public Book(String a, String t, String i){
        setAuthor(a);
        setTitle(t);
       
        setSignature(i);
    }
    @Override
    public String toString(){
    	return getSignature()+"\t"+getTitle()+"\t"+getSignature()+"\t"+isBorrowed;
    }
    
    }
    
    
