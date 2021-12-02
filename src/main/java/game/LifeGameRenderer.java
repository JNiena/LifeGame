package game;

import api.rendering.Renderable;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class LifeGameRenderer implements Renderable {

	private LifeGame game;
	private Color alive;
	private Color dead;
	private int size;
	private boolean drawLines;

	public LifeGameRenderer(LifeGame game, Color alive, Color dead, int size, boolean drawLines) {
		this.game = game;
		this.alive = alive;
		this.dead = dead;
		this.size = size;
		this.drawLines = drawLines;
	}

	@Override
	public void render(ShapeDrawer renderer) {
		ScreenUtils.clear(dead);
		drawCells(renderer, game.getGrid().getWidth(), game.getGrid().getHeight());
		if (drawLines) {
			drawLines(renderer, game.getGrid().getWidth(), game.getGrid().getHeight());
		}
	}

	private void drawCells(ShapeDrawer renderer, int width, int height) {
		renderer.setColor(alive);
		for (int x = 1; x <= width; x++) {
			for (int y = 1; y <= height; y++) {
				if (game.getGrid().get(x, y)) {
					renderer.filledRectangle((x - 1) * size, (y - 1) * size, size, size);
				}
			}
		}
	}

	private void drawLines(ShapeDrawer renderer, int width, int height) {
		renderer.setColor(Color.BLACK);
		for (int x = size; x < width * size; x += size) {
			renderer.line(x, 0, x, height * size);
		}
		for (int y = size; y < height * size; y += size) {
			renderer.line(0, y, width * size, y);
		}
	}

	public void changeAliveColor(Color color) {
		alive = color;
	}

	public void changeDeadColor(Color color) {
		dead = color;
	}

	public void showLines() {
		drawLines = true;
	}

	public void hideLines() {
		drawLines = false;
	}

	public void toggleLines() {
		drawLines = !drawLines;
	}

	public int getSize() {
		return size;
	}

}