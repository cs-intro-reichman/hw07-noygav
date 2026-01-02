/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
			StdDraw.line(x1, y1, x2, y2);
			return;
		}
		double dx = (x2 - x1) / 3.0;
		double dy = (y2 - y1) / 3.0;
		double xA = x1;
		double yA = y1;
		double xB = x1 + dx;
		double yB = y1 + dy;
		double xD = x1 + 2 * dx;
		double yD = y1 + 2 * dy;
		double xE = x2;
		double yE = y2;
		double sqrt3over2 = Math.sqrt(3) / 2.0;
		double xC = sqrt3over2 * (yB - yD) + (xB + xD) / 2.0;
		double yC = sqrt3over2 * (xD - xB) + (yB + yD) / 2.0;
		curve(n - 1, xA, yA, xB, yB);
		curve(n - 1, xB, yB, xC, yC);
		curve(n - 1, xC, yC, xD, yD);
		curve(n - 1, xD, yD, xE, yE);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		double x1 = 0.5, y1 = 1.0;
		double x2 = 0.0, y2 = 0.0;
		double x3 = 1.0, y3 = 0.0;
		curve(n, x1, y1, x2, y2);
		curve(n, x2, y2, x3, y3);
		curve(n, x3, y3, x1, y1);
	}
}
