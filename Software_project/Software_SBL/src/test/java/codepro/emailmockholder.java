package codepro;

import static org.mockito.Mockito.mock;

public class emailmockholder {
private emailServer me= mock(emailServer.class);

public emailmockholder(Library l){
	l.setEmailServer(me);
	
}

public emailServer getMockEmailHolder() {
	return me;
}

}
