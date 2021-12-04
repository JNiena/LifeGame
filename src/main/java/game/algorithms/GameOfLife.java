package game.algorithms;

import game.LifeGameAlgorithm;
import game.utilities.BinaryGrid;

public class GameOfLife implements LifeGameAlgorithm {

	private int[] offsets;

	public GameOfLife() {
		offsets = new int[]{-1, -1, 0, -1, 1, -1, -1, 0, 1, 0, -1, 1, 0, 1, 1, 1};
	}

	@Override
	public void advance(BinaryGrid grid) {
		BinaryGrid newGrid = grid.copy();
		for (int x = 1; x <= grid.getWidth(); x++) {
			for (int y = 1; y <= grid.getHeight(); y++) {
				int neighbors = getAmountOfNumbers(grid, x, y);
				if (grid.get(x, y)) {
					if (neighbors == 0 || neighbors == 1 || neighbors >= 4) {
						newGrid.set(x, y, false);
					}
				}
				else if (neighbors == 3) {
					newGrid.set(x, y, true);
				}
			}
		}
		newGrid.copyTo(grid);
	}

	private int getAmountOfNumbers(BinaryGrid grid, int x, int y) {
		int neighbors = 0;
		for (int i = 0; i < offsets.length - 1; i += 2) {
			if (grid.get(x + offsets[i], y + offsets[i + 1])) {
				neighbors++;
			}
		}
		return neighbors;
	}

}