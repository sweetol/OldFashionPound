import static org.junit.Assert.*;

import org.junit.Test;

import oldfashionpound.*;
import oldfashionpound.exceptions.*;

public class TestJUnit1 {

	Prezzo p1;
	Prezzo p2;
	Prezzo p3;

	Prezzo p1bis;
	Prezzo p2bis;
	Prezzo p3bis;
	
	public TestJUnit1()  throws NegativeValueException, WrongAmountException, PriceFormatException {
		p1 = new Prezzo(new Sterline(5), new Scellini(17), new Pence(8));
		p2 = new Prezzo(new Sterline(3), new Scellini(4), new Pence(10));
		p3 = new Prezzo(new Sterline(18), new Scellini(16), new Pence(1));

		p1bis = new Prezzo("5p 17s 8d");
		p2bis = new Prezzo("3p 4s 10d");
		p3bis = new Prezzo("18p 16s 1d");
	}
	
	
	@Test
	public void add() {
		System.out.println("addition");
		try {
			assertEquals("9p 2s 6d", p1.add(p2).toString());
			assertEquals("9p 2s 6d", p1bis.add(p2bis).toString());
		}
		catch(Exception e){
			fail(e.getMessage());
		}
	}

	@Test
	public void subtract() {
		System.out.println("subtraction");
		try {
			assertEquals("2p 12s 10d", p1.subtract(p2).toString());
			assertEquals("-2p 12s 10d", p2.subtract(p1).toString());
			assertEquals("2p 12s 10d", p1bis.subtract(p2bis).toString());
			assertEquals("-2p 12s 10d", p2bis.subtract(p1bis).toString());
		}
		catch(Exception e){
			fail(e.getMessage());
		}
	}

	@Test
	public void multiply() {
		System.out.println("multiplication");
		try {
			assertEquals("11p 15s 4d", p1.multiplicate(2).toString());
			assertEquals("11p 15s 4d", p1bis.multiplicate(2).toString());
		}
		catch(Exception e){
			fail(e.getMessage());
		}
	}

	@Test
	public void divide() {
		System.out.println("division");
		try {
			assertEquals("1p 19s 2d (0p 0s 2d)", p1.divide(3).toString());
			assertEquals("1p 5s 0d (0p 1s 1d)", p3.divide(15).toString());
			assertEquals("1p 19s 2d (0p 0s 2d)", p1bis.divide(3).toString());
			assertEquals("1p 5s 0d (0p 1s 1d)", p3bis.divide(15).toString());
		}
		catch(Exception e){
			fail(e.getMessage());
		}
	}

	
}
