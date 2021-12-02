package game.algorithms;

import game.LifeGameAlgorithm;
import game.utilities.BinaryGrid;

public class GameOfLife implements LifeGameAlgorithm {

	@Override
	public void advance(BinaryGrid grid) {
		BinaryGrid newGrid = new BinaryGrid(grid.getWidth(), grid.getHeight());
		newGrid.copyFrom(grid);
		for (int x = 1; x <= grid.getWidth(); x++) {
			for (int y = 1; y <= grid.getHeight(); y++) {
				int neighbors = getAmountOfNumbers(grid, x, y);
				if (grid.get(x, y)) {
					if (neighbors == 0 || neighbors == 1) {
						newGrid.set(x, y, false);
					} else if (neighbors >= 4) {
						newGrid.set(x, y, false);
					}
				} else if (neighbors == 3) {
					newGrid.set(x, y, true);
				}
			}
		}
		grid.copyFrom(newGrid);
	}

	private int getAmountOfNumbers(BinaryGrid grid, int x, int y) {
		int neighbors = 0;
		if (grid.get(x - 1, y - 1)) {
			neighbors++;
		}
		if (grid.get(x - 1, y)) {
			neighbors++;
		}
		if (grid.get(x - 1, y + 1)) {
			neighbors++;
		}
		if (grid.get(x, y - 1)) {
			neighbors++;
		}
		if (grid.get(x, y + 1)) {
			neighbors++;
		}
		if (grid.get(x + 1, y - 1)) {
			neighbors++;
		}
		if (grid.get(x + 1, y)) {
			neighbors++;
		}
		if (grid.get(x + 1, y + 1)) {
			neighbors++;
		}
		return neighbors;
	}

}