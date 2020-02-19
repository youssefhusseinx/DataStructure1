package assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test {

	@Test
	void test() {
		Calculator calc = new Calculator();
		int x=calc.add(22,23);
		assertEquals(23+22,x,0);
		
		int y=calc.add(-1011,12);
		assertEquals(-1011+12,y,0);
		
		float f1=calc.divide(5,3);
		assertEquals(5f/3,f1,0);
		
		float f2=calc.divide(0, 7);
		assertEquals(0/7,f2,0);
		
		float f3=calc.divide(6, 0);
		assertEquals(0,f3,0);
		
		
	}

}
