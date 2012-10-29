import static org.junit.Assert.*;

import org.junit.Test;


public class ShapesTest {

	@Test
	public void rectangleSetWidthMustOnlySetWidth() {
		Rectangle r = new Rectangle(10, 20);
		r.setWidth(30);
		assertEquals(30, r.getWidth());
		assertEquals(20, r.getHeight());
	}

	@Test
	public void squareMustRemainSquare() {
		Square s = new Square(10);
		s.setWidth(20);
		assertEquals(s.getWidth(), s.getHeight());
	}
}
