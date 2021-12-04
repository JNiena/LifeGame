package game;

import game.utilities.Direction;

public class LifeGameCursor {

	private LifeGame game;
	private int x;
	private int y;

	public LifeGameCursor(LifeGame game, int x, int y) {
		this.game = game;
		this.x = x;
		this.y = y;
	}

	public void move(Direction direction, int amount) {
		if (direction == Direction.Up) {
			y += amount;
		}
		else if (direction == Direction.Down) {
			y -= amount;
		}
		else if (direction == Direction.Left) {
			x -= amount;
		}
		else if (direction == Direction.Right) {
			x += amount;
		}
	}

	public void move(Direction direction) {
		move(direction, 1);
	}

	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}