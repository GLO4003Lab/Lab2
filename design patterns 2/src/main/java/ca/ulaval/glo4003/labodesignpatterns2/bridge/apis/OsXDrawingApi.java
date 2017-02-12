package ca.ulaval.glo4003.labodesignpatterns2.bridge.apis;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Cet API prend le point (x, y) du coin supérieur gauche (origin) et
 * la longueur d'un coté du carré. L'orientation défini la rotation, 
 * dans le sens anti-horaire, en degré.
 * 
 * Donc : 
 *                                 270
 *              length              ^
 *             <------>             |
 *                                  |
 * origin ---> *-------     190 <---#---> 0 ou 360
 *             |      |             |
 *             |      |             |
 *             |      |             v
 *             --------             90
 *             
 *             
 */
public class OsXDrawingApi {

	private JFrame window;

	public OsXDrawingApi() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(60, 60, 500, 500);
		window.setLayout(null);
		window.setVisible(true);
	}

	public void drawSquare(Point origin, int length, int orientation) {
		window.getContentPane().add(new TiltingSquare(origin.x, origin.y, length, orientation));
	}

	private class TiltingSquare extends JPanel {

		private int length;
		private int orientation;

		public TiltingSquare(int x, int y, int length, int orientation) {
			this.length = length;
			this.orientation = orientation;
			this.setLocation(x, y);
			this.setSize(length + 1, length + 1);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			Rectangle rect2 = new Rectangle(0, 0, length, length);

			g2d.rotate(Math.toRadians(orientation));
			g2d.draw(rect2);
		}

		private static final long serialVersionUID = 1L;

	}
}
