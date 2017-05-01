import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class FourierRechner extends JFrame {

	private static final long serialVersionUID = 1L;
	private Model model = new Model();
	private Controller controller = new Controller(model);
	private View view = new View(controller);

	public FourierRechner() {

		model.addObserver(view);
		getContentPane().add(view);
		
		setTitle("Fourier - Rechner");
		pack();
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				new FourierRechner();
			}
		});
	}
}
