package game;

import api.Application;
import api.input.KeyboardHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import game.utilities.Direction;
import game.utilities.Random;

public class Game extends Application {

	private LifeGame game;
	private LifeGamePlayer player;
	private LifeGameCursor cursor;
	private LifeGameRenderer renderer;
	private int size;

	public Game(int size) {
		this.size = size;
	}

	@Override
	public void start() {
		game = new LifeGame(Gdx.graphics.getWidth() / size, Gdx.graphics.getHeight() / size);
		player = new LifeGamePlayer(game, 0f, 0.05f);
		cursor = new LifeGameCursor(game, 1, 1);
		renderer = new LifeGameRenderer(game, cursor, Color.YELLOW, Color.DARK_GRAY, size, true, true);
		setupControls();
		setupRendering();
	}

	private void setupControls() {
		getMouseHandler().bindLeftClick((x, y) -> {
			game.toggle(x / renderer.getSize() + 1, y / renderer.getSize() + 1);
			cursor.move(x / renderer.getSize() + 1, y / renderer.getSize() + 1);
		});
		KeyboardHandler keyboardHandler = getKeyboardHandler();
		keyboardHandler.bindTappedKey(Keys.ENTER, () -> game.toggle(cursor.getX(), cursor.getY()));
		keyboardHandler.bindTappedKey(Keys.R, () -> game.randomize(50));
		keyboardHandler.bindTappedKey(Keys.C, game::clear);
		keyboardHandler.bindTappedKey(Keys.L, renderer::toggleLines);
		keyboardHandler.bindTappedKey(Keys.H, renderer::toggleCursor);
		keyboardHandler.bindTappedKey(Keys.G, () -> renderer.changeAliveColor(new Color(Random.randomFloat(), Random.randomFloat(), Random.randomFloat(), Random.randomFloat())));
		keyboardHandler.bindTappedKey(Keys.B, () -> renderer.changeDeadColor(new Color(Random.randomFloat(), Random.randomFloat(), Random.randomFloat(), Random.randomFloat())));
		keyboardHandler.bindTappedKey(Keys.EQUALS, () -> player.increaseSpeed(0.05f));
		keyboardHandler.bindTappedKey(Keys.MINUS, () -> player.decreaseSpeed(0.05f));
		keyboardHandler.bindTappedKey(Keys.SPACE, player::toggle);
		keyboardHandler.bindTappedKey(Keys.W, () -> cursor.move(Direction.Up));
		keyboardHandler.bindTappedKey(Keys.S, () -> cursor.move(Direction.Down));
		keyboardHandler.bindTappedKey(Keys.A, () -> cursor.move(Direction.Left));
		keyboardHandler.bindTappedKey(Keys.D, () -> cursor.move(Direction.Right));
	}

	private void setupRendering() {
		getRenderer().add(renderer);
	}

}