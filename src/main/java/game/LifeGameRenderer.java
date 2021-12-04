package game;

import api.rendering.Renderable;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class LifeGameRenderer implements Renderable {

	private LifeGame game;
	private LifeGameCursor cursor;
	private Color alive;
	private Color dead;
	private int size;
	private boolean drawLines;
	private boolean drawCursor;

	public LifeGameRenderer(LifeGame game, LifeGameCursor cursor, Color alive, Color dead, int size, boolean drawLines, boolean drawCursor) {
		this.game = game;
		this.cursor = cursor;
		this.alive = alive;
		this.dead = dead;
		this.size = size;
		this.drawLines = drawLines;
		this.drawCursor = drawCursor;
	}

	@Override
	public void render(ShapeDrawer renderer) {
		ScreenUtils.clear(dead);
		drawCells(renderer);
		if (drawLines) {
			drawLines(renderer);
		}
		if (drawCursor) {
			drawCursor(renderer);
		}
	}

	private void drawCells(ShapeDrawer renderer) {
		renderer.setColor(alive);
		for (int x = 1; x <= game.getWidth(); x++) {
			for (int y = 1; y <= game.getHeight(); y++) {
				if (game.isAlive(x, y)) {
					renderer.filledRectangle((x - 1) * size, (y - 1) * size, size, size);
				}
			}
		}
	}

	private void drawLines(ShapeDrawer renderer) {
		renderer.setColor(Color.BLACK);
		for (int x = size; x < game.getWidth() * size; x += size) {
			renderer.line(x, 0, x, game.getHeight() * size);
		}
		for (int y = size; y < game.getHeight() * size; y += size) {
			renderer.line(0, y, game.getWidth() * size, y);
		}
	}

	private void drawCursor(ShapeDrawer renderer) {
		renderer.setColor(Color.WHITE);
		renderer.rectangle((cursor.getX() - 1) * size, (cursor.getY() - 1) * size, size, size);
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

	public void showCursor() {
		drawCursor = true;
	}

	public void hideCursor() {
		drawCursor = false;
	}

	public void toggleCursor() {
		drawCursor = !drawCursor;
	}

	public int getSize() {
		return size;
	}

}