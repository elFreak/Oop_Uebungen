import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class KontrollPanel extends JPanel implements ActionListener {
	// 16
	private JButton btExit = new JButton("Exit");
	private JButton btTest = new JButton("Test");
	private JTextField tfStunde = new JTextField("12");
	private JTextField tfMinute = new JTextField("15");
	private Uhr uhr;

	/**
	 * <pre>
	 * - Ruft den Konstruktor der Superklasse mit Argument null auf
	 *   und setzt somit das null-Layout.
	 * - Setzt das entsprechende Attribut der Uhr.
	 * - Baut das User-Interface gemäss Dokumentation.
	 * 
	 * </pre>
	 * 
	 * @param uhr
	 * @param breite
	 * @param hoehe
	 */
	public KontrollPanel(Uhr uhr, int breite, int hoehe) {
		// 9
	}

	@Override
	/**
	 * <pre>
	 * - Falls Quelle des Ereignisses gleich Exit-Button:
	 *     - System.exit() mit Argument 0 aufrufen.
	 * - Falls Quelle des Ereignisses gleich Test-Button:
	 *     - Methode schlag() der Uhr, mit Stunde und Minute gegeben durch die Textfelder und 0 Sekunden, aufrufen.
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		// 4
	}
}
