package game.utilities;

import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class IntervalExecutor {

	private float delay;
	private float interval;
	private Runnable action;
	private boolean running;
	private Timer timer;

	public IntervalExecutor(float delay, float interval, Runnable action) {
		this.delay = delay;
		this.interval = interval;
		this.action = action;
		this.running = false;
		this.timer = new Timer();
	}

	public void decreaseInterval(float amount) {
		if (interval - amount >= 0.05f) {
			interval -= amount;
			if (running) {
				restart();
			}
		}
	}

	public void increaseInterval(float amount) {
		if (interval + amount <= 1.0f) {
			interval += amount;
			if (running) {
				restart();
			}
		}
	}

	public void increaseDelay(float amount) {
		delay += amount;
		if (running) {
			restart();
		}
	}

	public void decreaseDelay(float amount) {
		delay -= amount;
		if (running) {
			restart();
		}
	}

	public void start() {
		running = true;
		timer.scheduleTask(new Task() {
			@Override
			public void run() {
				action.run();
			}
		}, delay, interval);
	}

	public void stop() {
		running = false;
		timer.clear();
	}

	public void restart() {
		stop();
		start();
	}

	public boolean isRunning() {
		return running;
	}

}