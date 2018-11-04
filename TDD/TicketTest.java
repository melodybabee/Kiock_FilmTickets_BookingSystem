package junit;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class TicketTest extends junit.framework.TestCase{
	public void test() {
		Film f = new Film("title", "director", "actor", "language", 100);
		GregorianCalendar g = new GregorianCalendar(2017,5,3,10,0,0);
		Screen s = new Screen(g);
		Ticket t = new Ticket(123456, f, s, "A1");
		assertEquals(1.0,t.getDiscount());
		t.setDiscount(0.5);
		assertEquals(0.5,t.getDiscount());
		assertEquals(16.0,t.getPrice());
		t.setPrice(15.0);
		assertEquals(15.0,t.getPrice());
		assertEquals(123456,t.getID());
		t.setID(654321);
		assertEquals(654321,t.getID());
		assertEquals(f,t.getFilm());
		assertEquals(s,t.getScreen());
		assertEquals("A1",t.getSeat());
		t.setSeat("A2");
		assertEquals("A2",t.getSeat());
		t.setType("screen1");
		assertEquals("screen1",t.getType());
	}

}
