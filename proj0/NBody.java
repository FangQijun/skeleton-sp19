public class NBody {
	public static double readRadius(String planetsFilename) {
		In in = new In(planetsFilename);
		int n = in.readInt();
		double radius = in.readDouble();

		return radius;
	}

	public static Body[] readBodies(String planetsFilename) {
		In in = new In(planetsFilename);
		int n = in.readInt();
		double radius = in.readDouble();

		Body[] arrayBodies = new Body[n];
		int i = 0;
		while (i < n) {
			/* Each line has a planet */
			double xPos = in.readDouble();
			double yPos = in.readDouble();
			double xVel = in.readDouble();
			double yVel = in.readDouble();
			double m = in.readDouble();
			String fn = in.readString();
			// System.out.println("xPos = " + xPos + ", yPos = " + yPos + ", xVel = " + xVel + ", yVel = " + yVel + ", mass = " + m + ", Filename = " + fn);

			Body b = new Body(xPos, yPos, xVel, yVel, m, fn);
			
			arrayBodies[i] = b;
			i += 1;
		}

		return arrayBodies;
	}
}