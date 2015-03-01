import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DNA {

	/**
	 * Keep finding substring of length 10 starting at every position. Add to
	 * hashmap with count. If the count for any entry is greater than 2, add to result
	 * 
	 * @param s
	 * @return
	 */
	public List<String> findRepeatedDnaSequences(String s) {

		List<String> result = new ArrayList<String>();

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i <= s.length() - 10; i++) {
			
			String substr = s.substring(i, i + 10);

			Integer key = Integer.valueOf(getKey(substr));

			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
				if (map.get(key) == 2)
					result.add(substr);
			} else
				map.put(key, 1);
		}
		return result;
	}

	/**
	 * Generate a custom hash function
	 * 
	 * @param s
	 * @return
	 */
	private static int getKey(String s) {
		
		int hash = 7;
		
		for (int i = 0; i < s.length(); i++) {
			hash = hash * 31 + s.charAt(i) * (i + 1);
		}
		return hash;
	}

}
