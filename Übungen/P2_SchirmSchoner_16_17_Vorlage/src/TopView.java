
// Name: 
// Vorname:

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class TopView extends JPanel implements SimpleTimerListener, MouseMotionListener {
	// 21
	private Uhr uhr;
	private KontrollPanel kontrollPanel;
	private int zaehler;
	private SimpleTimer timer = new SimpleTimer(1000, this);

	/**
	 * <pre>
	 * - Ruft den Konstruktor der Superklasse mit Argument null auf und setzt somit das null-Layout.
	 * - Setzt XSCALAR des GrafikObjekt gleich Breite durch 1920 und YSCALAR gleich Höhe durch 1080.
	 * - Erzeugt die Uhr mit Zeigerposition 1623,530.
	 * - Erzeugt das Kontroll-Panel und fügt es an geeigneter Stelle hinzu.
	 * - Registriert entsprechenden Listener.
	 * - Startet den Timer mittels start();
	 * </pre>
	 * 
	 * @param breite
	 * @param hoehe
	 */
	public TopView(int breite, int hoehe) {
		// 8
	}

	/**
	 * <pre>
	 * - Setzt die Reneder - Qualität High.
	 * - ruft die Uhr zum Anzeigen auf.
	 * </pre>
	 */
	public void paintComponent(Graphics g) {
		// 3
	}

	/**
	 * <pre>
	 * - Methode update() der Uhr aufrufen.
	 * - Falls zaehler gleich Null
	 *   - Kontroll-Panel mittels der Methode setVisible() unsichtbar machen.
	 *   - Den unsichtbaren Cursor mittels Utility holen und mittels setCursor() setzen.
	 * - Sonst 
	 *   - zaehler dekrementieren.
	 * - Neuzeichnen auslösen.
	 * </pre>
	 */
	public void timerAction() {
		// 7
	}

	/**
	 * <pre>
	 * - zaehler auf 10 setzen.
	 * - Kontroll-Panel mittels der Methode setVisible() sichtbar machen.
	 * - Den default Cursor mittels Utility holen und mittels setCursor() setzen.
	 * </pre>
	 */
	public void mouseMoved(MouseEvent arg0) {
		// 3
	}

	public void mouseDragged(MouseEvent arg0) {
	}

	private void setHighRenderQuality(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
	}
}
