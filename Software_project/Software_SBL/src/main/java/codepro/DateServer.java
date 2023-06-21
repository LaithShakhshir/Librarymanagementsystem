package codepro;
import java.util.*;

public class DateServer {
	private Calendar calendar;
	
	public DateServer() {
		calendar = Calendar.getInstance();
	}
	public Calendar getDate() {
		return calendar;
	}
	
	public void setDate(Calendar c) {
		calendar = c;
	}

}
