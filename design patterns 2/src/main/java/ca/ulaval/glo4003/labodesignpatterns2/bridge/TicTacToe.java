package ca.ulaval.glo4003.labodesignpatterns2.bridge;

import java.awt.Point;

public class TicTacToe {

	private final static int WINDOW_SIZE = 500;
	private final static int SQUARE_SIZE = 100;
	private final static int WINDOW_OFFSET = (WINDOW_SIZE - SQUARE_SIZE * 3) / 2;

	public TicTacToe() {
	}

	public void draw() {
		for (int column = 0; column < 3; column++) {
			for (int line = 0; line < 3; line++) {

				/*-
				 * Afin de vous éviter d'avoir à faire des Maths, voici les formules pour calculer
				 * différents points de chacun des carrés. Vous n'avez pas besoin de tous ces points
				 *
				 *  Ces calculs dessineront les carrés au milieu de l'écran. Vous pouvez les prendre ou en
				 *  prendre d'autres. Au final vous deviez avoir quelque chose du genre :
				 *
				 *  |¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|
				 *  |                             |
				 *  |     *-----*-----*-----*     |
				 *  |     |     |     |     |     |
				 *  |     |     |     |     |     |
				 *  |     *-----*-----*-----*     |
				 *  |     |     |     |     |     |
				 *  |     |     |     |     |     |
				 *  |     *-----*-----*-----*     |
				 *  |     |     |     |     |     |
				 *  |     |     |     |     |     |
				 *  |     *-----*-----*-----*     |
				 *  |                             |
				 *  |_____________________________|
				 */

				Point topLeftCorner = new Point(WINDOW_OFFSET + column * SQUARE_SIZE, WINDOW_OFFSET + line * SQUARE_SIZE);
				Point topRightCorder = new Point(WINDOW_OFFSET + (column + 1) * SQUARE_SIZE, WINDOW_OFFSET + line * SQUARE_SIZE);
				Point bottomLeftCorner = new Point(WINDOW_OFFSET + column * SQUARE_SIZE, WINDOW_OFFSET + (line + 1) * SQUARE_SIZE);
				Point bottomRightCorner = new Point(WINDOW_OFFSET + (column + 1) * SQUARE_SIZE, WINDOW_OFFSET + (line + 1) * SQUARE_SIZE);
				Point center = new Point(WINDOW_OFFSET + column * SQUARE_SIZE + SQUARE_SIZE / 2, WINDOW_OFFSET + line * SQUARE_SIZE + SQUARE_SIZE / 2);
			}
		}
	}

}