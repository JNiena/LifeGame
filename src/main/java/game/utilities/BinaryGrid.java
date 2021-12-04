package game.utilities;

public class BinaryGrid {

	private boolean[][] grid;

	public BinaryGrid(int width, int height) {
		grid = new boolean[width][height];
	}

	public boolean get(int x, int y) {
		if (isInside(x, y)) {
			return grid[x - 1][y - 1];
		}
		return false;
	}

	public void set(int x, int y, boolean value) {
		if (isInside(x, y)) {
			grid[x - 1][y - 1] = value;
		}
	}

	public void setAll(boolean value) {
		for (int x = 1; x <= getWidth(); x++) {
			for (int y = 1; y <= getHeight(); y++) {
				set(x, y, value);
			}
		}
	}

	private boolean isInside(int x, int y) {
		return x >= 1 && y >= 1 && x <= getWidth() && y <= getHeight();
	}

	public void copyTo(BinaryGrid grid) {
		for (int x = 1; x <= getWidth(); x++) {
			for (int y = 1; y <= getHeight(); y++) {
				grid.set(x, y, this.get(x, y));
			}
		}
	}

	public void copyFrom(BinaryGrid grid) {
		grid.copyTo(this);
	}

	public BinaryGrid copy() {
		BinaryGrid newGrid = new BinaryGrid(getWidth(), getHeight());
		copyTo(newGrid);
		return newGrid;
	}

	public int getWidth() {
		return grid.length;
	}

	public int getHeight() {
		return grid[0].length;
	}

}