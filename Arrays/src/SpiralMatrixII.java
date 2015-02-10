public class SpiralMatrixII {

	/**
	 * Complexity O(m*n)
	 * @param n
	 * @return
	 */
	public int[][] generateMatrix(int n) {

		// number of rows equals number of columns
		int m = n;

		int[][] matrix = new int[m][n];

		if (n == 0) {
			return matrix;
		}
		// variables to track the indexes
		int x = 0;
		int y = 0;

		int value = 1;

		if (n == 1) {
			matrix[0][0] = 1;
			return matrix;
		}

		while (m > 0 && n > 0) {

			// single row
			if (m == 1) {

				for (int i = 0; i <= n - 1; i++) {
					matrix[x][y++] = value;
					value++;
				}
				break;

			}
			// single column
			else if (n == 1) {

				for (int i = 0; i <= m - 1; i++) {
					matrix[x++][y] = value;
					value++;
				}
				break;

			} else {

				// top left->right
				for (int i = 0; i < m - 1; i++) {
					matrix[x][y++] = value;
					value++;
				}

				// bottom top->down
				for (int i = 0; i < n - 1; i++) {
					matrix[x++][y] = value;
					value++;
				}

				// bottom right->left
				for (int i = 0; i < n - 1; i++) {
					matrix[x][y--] = value;
					value++;

				}

				// top down->top
				for (int i = 0; i < m - 1; i++) {
					matrix[x--][y] = value;
					value++;
				}

				// decrement the number of rows and columns by two since we
				// finish itertaing them
				x++;
				y++;
				m = m - 2;
				n = n - 2;
			}

		}
		return matrix;

	}

}
