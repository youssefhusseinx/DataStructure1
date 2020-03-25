package eg.edu.alexu.csd.datastructure.linkedList.cs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUPsolver {
	
	int poly1[][] = { { 1, 2}, { 2, 1} };	
	int poly2[][] = { { 3, 0}, { 4, -2} };
	int poly3[][] = {};
	
	@Test
	void evaluate() {
		Psolver obj = new Psolver ();
		obj.setPolynomial('A',poly1);
		obj.setPolynomial('B',poly2);
		obj.setPolynomial('C',poly1);
		
		assertEquals(0,obj.evaluatePolynomial('A', 0));
		assertEquals(3,obj.evaluatePolynomial('A', 1));
		assertEquals(0,obj.evaluatePolynomial('C', 0));
		assertThrows(RuntimeException.class, () -> obj.evaluatePolynomial('B', 0));
	}
	
	@Test
	void add() {
		Psolver obj = new Psolver ();
		obj.setPolynomial('A',poly1);
		obj.setPolynomial('B',poly2);
		
		obj.setPolynomial('R', obj.add('A', 'B'));
		assertEquals("1x^2+2x^1+3x^0+4x^-2",obj.print('R'));
	}
	
	@Test
	void subtract() {
		Psolver obj = new Psolver ();
		obj.setPolynomial('A',poly1);
		obj.setPolynomial('C',poly2);
		
		obj.setPolynomial('R', obj.subtract('A', 'C'));
		assertEquals("1x^2+2x^1+-3x^0+-4x^-2",obj.print('R'));
	}
	
	@Test
	void multiply() {
		Psolver obj = new Psolver ();
		obj.setPolynomial('C',poly1);
		obj.setPolynomial('B',poly2);
		
		obj.setPolynomial('R', obj.multiply('C', 'B'));
		assertEquals("3x^2+6x^1+4x^0+8x^-1",obj.print('R'));
	}
	
	@Test
	void print() {
		Psolver obj = new Psolver ();
		
		obj.setPolynomial('A',poly1);
		assertEquals("1x^2+2x^1",obj.print('A'));
		
		obj.clearPolynomial('A');
		assertEquals("Empty",obj.print('A'));
		
		obj.setPolynomial('C',poly3);
		assertEquals("Empty",obj.print('C'));
	}

}
