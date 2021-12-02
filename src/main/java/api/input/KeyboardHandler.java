package api.input;

import com.badlogic.gdx.Gdx;
import java.util.HashMap;

public class KeyboardHandler {

	private HashMap<Integer, Runnable> tappedActions;
	private HashMap<Integer, Runnable> heldActions;

	public KeyboardHandler() {
		tappedActions = new HashMap<>();
		heldActions = new HashMap<>();
	}

	public void update() {
		for (int key : tappedActions.keySet()) {
			if (Gdx.input.isKeyJustPressed(key)) {
				tappedActions.get(key).run();
			}
		}
		for (int key : heldActions.keySet()) {
			if (Gdx.input.isKeyPressed(key)) {
				heldActions.get(key).run();
			}
		}
	}

	public void bindTappedKey(int key, Runnable action) {
		tappedActions.put(key, action);
	}

	public void bindHeldKey(int key, Runnable action) {
		heldActions.put(key, action);
	}

	public void unbindTappedKey(int key) {
		tappedActions.remove(key);
	}

	public void unbindHeldKey(int key) {
		heldActions.remove(key);
	}

}