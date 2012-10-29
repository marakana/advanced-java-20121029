public class Rectangle {

	private final int width, height;

	public Rectangle(int width, int height) {
		if (width < 0 || height < 0)
			throw new IllegalArgumentException();
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public Rectangle copyWithWidth(int width) {
		return new Rectangle(width, this.height);
	}

	public int getHeight() {
		return height;
	}

	public Rectangle copyWithHeight(int height) {
		return new Rectangle(this.width, height);
	}

	public int area() {
		return width * height;
	}

	public int perimeter() {
		return 2 * (width + height);
	}

}
