import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Zeiger extends GrafikObjekt {
	// 5
	protected double winkel;
	protected int r;

	public Zeiger() {
	}

	/**
	 * <pre>
	 * - Entsprechenden Konstruktor der Superklasse aufrufen.
	 * - Attribut r gleich dem Minimum von r mal XSCALAR resp. r mal YSCALAR setzen.
	 * </pre>
	 * 
	 * @param x
	 * @param y
	 * @param r
	 */
	public Zeiger(int x, int y, int r) {
		// 2
	}

	/**
	 * <pre>
	 * - Entsprechendes Attribut setzen.
	 * </pre>
	 * 
	 * @param winkel
	 */
	public void setzeWinkel(double winkel) {
		// 1
	}

	/**
	 * <pre>
	 * - Zeiger mit Drehpunkt x,y und Radius r entsprechend Winkel zeichnen.
	 * - Kreis mit Durchmesser 4 und Mitte bei x,y zeichnen.
	 * </pre>
	 */
	public void anzeigen(Graphics g) {
		// 2
	}
}

class StundenZeiger extends Zeiger {
	// 4

	/**
	 * Erzeugt via Konstruktor der Superklasse ein Objekt der Art StundenZeiger
	 * mit Position x, y und Radius r.
	 */
	public StundenZeiger(int x, int y, int r) {
		// 1
	}

	/**
	 * Setzt den Winkel (in Radiant) des Zeigers entsprechend stunde.
	 *
	 */
	public void setzeStunde(double stunde) {
		// 1
	}

	/**
	 * <pre>
	 * - Strichdicke mittels ((Graphics2D) g).setStroke(new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	 *   auf 2.0 setzen.
	 * - Methode anzeigen() der Superklasse aufrufen.
	 * </pre>
	 */
	public void anzeigen(Graphics g) {
		// 2
	}

}

class MinutenZeiger extends Zeiger {
	// 4

	/**
	 * Erzeugt via Konstruktor der Superklasse ein Objekt der Art MinutenZeiger
	 * mit Position x, y und Radius r.
	 */
	public MinutenZeiger(int x, int y, int r) {
		// 1
	}

	/**
	 * Setzt den Winkel (in Radiant) des Zeigers entsprechend minute.
	 *
	 */
	public void setzeMinute(double minute) {
		// 1
	}

	/**
	 * <pre>
	 * - Strichdicke mittels ((Graphics2D) g).setStroke(new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	 *   auf 1.5 setzen.
	 * - Methode anzeigen() der Superklasse aufrufen.
	 * </pre>
	 */
	public void anzeigen(Graphics g) {
		// 2
	}

}

class SekundenZeiger extends Zeiger {
	// 1

	/**
	 * Erzeugt via Konstruktor der Superklasse ein Objekt der Art SekundenZeiger
	 * mit Position x, y und Radius r.
	 */
	public SekundenZeiger(int x, int y, int r) {
		// 1
	}

	/**
	 * Setzt den Winkel (in Radiant) des Zeigers entsprechend sekunde.
	 *
	 */
	public void setzeSekunde(double sekunde) {
		// 1
	}

	/**
	 * <pre>
	 * - Strichdicke mittels ((Graphics2D) g).setStroke(new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	 *   auf 1.0 setzen.
	 * - Methode anzeigen() der Superklasse aufrufen.
	 * </pre>
	 */
	public void anzeigen(Graphics g) {
		// 2
	}

}
