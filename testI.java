package mockito;

import static org.mockito.Mockito.*;

import org.mockito.Mock;

public class testI {

	
	public static void main(String[] args) throws Exception {
		I mock1 = mock(I.class);
		when(mock1.methodeInt()).thenReturn(0);
	}
	
	

}
