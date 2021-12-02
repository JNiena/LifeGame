package api.rendering;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonBatch;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;
import java.util.ArrayList;
import java.util.List;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class Renderer implements Disposable {

	private List<Renderable> renderables;
	private PolygonBatch batch;
	private ShapeDrawer renderer;
	private Texture texture;

	public Renderer() {
		renderables = new ArrayList<>();
		batch = new PolygonSpriteBatch();
		renderer = new ShapeDrawer(batch);
		Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.drawPixel(0, 0);
		texture = new Texture(pixmap);
		renderer.setTextureRegion(new TextureRegion(texture, 0, 0, 1, 1));
	}

	public void add(Renderable renderable) {
		renderables.add(renderable);
	}

	public void remove(Renderable renderable) {
		renderables.remove(renderable);
	}

	public void render() {
		batch.begin();
		for (Renderable renderable : renderables) {
			renderable.render(renderer);
		}
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

}