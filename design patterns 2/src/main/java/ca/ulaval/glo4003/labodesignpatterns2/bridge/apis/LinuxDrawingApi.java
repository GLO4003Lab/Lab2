package ca.ulaval.glo4003.labodesignpatterns2.bridge.apis;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Cet API prend le point (x, y) du coin supérieur gauche (origin) et 
 * inférieur droit (end). Le coin supérieur gauche de la fenêtre est (0, 0).
 * 
 * Donc : 
 * 
 * origin ---> *-------
 *             |      |
 *             |      |
 *             |      |
 *             -------* <--- end
 */
public class LinuxDrawingApi {

	private JFrame window;

	public LinuxDrawingApi() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(60, 60, 500, 500);
		window.setLayout(null);
		window.setVisible(true);
	}

	public void drawSquare(int originX, int originY, int endX, int endY) {
		window.getContentPane().add(new Square(originX, originY, endX, endY));
	}

	private class Square extends JPanel {

		private int length;

		public Square(int originX, int originY, int endX, int endY) {
			this.length = endX - originX;
			this.setSize(length + 1, length + 1);
			this.setLocation(originX, originY);
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawRect(0, 0, length, length);
		}

		private static final long serialVersionUID = 1L;

	}

}
