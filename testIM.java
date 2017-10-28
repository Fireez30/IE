package mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;



public class testIM {

	public I mock1;
	@Before
	public void setup() throws Exception{
		mock1 = mock(I.class);
		when(mock1.methodeInt()).thenReturn(1,2,3,4);
		doThrow(new IndexOutOfBoundsException("truc")).when(mock1).methodeVoid();
		when(mock1.methodParam(3)).thenReturn(3);
		when(mock1.methodParam(5)).thenReturn(10);
	}
	
	@Test
	public void test() throws Exception{
	//assertEquals(mock1.methodeInt(),0);
	assertEquals(mock1.methodParam(3),3);
	assertEquals(mock1.methodParam(5),10);
	assertEquals(mock1.methodParam(0),0);
	for (int i=0;i<4;i++) mock1.methodeInt();
	verify(mock1,times(4)).methodeInt();
	try{mock1.methodeVoid();}
	
	catch (IndexOutOfBoundsException e){
		System.out.println("test"+ e);
		assertTrue(e.toString().contains("Index"));
		assertTrue(e.getMessage().contains("truc"));
		}
	}
}
