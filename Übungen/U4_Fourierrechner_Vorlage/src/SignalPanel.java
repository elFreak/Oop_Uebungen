import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import figure.AbstractAxes;
import figure.Line;
import figure.PlotAxes;

public class SignalPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public Line line = new Line(Color.yellow);
	private PlotAxes signalAxes = new PlotAxes();

	public SignalPanel() {
		super(new BorderLayout());
		setPreferredSize(new Dimension(375, 350));
		setBorder(new TitledBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.white, new Color(165, 163, 151)),
				" Signal "));

		signalAxes.setAxesMode(AbstractAxes.LIN_LIN);
		signalAxes.setAxis(0, 1.0, -2.0, 2.0);
		signalAxes.setTickSpacing(0.25, 0.125, 0.5, 0.25);
		signalAxes.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		signalAxes.setLabel("Zeit [t/T]", "Amplitude");
		signalAxes.setFigureColor(getBackground());
		signalAxes.setPlotColor(Color.darkGray);
		signalAxes.setFrameColor(Color.white);
		signalAxes.setGridColor(Color.white);
		signalAxes.setTextColor(Color.black);
		signalAxes.setTickColor(Color.black);
		signalAxes.setFrameColor(Color.black);
		signalAxes.addAxesObject(line);
		line.setWidth(2.0f);

		add(signalAxes, java.awt.BorderLayout.CENTER);
	}

	public void update(Observable obs, Object obj) {
		Model model = (Model) obs;
		line.setData(model.getTAxis(), model.getSignal());
		repaint();
	}
}
