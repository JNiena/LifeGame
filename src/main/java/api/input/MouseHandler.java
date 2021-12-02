package api.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import java.util.function.BiConsumer;

public class MouseHandler {

	private BiConsumer<Integer, Integer> leftClickAction;
	private BiConsumer<Integer, Integer> rightClickAction;
	private BiConsumer<Integer, Integer> middleClickAction;

	public MouseHandler() {
		leftClickAction = (x, y) -> {};
		rightClickAction = (x, y) -> {};
		middleClickAction = (x, y) -> {};
		setupInputProcessor();
	}

	private void setupInputProcessor() {
		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override
			public boolean touchDown(int x, int y, int pointer, int button) {
				y = Gdx.graphics.getHeight() - y;
				if (button == 0) {
					leftClickAction.accept(x, y);
				} else if (button == 1) {
					rightClickAction.accept(x, y);
				} else if (button == 3) {
					middleClickAction.accept(x, y);
				}
				return true;
			}
		});
	}

	public void bindLeftClick(BiConsumer<Integer, Integer> action) {
		leftClickAction = action;
	}

	public void bindRightClick(BiConsumer<Integer, Integer> action) {
		rightClickAction = action;
	}

	public void bindMiddleClick(BiConsumer<Integer, Integer> action) {
		middleClickAction = action;
	}

}