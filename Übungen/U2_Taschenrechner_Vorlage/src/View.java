import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JPanel implements ActionListener, Observer {
	private static final long serialVersionUID = 1L;

	private String[][] stButtonText = { { "7", "8", "9", "/", }, { "4", "5", "6", "*" }, { "1", "2", "3", "-" },
			{ " ", "0", " ", "+" } };

	private JTextField tfOut = new JTextField("hey");
	private JButton btEnter = new JButton("Enter");
	private JPanel btPanel = new JPanel(new GridLayout(4, 4, 5, 5));
	private JButton[][] button = new JButton[4][4];
	private JPanel hey=new JPanel(new GridBagLayout());

	private Controller controller;

	public View(Controller controller) {
		this.controller = controller;
		this.setLayout(new BorderLayout());

		tfOut.setEditable(false);
		add(tfOut, BorderLayout.NORTH);

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				button[i][j] = new JButton(stButtonText[i][j]);
				btPanel.add(button[i][j]);
				button[i][j].addActionListener(this);
			}
		}
		this.add(btPanel, BorderLayout.CENTER);
		
		hey.add(btEnter, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 10, 0), 0, 0));

		
		this.add(hey, BorderLayout.SOUTH);
		btEnter.addActionListener(this);
		this.setMaximumSize(new Dimension(500, 500));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "1":
			controller.number(1);
			break;
		case "2":
			controller.number(2);
			break;
		case "3":
			controller.number(3);
			break;
		case "4":
			controller.number(4);
			break;
		case "5":
			controller.number(5);
			break;
		case "6":
			controller.number(6);
			break;
		case "7":
			controller.number(7);
			break;
		case "8":
			controller.number(8);
			break;
		case "9":
			controller.number(9);
			break;
		case "+":
			controller.add();
			break;
		case "-":
			controller.subtract();
			break;
		case "*":
			controller.multiply();
			break;
		case "/":
			controller.divide();
			break;
		case "Enter":	tfOut.setText("dude");
			controller.enter();
			break;
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		Model model = (Model) o;
	}

}
