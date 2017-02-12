package ca.ulaval.glo4003.labodesignpatterns2.bridge.apis;

import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

/*
 * Cet API ne permet de dessiné que des lignes. Vous pouvez en ajouter plusieurs
 * en apellant drawLine() plusieurs fois.
 * 
 * Pour dessiné une ligne, simplement donné le point de départ (x, y)
 * et le point d'arrivé (x, y).
 */
public class WindowsDrawingApi {

	private Canvas canvas;

	public WindowsDrawingApi() {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(90, 90, 500, 500);
		canvas = new Canvas();
		window.getContentPane().add(canvas);
		window.setVisible(true);
	}

	public void drawLine(Point start, Point end) {
		canvas.addLine(start, end);
		canvas.repaint();
	}

	private class Canvas extends JComponent {

		private List<Line> lines = new LinkedList<>();

		public void addLine(Point start, Point end) {
			lines.add(new Line(start, end));
		}

		public void paint(Graphics g) {
			for (Line line : lines) {
				g.drawLine(line.start.x, line.start.y, line.end.x, line.end.y);
			}
		}

		private static final long serialVersionUID = 1L;

	}

	private class Line {
		public Point start;
		public Point end;

		public Line(Point start, Point end) {
			this.start = start;
			this.end = end;
		}
	}

}
