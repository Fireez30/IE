package mockito;

import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;

public class testA {
	A a;
	A spy;
	A mock1;
	
	@Before
	public void setup(){
		a = new A();
		spy= spy(a);
		mock1= mock(A.class);
		when(mock1.m2(42)).thenReturn(0);
	}
	
	@Test
	public void test() {
		assertEquals(a.m1(),42);
		assertEquals(a.m1(),spy.m1());
		assertEquals(a.m2(2),4);
		assertEquals(a.m2(0),0);
		assertEquals(a.m2(5),spy.m2(5));
		assertEquals(mock1.m2(2),4);
		assertEquals(mock1.m2(42),0);
	}

}
