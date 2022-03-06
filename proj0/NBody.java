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
			System.out.println("xPos = " + xPos + ", yPos = " + yPos + ", xVel = " + xVel + ", yVel = " + yVel + ", mass = " + m + ", Filename = " + fn);

			Body b = new Body(xPos, yPos, xVel, yVel, m, fn);
			
			arrayBodies[i] = b;
			i += 1;
		}

		return arrayBodies;
	}

	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Please provide 3 arguments!");
		} else {
			double T = Double.parseDouble(args[0]);
			double dt = Double.parseDouble(args[1]);
			String filename = args[2];

			double universeRadius = readRadius(filename);
			Body[] arrBodies = readBodies(filename);
			int numBodies = arrBodies.length;

			String imageToDraw = "images/starfield.jpg";
			StdDraw.enableDoubleBuffering();
			/** Sets up the universe so it goes x-axis:(-universeRadius, universeRadius) 
			 * and y-axis:(-universeRadius, universeRadius) */
			StdDraw.setScale(-universeRadius, universeRadius);
			/* Clears the drawing window. */
			StdDraw.clear();

			double time = 0.0;

			while (time < T) {
				double[] xForces = new double[numBodies];
				double[] yForces = new double[numBodies];
				for (int i = 0; i < numBodies; i++) {
					xForces[i] = arrBodies[i].calcNetForceExertedByX(arrBodies);
					yForces[i] = arrBodies[i].calcNetForceExertedByY(arrBodies);
				}

				for (int i = 0; i < numBodies; i++) {
					arrBodies[i].update(dt, xForces[i], yForces[i]);
				}

				/* Stamps a copy of images/starfield.jpg as background. */
				StdDraw.picture(0, 0, imageToDraw);

				/** Test on drawing just one body
				 * Then draw all planets in data/planets.txt */
				// arrBodies[0].draw(dt);
				for(Body body : arrBodies) body.draw();

				/* Shows the drawing to the screen, and waits 10 milliseconds, as instructed. */
				StdDraw.show();
				StdDraw.pause(10);

				time += dt;
			}

			/** Final universe printout, required by project instruction. */
			StdOut.printf("%d\n", arrBodies.length);
			StdOut.printf("%.2e\n", universeRadius);
			for (int i = 0; i < arrBodies.length; i++) {
			    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
			                  arrBodies[i].xxPos, arrBodies[i].yyPos, arrBodies[i].xxVel,
			                  arrBodies[i].yyVel, arrBodies[i].mass, arrBodies[i].imgFileName);   
			}
		}
	}
}