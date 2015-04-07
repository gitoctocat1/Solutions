public class Influencer {

	/**
	 * Complexity O(n) Assumption : There can be at most one influencer
	 * 
	 * @param M
	 * @return
	 */
	int getInfluencer(int[][] M) {
		int candidate = 0;

		for (int i = 1; i < M.length; i++) {
			//check if i is a potential candidate
			//candidate is following i OR i is
			if (M[candidate][i] == 1 || M[i][candidate] == 0) {
				candidate = i;
			}
		}
		// now verify candidate is indeed an influencer
		for (int j = 0; j < M.length; j++) {
			if (j == candidate)
				continue;
			if (M[candidate][j] == 1 || M[j][candidate] == 0)
				return -1;
		}
		return candidate;
	}

}
