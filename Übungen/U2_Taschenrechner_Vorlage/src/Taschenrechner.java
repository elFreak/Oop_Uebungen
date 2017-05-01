import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Taschenrechner extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private Model model = new Model();
	private Controller controller = new Controller(model);
	private View view = new View(controller);

	public Taschenrechner() {

		// Center the window
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		
		this.add(view);
		model.addObserver(view);
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				Taschenrechner frame = new Taschenrechner();
				frame.setUndecorated(true);
				frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("UPN Taschenrechner");
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

}
