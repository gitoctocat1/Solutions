public class MaxSubMatrix {

	public void maxSubMatrix(int[][] matrix) {

		int i, j;
		int m = matrix.length;
		int n = matrix[0].length;

		int[][] sum = new int[m][n];

		int max_of_s, max_i, max_j;

		/* Set first column of S[][] */
		for (i = 0; i < m; i++)
			sum[i][0] = matrix[i][0];

		/* Set first row of S[][] */
		for (j = 0; j < n; j++)
			sum[0][j] = matrix[0][j];

		/* Construct other entries of S[][] */
		for (i = 1; i < m; i++) {
			for (j = 1; j < n; j++) {
				if (matrix[i][j] == 1)
					sum[i][j] = Math.min(Math.min(sum[i][j - 1], sum[i - 1][j]),sum[i - 1][j - 1]) + 1;
				else
					sum[i][j] = 0;
			}
		}

		/*
		 * Find the maximum entry, and indexes of maximum entry in S[][]
		 */
		max_of_s = sum[0][0];
		max_i = 0;
		max_j = 0;
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				if (max_of_s < sum[i][j]) {
					max_of_s = sum[i][j];
					max_i = i;
					max_j = j;
				}
			}
		}

		for (i = max_i; i > max_i - max_of_s; i--) {
			for (j = max_j; j > max_j - max_of_s; j--) {
				System.out.println(matrix[i][j]);
			}

		}
	}

}
