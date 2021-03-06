public class FloodFill {

	void floodFill(int screen[][], int x, int y, int newC) {
		int prevC = screen[x][y];
		floodFillUtil(screen, x, y, prevC, newC);
	}

	void floodFillUtil(int screen[][], int x, int y, int prevC, int newC) {

		int m = screen.length;
		int n = screen[0].length;
		// Base cases
		if (x < 0 || x >= m || y < 0 || y >= n)
			return;

		if (screen[x][y] != prevC)
			return;

		// Replace the color at (x, y)
		screen[x][y] = newC;

		// Recur for north, east, south and west
		floodFillUtil(screen, x + 1, y, prevC, newC);
		floodFillUtil(screen, x - 1, y, prevC, newC);
		floodFillUtil(screen, x, y + 1, prevC, newC);
		floodFillUtil(screen, x, y - 1, prevC, newC);
	}

}
