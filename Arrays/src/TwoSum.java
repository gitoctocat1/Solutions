import java.util.HashMap;


public class TwoSum {
	
	/**
	 * Complexity O(n) space O(1)
	 * 
	 * e.g {2,7,9,11} target = 13
	 * --------------
	 * |key   |val|
	 * -------------
	 * |13 -9 | 2 |
	 * |13 -7 | 1 |
	 * |13 -2 | 0 |
	 * 
	 * 11 already exists as key ; return index+1 and i+!
	 * @param numbers
	 * @param target
	 * @return
	 */
    public int[] twoSum(int[] numbers, int target) {
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	int[] result = new int[2];
 
	for (int i = 0; i < numbers.length; i++) {
		if (map.containsKey(numbers[i])) {
			int index = map.get(numbers[i]);
			result[0] = index+1 ;
			result[1] = i+1;
			break;
		} else {
			map.put(target - numbers[i], i);
		}
	}
 
	return result;
    }

}
