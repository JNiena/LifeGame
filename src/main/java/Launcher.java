import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import game.Game;

public class Launcher {

	private static Lwjgl3ApplicationConfiguration configuration;
	private static Lwjgl3Application application;

	public static void main(String[] args) {
		setupConfiguration();
		setupApplication();
	}

	private static void setupConfiguration() {
		configuration = new Lwjgl3ApplicationConfiguration();
		configuration.setWindowedMode(1920, 1080);
		configuration.setResizable(false);
		configuration.setTitle("Life Game");
	}

	private static void setupApplication() {
		application = new Lwjgl3Application(new Game(4), configuration);
	}

}