package game;

import com.badlogic.gdx.graphics.Color;
import game.algorithms.GameOfLife;
import game.utilities.BinaryGrid;
import game.utilities.IntervalExecutor;
import game.utilities.Random;

public class LifeGame {

	private Color alive;
	private Color dead;
	private BinaryGrid grid;
	private IntervalExecutor executor;
	private LifeGameAlgorithm algorithm;

	public LifeGame(int width, int height) {
		this.grid = new BinaryGrid(width, height);
		this.executor = new IntervalExecutor(0.0f, 1.0f, this::advance);
		this.algorithm = new GameOfLife();
	}

	public void advance() {
		algorithm.advance(grid);
	}

	public void clear() {
		grid.setAll(false);
	}

	public void randomize(int chance) {
		for (int x = 1; x <= grid.getWidth(); x++) {
			for (int y = 1; y <= grid.getHeight(); y++) {
				if (Random.randomInteger(100) <= chance) {
					setAlive(x, y);
				}
				else {
					setDead(x, y);
				}
			}
		}
	}

	public void useAlgorithm(LifeGameAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

	public boolean isAlive(int x, int y) {
		return grid.get(x, y);
	}

	public boolean isDead(int x, int y) {
		return !grid.get(x, y);
	}

	public void setAlive(int x, int y) {
		grid.set(x, y, true);
	}

	public void setDead(int x, int y) {
		grid.set(x, y, false);
	}

	public void toggle(int x, int y) {
		if (isAlive(x, y)) {
			setDead(x, y);
		}
		else {
			setAlive(x, y);
		}
	}

	public int getWidth() {
		return grid.getWidth();
	}

	public int getHeight() {
		return grid.getHeight();
	}

}