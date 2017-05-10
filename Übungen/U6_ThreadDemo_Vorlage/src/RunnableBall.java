import java.awt.Color;
import java.awt.Graphics;

public class RunnableBall implements Runnable {
	private Graphics g;
	private int x = 150, dx = 7;
	private int y = 150, dy = 2;
	private int d = 10;
	private int xLinks = 150, xRechts = 250;
	private int yOben = 150, yUnten = 250;
	private Color color = Color.red;
	private boolean weitermachen = true;
	private int index;
	private int count = 0;

	public RunnableBall(Graphics g, int index) {
		this.index = index;
		this.g = g;
		color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
	}

	public void run() {
		System.out.println("Ball: " + index + " gestartet");
		while (weitermachen) {
			// Rechteck zeichnen …
			g.setColor(Color.black);
			g.drawRect(xLinks, yOben, xRechts - xLinks + d, yUnten - yOben + d);

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Ball an alter Position löschen …
			g.setColor(Color.white);
			g.fillOval(x, y, d, d);
			// Neue Position des Balls berechnen …
			if (x + dx <= xLinks)
				dx = -dx;
			if (x + dx >= xRechts)
				dx = -dx;
			if (y + dy <= yOben)
				dy = -dy;
			if (y + dy >= yUnten)
				dy = -dy;
			x = x + dx;
			y = y + dy;
			// Ball an neuer Position zeichnen …
			g.setColor(color);
			g.fillOval(x, y, d, d);
			if(++count==100){
				weitermachen=false;
				System.out.println("Ball: " + index + " gestoppt");
			}

		}

	}

	public void stopp() {
		weitermachen = false;
		System.out.println("Ball: " + index + " gestoppt");
	}
}
