import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;

public class HGBildObjekt extends GrafikObjekt {
	// 21
	protected Image hgBild;
	protected Image[] blitzBild = new Image[3];
	protected AudioClip[] donnerClip = new AudioClip[3];
	protected final double SCHWELLE = 0.9;
	private double gewitterSchwelle = SCHWELLE;
	private double step = -0.25;
	private boolean gewitter = false;

	/**
	 * <pre>
	 * TEIL 1:
	 * - Hintergrundbild BigBenLondon.png in entsprechendes Attribut laden. 
	 * 
	 * TEIL 2:
	 * - Die drei Blitz-Bilder und die drei AudioClips in die entsprechenden 
	 *   Arrays laden.
	 * </pre>
	 * 
	 * @param breite
	 * @param hoehe
	 */
	public HGBildObjekt(int breite, int hoehe) {
		// 1 + 3
	}

	/**
	 * <pre>
	 * TEIL 1:
	 * - Hintergrundbild an der Stelle x,y mit Observer null zeichnen.
	 * 
	 * Teil 2:
	 * - Falls Zufalszahl mit Bereich 0 ... 1.0 grösser der gewitterSchwelle:
	 *     - Zufällig eines der drei Blitz-Bilder zeichnen und einen der drei 
	 *       AudioClips spielen. Wir sind nun im Gewitter - Modus: Entsprechendes 
	 *       Attribut auf wahr setzen.
	 * - Falls wir im Gewitter - Modus sind:
	 *     - gewitterSchwelle bei jedem Aufruf von anzeigen() sukzessive um step reduzieren
	 *       bis 0.5 erreicht ist, anschliessend Vorzeichen von step drehen und dann gewitterSchwelle
	 *       sukzessive um step erhöhen, bis 1.5 erreicht ist. Beim erreichen von 1.5 Gewitter-Modus
	 *       verlassen, Vorzeichen von step wieder drehen und gewitterSchwelle gleich SCHWELLE setzen.
	 * </pre>
	 */
	public void anzeigen(Graphics g) {
		// 1 + 13
	}
}
