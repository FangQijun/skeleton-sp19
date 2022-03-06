public class Body {
	final static double G = 6.67e-11;

	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	String imgFileName;

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
		double dist_x = b.xxPos - this.xxPos;
		double force = this.calcForceExertedBy(b);
		return (dist_x / dist) * force;
	}

	public double calcForceExertedByY(Body b) {
		double dist = this.calcDistance(b);
		double dist_y = b.yyPos - this.yyPos;
		double force = this.calcForceExertedBy(b);
		return (dist_y / dist) * force;
	}
}