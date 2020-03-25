package eg.edu.alexu.csd.datastructure.linkedList.cs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JTestDoubly {

	Doubly list = new Doubly();
	
	@Test
	void get() {
		list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);list.add(7);list.add(8);list.add(9);list.add(10);
		assertEquals(1,list.get(1));
		assertEquals(5,list.get(5));
		assertEquals(10,list.get(10));
		assertThrows(RuntimeException.class, () -> list.get(15));
		}
	
	@Test
	void add() {
		list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);list.add(7);list.add(8);list.add(9);list.add(10);
		list.add(5,0);
		assertEquals(0,list.get(5));
		assertThrows(RuntimeException.class, () -> list.add(15,0));
	}
	
	@Test
	void set() {
		list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);list.add(7);list.add(8);list.add(9);list.add(10);
		list.set(5,0);
		assertEquals(0,list.get(5));
		assertThrows(RuntimeException.class, () -> list.set(15,0));
	}
	
	@Test
	void subList() {
		list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);list.add(7);list.add(8);list.add(9);list.add(10);
		
		assertThrows(RuntimeException.class, () -> list.sublist(3, 15));
		
		Doubly list1 = new Doubly();
		list1=(Doubly) list.sublist(3, 6);
		
		assertEquals(4,list1.size());
		
		for (int i=0 ;i<4 ;i++)
		{
			assertEquals(list1.get(1+i),list.get(3+i));
		}
	}
	
	@Test
	void remove() {
		list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);list.add(7);list.add(8);list.add(9);list.add(10);
		
		assertThrows(RuntimeException.class, () -> list.remove(15));
		
		list.remove(5);
		assertEquals(9,list.size());
		assertEquals(6,list.get(5));
		
		list.remove(1);
		assertEquals(8,list.size());
		assertEquals(2,list.get(1));
		
		list.remove(8);
		assertEquals(7,list.size());
		assertEquals(9,list.get(7));
	}
	
	@Test
	void contains() {
		list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);list.add(7);list.add(8);list.add(9);list.add(10);
		assertEquals(true,list.contains(10));
		assertEquals(true,list.contains(5));
		assertEquals(false,list.contains(100));
	}
	
	@Test
	void clear() {
		list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);list.add(7);list.add(8);list.add(9);list.add(10);
		assertEquals(false,list.isEmpty());
		list.clear();
		assertEquals(0,list.size());
		assertEquals(true,list.isEmpty());
	}

}
