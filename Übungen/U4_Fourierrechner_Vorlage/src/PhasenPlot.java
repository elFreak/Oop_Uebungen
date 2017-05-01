import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Observable;

import javax.swing.JPanel;

import figure.AbstractAxes;
import figure.PlotAxes;
import figure.Stem;

public class PhasenPlot extends JPanel {
	private static final long serialVersionUID = 1L;
	private PlotAxes plotAxes = new PlotAxes();
	private Stem line = new Stem(Color.yellow);

	public PhasenPlot() {
		super(new BorderLayout());

		plotAxes.setAxesMode(AbstractAxes.LIN_LIN);
		plotAxes.setAxis(0, 24e3, -180, 180);
		plotAxes.setTickSpacing(6e3, 2e3, 60, 20);
		plotAxes.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		plotAxes.setLabel("Frequenz [kHz]", "Phase [degrees]");
		plotAxes.setFigureColor(getBackground());
		plotAxes.setPlotColor(Color.darkGray);
		plotAxes.setFrameColor(Color.white);
		plotAxes.setGridColor(Color.white);
		plotAxes.setTextColor(Color.black);
		plotAxes.setTickColor(Color.black);
		plotAxes.setFrameColor(Color.black);
		plotAxes.addAxesObject(line);
		line.setWidth(2.0f);

		add(plotAxes, java.awt.BorderLayout.CENTER);
	}

	public void update(Observable obs, Object obj) {
		Model model = (Model) obs;
		line.setData(model.getFAxis(), model.getPhase());
		repaint();
	}

}
