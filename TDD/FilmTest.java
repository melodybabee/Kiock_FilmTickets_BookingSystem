package junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
public class FilmTest extends junit.framework.TestCase{
	public void testCreate()  {
	Film f = new Film("title", "director", "actor", "language", 100);
	assertEquals("title", f.getTitle());
	assertEquals("director", f.getDirector());
	assertEquals("actor", f.getActor());
	assertEquals("language", f.getLanguage());
	assertEquals(100, f.getLength());
	f.setTitle("title1");
	assertEquals("title1", f.getTitle());
	f.setDirector("director1");
	assertEquals("director1", f.getDirector());
	f.setActor("actor1");
	assertEquals("actor1", f.getActor());
	}
}
