package junit;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class ScreenTest extends junit.framework.TestCase{ 
	public void testCreate(){
		GregorianCalendar g = new GregorianCalendar(2017,5,3,10,0,0);
		Screen s = new Screen(g);
		s.creatSeat(32);
		s.setType(1);
		assertEquals(1, s.getScreenType());
		assertEquals(g, s.getDate());
	}
}
