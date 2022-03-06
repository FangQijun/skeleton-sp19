public class NBody {
	public static double readRadius(String planetsFilename) {
		In in = new In(planetsFilename);
		int i = 0;
		int k = in.readInt();
		double radius = in.readDouble();

		return radius;
	}
}