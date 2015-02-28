import java.util.HashMap;

public class IsomorphicVariation {

	public static void main(String[] args) {
		String data = "Hello World";
		String from = "lod";
		String to = "xpf";
		IsomorphicVariation iv = new IsomorphicVariation();
		System.out.println(iv.replace(data, to, from));

	}

	/**
	 * Given "data", "from", and "to" fields, replaces all occurrences of the
	 * characters in the "from" field in the "data" field, with their
	 * counterparts in the "to" field.
	 */

	public String replace(String data, String to, String from) {

		if (!(to.length() == from.length())) {
			return "";
		}

		HashMap<Character, Character> map = new HashMap<Character, Character>();

		for (int i = 0; i < from.length(); i++) {
			map.put(from.charAt(i), to.charAt(i));
		}

		char[] dataArray = data.toCharArray();

		for (int i = 0; i < dataArray.length; i++) {

			if (map.containsKey(dataArray[i])) {
				dataArray[i] = map.get(dataArray[i]);
			}
		}

		return new String(dataArray);

	}
}
