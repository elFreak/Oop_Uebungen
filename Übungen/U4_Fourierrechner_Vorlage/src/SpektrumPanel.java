import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class SpektrumPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private AmplitudenPlot ampPlt = new AmplitudenPlot();
	private PhasenPlot phPlt = new PhasenPlot();

	public SpektrumPanel() {
		super(new GridBagLayout());
		setPreferredSize(new Dimension(375, 350));
		setBorder(new TitledBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.white, new Color(165, 163, 151)),
				" Spektrum "));
		add(ampPlt, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		add(phPlt, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
	}

	public void update(Observable obs, Object obj) {
		ampPlt.update(obs, obj);
		phPlt.update(obs, obj);
	}
}
