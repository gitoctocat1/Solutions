import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	/**
	 * Complexity O(m*n)
	 * @param matrix
	 * @return
	 */
	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> result = new ArrayList<Integer>();

		if (matrix == null || matrix.length == 0) {
			return result;
		}

		int m = matrix.length;
		int n = matrix[0].length;

		// variables to track the indexes
		int x = 0;
		int y = 0;

		while (m > 0 && n > 0) {

			// single row
			if (m == 1) {

				for (int i = 0; i < n; i++) {
					result.add(matrix[x][y++]);
				}
				break;
			}
			// single column
			else if (n == 1) {
				for (int i = 0; i < m; i++) {
					result.add(matrix[x++][y]);
				}
				break;
			} else {

				// top left->right
				for (int i = 0; i < n - 1; i++) {
					result.add(matrix[x][y++]);
				}

				// bottom top->down
				for (int i = 0; i < m - 1; i++) {
					result.add(matrix[x++][y]);
				}

				// bottom right->left
				for (int i = 0; i < n - 1; i++) {
					result.add(matrix[x][y--]);
				}

				// top down->top
				for (int i = 0; i < m - 1; i++) {
					result.add(matrix[x--][y]);
				}

				// decrement the number of rows and columns by two since we
				// finish itertaing them
				m = m - 2;
				n = n - 2;
				x++;
				y++;

			}
		}

		return result;
	}
}
