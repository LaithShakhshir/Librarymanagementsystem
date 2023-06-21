package codepro;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;

public class MockDateHolder {
	
    private DateServer dateServer= mock(DateServer.class);
    public MockDateHolder(Library l) {
    
    	l.setDateServer(dateServer);
    	when(this.dateServer.getDate()).thenReturn(Calendar.getInstance());
    }
    
	public void setDate(Calendar c) {
		
    	Calendar d = (Calendar) c.clone();
    	
    	dateServer.setDate(d);
    }
    
    public void advancedDateByDays(int days) {
    	Calendar old_date = dateServer.getDate();
    	Calendar next_date = old_date;
    	next_date.add(Calendar.DAY_OF_YEAR,days);
    	setDate(next_date);
    }
}
