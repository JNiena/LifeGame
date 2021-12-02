package game;

import api.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import game.utilities.Random;

public class Game extends Application {

	private LifeGame game;
	private LifeGamePlayer player;
	private LifeGameRenderer renderer;
	private int size;

	public Game(int size) {
		this.size = size;
	}

	@Override
	public void start() {
		game = new LifeGame(Gdx.graphics.getWidth() / size, Gdx.graphics.getHeight() / size);
		player = new LifeGamePlayer(game, 0f, 0.05f);
		renderer = new LifeGameRenderer(game, Color.YELLOW, Color.DARK_GRAY, size, true);
		setupControls();
		setupRendering();
	}

	private void setupControls() {
		getMouseHandler().bindLeftClick((x, y) -> game.setAlive(x / renderer.getSize() + 1, y / renderer.getSize() + 1));
		getMouseHandler().bindRightClick((x, y) -> game.setDead(x / renderer.getSize() + 1, y / renderer.getSize() + 1));
		getKeyboardHandler().bindTappedKey(Keys.ENTER, game::advance);
		getKeyboardHandler().bindTappedKey(Keys.R, () -> game.randomize(50));
		getKeyboardHandler().bindTappedKey(Keys.C, game::clear);
		getKeyboardHandler().bindTappedKey(Keys.L, renderer::toggleLines);
		getKeyboardHandler().bindTappedKey(Keys.G, () -> renderer.changeAliveColor(new Color(Random.floatingPoint(), Random.floatingPoint(), Random.floatingPoint(), Random.floatingPoint())));
		getKeyboardHandler().bindTappedKey(Keys.EQUALS, () -> player.increaseSpeed(0.05f));
		getKeyboardHandler().bindTappedKey(Keys.MINUS, () -> player.decreaseSpeed(0.05f));
		getKeyboardHandler().bindTappedKey(Keys.SPACE, player::toggle);
	}

	private void setupRendering() {
		getRenderer().add(renderer);
	}

}