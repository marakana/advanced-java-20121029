public class Rectangle {

	private int width, height;

	public Rectangle(int width, int height) {
		if (width < 0 || height < 0)
			throw new IllegalArgumentException();
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int area() {
		return width * height;
	}

	public int perimeter() {
		return 2 * (width + height);
	}

}
