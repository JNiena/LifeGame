package game.utilities;

public class Random {

	private static java.util.Random random = new java.util.Random();

	public static int randomInteger(int max) {
		return random.nextInt(max);
	}

	public static int randomInteger() {
		return random.nextInt();
	}

	public static long randomLong() {
		return random.nextLong();
	}

	public static float randomFloat() {
		return random.nextFloat();
	}

	public static double randomDouble() {
		return random.nextDouble();
	}

	public static boolean randomBoolean() {
		return random.nextBoolean();
	}

}