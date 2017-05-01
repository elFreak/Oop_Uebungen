/**
 * Klasse zur Repräsentation von komplexen Zahlen mit zugehörigen Methoden.
 * 
 * @author Richard Gut
 * 
 */
public class Complex {
	public double re;
	public double im;

	public Complex() {
		this(0.0, 0.0);
	}

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public Complex(double re) {
		this(re, 0.0);
	}

	public Complex(Complex z) {
		this(z.re, z.im);
	}

	public Complex pow(double x) {
		double re = Math.pow(this.abs(), x) * Math.cos(angle() * x);
		double im = Math.pow(this.abs(), x) * Math.sin(angle() * x);
		return new Complex(re, im);
	}

	public Complex add(Complex z) {
		return new Complex(this.re + z.re, this.im + z.im);
	}
	
	public Complex add(int z) {
		return new Complex(this.re + z, this.im);
	}

	public Complex sub(Complex z) {
		return new Complex(this.re - z.re, this.im - z.im);
	}

	public Complex mul(Complex z) {
		double re = this.abs() * z.abs() * Math.cos(this.angle() + z.angle());
		double im = this.abs() * z.abs() * Math.sin(this.angle() + z.angle());
		return new Complex(re, im);
	}

	public Complex mul(double z) {
		return new Complex(this.re * z, this.im * z);
	}

	public Complex div(Complex b) {
		double re = this.abs() / b.abs() * Math.cos(this.angle() - b.angle());
		double im = this.abs() / b.abs() * Math.sin(this.angle() - b.angle());
		return new Complex(re, im);	}

	public Complex div(double b) {
		return new Complex(this.re / b, this.im / b);
	}

	public double abs() {
		return Math.sqrt(re * re + im * im);
	}

	public double angle() {
		return Math.atan2(im, re);
	}

	public static double[] angle(Complex[] c) {
		double[] res = new double[c.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = c[i].angle();
		}
		return res;
	}

	public static double[] abs(Complex[] c) {
		double[] res = new double[c.length];
		for (int i = 0; i < c.length; i++) {
			res[i] = c[i].abs();
		}
		return res;
	}

	public static void main(String[] args) {
		Complex a = new Complex(0.0, 1.0);
		Complex b = new Complex(1, 1);

		Complex c = a.mul(b);

		System.out.println(" Re: " + c.re + " Im: " + c.im);

	}
}