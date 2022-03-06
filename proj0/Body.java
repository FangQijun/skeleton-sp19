public class Body {
	final static double G = 6.67e-11;

	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Body(double xP, double yP, double xV, double yV, double m, String img) {
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}

	public Body(Body b) {
		this.xxPos = b.xxPos;
		this.yyPos = b.yyPos;
		this.xxVel = b.xxVel;
		this.yyVel = b.yyVel;
		this.mass = b.mass;
		this.imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b) {
		return Math.sqrt(Math.pow((this.xxPos - b.xxPos), 2) + Math.pow((this.yyPos - b.yyPos), 2));
	}

	public double calcForceExertedBy(Body b) {
		double dist = this.calcDistance(b);
		double force = (G * this.mass * b.mass) / Math.pow(dist, 2);
		return force;
	}

	public double calcForceExertedByX(Body b) {
		double dist = this.calcDistance(b);
		double distX = b.xxPos - this.xxPos;
		double force = this.calcForceExertedBy(b);
		return (distX / dist) * force;
	}

	public double calcForceExertedByY(Body b) {
		double dist = this.calcDistance(b);
		double distY = b.yyPos - this.yyPos;
		double force = this.calcForceExertedBy(b);
		return (distY / dist) * force;
	}

	public double calcNetForceExertedByX(Body[] bodyArray) {
		double force = 0.0;

		for (Body b : bodyArray) {
			if (!this.equals(b)) {
				force += this.calcForceExertedByX(b);
			}
		}

		return force;
	}

	public double calcNetForceExertedByY(Body[] bodyArray) {
		double force = 0.0;

		for (Body b : bodyArray) {
			if (!this.equals(b)) {
				force += this.calcForceExertedByY(b);
			}
		}

		return force;
	}

	public void update(double duration, double forceX, double forceY) {
		double accelarationX = forceX / this.mass;
		double accelarationY = forceY / this.mass;
		double dVelocityX = accelarationX * duration;
		double dVelocityY = accelarationY * duration;
		this.xxVel += dVelocityX;
		this.yyVel += dVelocityY;
		this.xxPos += this.xxVel * duration;
		this.yyPos += this.yyVel * duration;
	}

	public void draw() {
		// StdDraw.enableDoubleBuffering();
		// StdDraw.setScale(-radius, radius);
		// StdDraw.clear();
		// StdDraw.picture(this.xxPos / radius, this.yyPos / radius, this.imgFileName);
		// StdDraw.picture(0.0, 0.0, "images/" + this.imgFileName);
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
	}
}