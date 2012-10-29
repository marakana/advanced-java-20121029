import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class ShapesTest {

	@Test
	public void rectangleCopyWithMustOnlySetWidth() {
		for (int i = 0; i < 100; i++) {
			Rectangle
				before = arbitraryRectangle(),
				after = before.copyWithWidth(30);

			assertEquals(30, after.getWidth());
			assertEquals(before.getHeight(), after.getHeight());
		}
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
