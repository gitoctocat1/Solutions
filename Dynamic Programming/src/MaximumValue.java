/**
 * A board has n*m cells, and there is a gift with some value (value is greater
 * than 0) in every cell. You can get gifts starting from the top-left cell, and
 * move right or down in each step, and finally reach the cell at the
 * bottom-right cell. What’s the maximal value of gifts you can get from the
 * board?
 *
 */
public class MaximumValue {

	public static void main(String[] args) {

		int[][] values = new int[4][4];
		values[0][0] = 1;
		values[0][1] = 10;
		values[0][2] = 3;
		values[0][3] = 8;

		values[1][0] = 12;
		values[1][1] = 2;
		values[1][2] = 9;
		values[1][3] = 6;

		values[2][0] = 5;
		values[2][1] = 7;
		values[2][2] = 4;
		values[2][3] = 11;

		values[3][0] = 3;
		values[3][1] = 7;
		values[3][2] = 16;
		values[3][3] = 5;
		
		System.out.println(getMaxValue(values));
	}
	
	
	public static int getMaxValue(int[][] values) {
	    int rows = values.length;
	    int cols = values[0].length;
	    int[][] maxValues = new int[rows][cols];

	    for(int i = 0; i < rows; ++i) {
	        for(int j = 0; j < cols; ++j) {
	            int left = 0;
	            int up = 0;

	            if(i > 0) {
	                up = maxValues[i - 1][j];
	            }

	            if(j > 0) {
	                left = maxValues[i][j - 1];
	            }

	            maxValues[i][j] = Math.max(left, up) + values[i][j];
	        }
	    }

	    return maxValues[rows - 1][cols - 1];
	}
}
