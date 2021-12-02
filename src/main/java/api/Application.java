package api;

import api.input.KeyboardHandler;
import api.input.MouseHandler;
import api.rendering.Renderer;
import com.badlogic.gdx.ApplicationAdapter;

public class Application extends ApplicationAdapter implements GameAdapter {

	private KeyboardHandler keyboardHandler;
	private MouseHandler mouseHandler;
	private Renderer renderer;

	@Override
	public void create() {
		keyboardHandler = new KeyboardHandler();
		mouseHandler = new MouseHandler();
		renderer = new Renderer();
		start();
	}

	@Override
	public void render() {
		keyboardHandler.update();
		renderer.render();
		update();
	}

	@Override
	public void dispose() {
		renderer.dispose();
		exit();
	}

	protected KeyboardHandler getKeyboardHandler() {
		return keyboardHandler;
	}

	protected MouseHandler getMouseHandler() {
		return mouseHandler;
	}

	protected Renderer getRenderer() {
		return renderer;
	}

}