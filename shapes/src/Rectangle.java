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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + width;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Rectangle))
			return false;
		Rectangle other = (Rectangle) obj;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

}
