public class PicoMatlab {
	/**
	 * Berechnet den Frequenzgang aufgrund von Zähler- und Nennerpolynom b resp.
	 * a sowie der Frequenzachse f.
	 * 
	 * @param b
	 *            Zählerpolynom
	 * @param a
	 *            Nennerpolynom
	 * @param f
	 *            Frequenzachse
	 * @return Komplexwertiger Frequenzgang.
	 */
	public static final Complex[] freqs(double[] b, double[] a, double[] f) {
		Complex[] res = new Complex[f.length];
		
		for (int i = 0; i < f.length; i++) {
		
		Complex zaeler = polyVal(b, new Complex(0.0, 2*Math.PI*f[i]));
		Complex nenner = polyVal(a, new Complex(0.0, 2*Math.PI*f[i]));
		res[i] = zaeler.div(nenner);
		}


		return res;
	}

	public static final Complex polyVal(double[] p, Complex jw) {
		Complex v = new Complex();
		
		for (int i = 0; i < p.length; i++) {
			v = jw.pow(p.length-i-1).mul(p[i]).add(v);
		}

		return v;
	}

	public static void main(String[] args) {
		// Matlab: polyval([3 2 1], [0 2*pi*1i 2*pi*2i])./polyval([1 2 3], [0
		// 2*pi*1i 2*pi*2i])
		double[] f = { 0.0, 1.0, 2.0 };
		double[] b = { 3.0, 2.0, 1.0 };
		double[] a = { 1.0, 2.0, 3.0 };

		Complex[] H = freqs(b, a, f);

		for (int i = 0; i < H.length; i++) {
			System.out.println("Re: " + H[i].re + " Im: " + H[i].im);
		}
	}
}
