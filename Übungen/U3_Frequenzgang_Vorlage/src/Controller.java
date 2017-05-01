
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Controller {
	private Model model;
	private View view;

	public Controller(Model model) {
		this.model = model;
	}

	public void btOkAction(String zaehlerString, String nennerString) {
		double[] zaehler = stringToCoeff(zaehlerString);
		double[] nenner = stringToCoeff(nennerString);
		model.setUTF(zaehler, nenner);
	}

	public void setView(View view) {
		this.view = view;
	}

	/**
	 * Konvertiert Zeichenkette s mit Komma resp. Leerzeichen separierten Zahlen
	 * in einen Array mit den entsprechenden Zahlen.
	 * 
	 * @param s
	 *            Zeichenkette mit Zahlen
	 * @return Array mit Zahlen
	 */
	private double[] stringToCoeff(String s) {
		String[] tokens = s.split("[, ]+");
		double[] z = new double[tokens.length];
		for (int i = 0; i < z.length; i++) {
			z[i] = Double.parseDouble(tokens[i]);
		}
		return z;
	}
}
