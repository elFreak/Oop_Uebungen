import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ParameterPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public JTextField tfAmp = new JTextField(40);
	public JTextField tfPhase = new JTextField(40);
	public JTextField tfFreq = new JTextField(40);

	/**
	 * Erzeugt ein Parameter Panel, als GridBagLayout organisiert, mit Labeln
	 * und Textfeldern fuer Amplitude, Phase und Grundfrequenz.
	 */
	public ParameterPanel() {
		super(new GridBagLayout());
		setBorder(new TitledBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.white, new Color(165, 163, 151)),
				" Signalparameter "));

		add(new Label("Amplitude:  "), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		tfAmp.setText("Rechteck");
		add(tfAmp, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

		add(new Label("Phase:  "), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		tfPhase.setText("");
		add(tfPhase, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

		add(new Label("Grundfrequenz:  "), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		tfFreq.setText("1e3");
		add(tfFreq, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
	}
}
