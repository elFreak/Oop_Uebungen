import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

public class ExceptionApplet extends Applet implements ActionListener {
	private static final long serialVersionUID = 1L;
	private TextField eingabeTf = new TextField(20);
	private TextField ausgabeTf = new TextField(20);

	public void init() {
		add(new Label("  Geben Sie eine Ganzzahl ein:"));
		eingabeTf = new TextField(25);
		add(eingabeTf);
		eingabeTf.addActionListener(this);
		add(new Label("  Ausgabe:"));
		ausgabeTf = new TextField(25);
		add(ausgabeTf);
		ausgabeTf.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			try {
				int zahl = Integer.parseInt(eingabeTf.getText());
				if (zahl > 5)
					throw new Exception();
				ausgabeTf.setText("" + 2 * zahl);
			} catch (NumberFormatException ex) {
				// return;
				System.out.println("ciao");
				return;

				//
			} finally {
				System.out.println("hey");
			}
			System.out.println("no error");

		} catch (Exception ex) {
			System.out.println("guy");
		}
	}

}