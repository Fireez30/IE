package dicowithtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testDico {

	public ODictionary dico;
	public FDictionary fdico;
	
	@Before
	public void setUp() throws Exception {
		dico = new ODictionary();
		fdico = new FDictionary();
	}

	@Test
	public void testAddOneElementToEmptyDico(){
		assertTrue(fdico.isEmpty());
		fdico.put("x","y");
		assert fdico.getSize()>1 : "raté";
		assertTrue(fdico.containsKey("x"));
		assertFalse(fdico.isEmpty());
		assertEquals(fdico.get("x"),"y");
		fdico.put("x","test");
		assertEquals(fdico.get("x"),"test");
		assertEquals(fdico.get("test11"),null);
		
		assertTrue(dico.isEmpty());		
		dico.put("key1","elem1");
		assertEquals(1,dico.getSize());
		assertTrue(dico.containsKey("key1"));
		assertFalse(dico.isEmpty());
		assertEquals(dico.get("key1"),"elem1");
		dico.put("key1","newelem1");
		assertEquals(dico.get("key1"),"newelem1");
		assertEquals(dico.get("test2"),null);
	}
	
	@Test
	public void testMoreElementDico(){
		
		assertTrue(fdico.isEmpty());
		fdico.put("x","y");
		fdico.put("a","b");
		fdico.put("c","d");
		fdico.put("e","f");
		assert fdico.getSize()>4 : "raté";
		assertTrue(fdico.containsKey("x"));
		assertTrue(fdico.containsKey("e"));
		assertTrue(fdico.containsKey("c"));
		assertTrue(fdico.containsKey("a"));
		assertFalse(fdico.isEmpty());
		assertEquals(fdico.get("x"),"y");
		assertEquals(fdico.get("a"),"b");
		assertEquals(fdico.get("c"),"d");
		assertEquals(fdico.get("e"),"f");
		fdico.put("x","test");
		assertEquals(fdico.get("x"),"test");
		assertEquals(fdico.get("test11"),null);
		
		dico.put(1,"key1");
		dico.put("elem2","key2");
		assertEquals(2,dico.getSize());
		assertTrue(dico.containsKey(1));
		assertTrue(dico.containsKey("elem2"));
		assertEquals(dico.get(1),"key1");
		assertEquals(dico.get("elem2"),"key2");
		dico.put(1,"test");
		assertEquals(dico.get(1),"test");
		assertEquals(dico.get("test2"),null);
	}

}
