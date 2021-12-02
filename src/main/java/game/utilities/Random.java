package game.utilities;

public class Random {

	private static java.util.Random random = new java.util.Random();

	public static int integer(int bound) {
		return random.nextInt(bound);
	}

	public static int integer() {
		return random.nextInt();
	}

	public static float floatingPoint() {
		return random.nextFloat();
	}

}