import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class ShapesTest {

	@Test
	public void rectangleSetWidthMustOnlySetWidth() {
		for (int i = 0; i < 100; i++) {
			Rectangle r = arbitraryRectangle();
			int heightBefore = r.getHeight();
			r.setWidth(30);
			int heightAfter = r.getHeight();

			assertEquals(30, r.getWidth());
			assertEquals(heightBefore, heightAfter);
		}
	}

	@Test
	public void squareMustRemainSquare() {
		Square s = new Square(10);
		s.setWidth(20);
		assertEquals(s.getWidth(), s.getHeight());
	}

	private static Rectangle arbitraryRectangle() {
		Random random = new Random();
		if (random.nextBoolean()) {
			return new Square(random.nextInt(50));
		} else {
			return new Rectangle(random.nextInt(50), random.nextInt(50));
		}
	}
}
