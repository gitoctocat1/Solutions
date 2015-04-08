import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	/**
	 * Check if ab > ba
	 */
	public static Comparator<String> comparator = new Comparator<String>() {

		@Override
		public int compare(String a, String b) {
			String ab = a + b;
			String ba = b + a;

			return ba.compareTo(ab);
		}
	};

	/**
	 * O(n lg n )
	 * Convert to string and compare
	 * @param num
	 * @return
	 */
	public String largestNumber(int[] num) {
		if (num == null || num.length == 0) {
			return "";
		}

		String[] array = new String[num.length];
		for (int i = 0; i < num.length; i++) {
			array[i] = String.valueOf(num[i]);
		}

		Arrays.sort(array, comparator);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
		}

		java.math.BigInteger result = new java.math.BigInteger(sb.toString());
		return result.toString();

	}
}
