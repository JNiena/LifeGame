package game;

import game.utilities.IntervalExecutor;

public class LifeGamePlayer {

	private LifeGame game;
	private IntervalExecutor executor;

	public LifeGamePlayer(LifeGame game, float delay, float interval) {
		this.game = game;
		this.executor = new IntervalExecutor(delay, interval, game::advance);
	}

	public void increaseSpeed(float amount) {
		executor.decreaseInterval(amount);
	}

	public void decreaseSpeed(float amount) {
		executor.increaseInterval(amount);
	}

	public boolean isRunning() {
		return executor.isRunning();
	}

	public void start() {
		executor.start();
	}

	public void stop() {
		executor.stop();
	}

	public void toggle() {
		if (isRunning()) {
			stop();
		}
		else {
			start();
		}
	}

}