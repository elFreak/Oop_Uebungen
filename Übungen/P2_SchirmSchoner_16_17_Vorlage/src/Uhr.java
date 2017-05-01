
// Name: 
// Vorname:

import java.applet.AudioClip;
import java.awt.Graphics;
import java.util.Calendar;

public class Uhr extends GrafikObjekt {
	// 28
	private HGBildObjekt hgBildObjekt;

	/**
	 * <pre>
	 * - Erzeugt das HGBildObjekt, sowie den Sekunden-, Minuten- und Stundenzeiger an 
	 *   entsprechender Position mit den Radien 23, 21 und 21.
	 * - Lädt sämtliche Strikes in den entsprechenden AudionClip - Array.
	 * </pre>
	 * 
	 * @param xZeiger
	 * @param yZeiger
	 * @param breite
	 * @param hoehe
	 */
	public Uhr(int xZeiger, int yZeiger, int breite, int hoehe) {
		// 6
	}

	/**
	 * <pre>
	 * - Ruft die entsprechenden Objekte zu zeichnen auf.
	 * </pre>
	 */
	public void anzeigen(Graphics g) {
		// 4
	}

	/**
	 * <pre>
	 * - Erzeugt mittels Calendar.getInstance() einen lokalen Kalender.
	 * - Die Sekunde, Minute und Stunde lässt sich mittels calendar.get(Calendar.SECOND),
	 *   get(Calendar.MINUTE) resp. get(Calendar.HOUR_OF_DAY) auslesen.
	 * - Setzt die Zeiger entsprechend Sekunde, Minute und Sekunde, Minute und Stunde, 
	 *   damit Minuten- und Stundenzeiger nicht springen.
	 * </pre>
	 */
	public void update() {
		// 8
	}

	/**
	 * <pre>
	 * - Falls Sekunde gleich Null:
	 *   - Wenn Minute 0:
	 *       - Stundenschlag an der Stelle (stunde % 12) spielen.
	 *   - Wenn Minute 15
	 *       - Quarter - Schlag spielen.
	 *   - Wenn Minute 30
	 *       - Half - Schlag spielen.
	 *   - Wenn Minute 45
	 *       - Three-Quarter - Schlag spielen.
	 * </pre>
	 * 
	 * @param stunde
	 * @param minute
	 * @param sekunde
	 */
	public void schlag(int stunde, int minute, int sekunde) {
		// 9
	}
}
