import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class FrequenzgangApplikation extends JFrame {
	private static final long serialVersionUID = 7529693236378777836L;
	private boolean packFrame = true;
	private int width, height;
	private Model model = new Model(0, 10e3, 1000);
	private Controller controller = new Controller(model);
	private View view = new View(controller);

	public void init() {
		controller.setView(view);
		model.addObserver(view);
		this.add(view);

		if (packFrame) {
			this.pack();
			width = this.getWidth();
			height = this.getHeight();
		} else {
			this.setSize(width, height);
			this.validate();
		}
		// Center the window
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		this.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
		this.setMinimumSize(getPreferredSize());
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
//				try {
//					UIManager.setLookAndFeel(new MyNimRODLookAndFeel(
//							"nimRodThemes\\Night.theme"));
//				} catch (Exception exception) {
//					exception.printStackTrace();
//				}
				FrequenzgangApplikation demo = new FrequenzgangApplikation();
				demo.setTitle("Frequenzgang - Applikation");
				demo.init();
				demo.setVisible(true);
			}
		});
	}
}
