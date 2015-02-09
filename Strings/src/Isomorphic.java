import java.util.HashMap;
import java.util.Map;


public class Isomorphic {
	
	public static boolean isIsomorphic(String inputString1, String inputString2) {
        int length1 = inputString1.length();
        int length2 = inputString2.length();
        if (length1 != length2) {
            return false;
        }
        if (length1 == 1) {
            return true;
        }
        Map<Character, Character> characterMap = new HashMap<Character, Character>();
        for (int i = 0; i < length1; i++) {
            if (!characterMap.containsKey(inputString1.charAt(i)) && !characterMap.containsValue(inputString2.charAt(i))) {
                characterMap.put(inputString1.charAt(i), inputString2.charAt(i));
            }
            if (characterMap.get(inputString1.charAt(i)) == null) {
                return false;
            }
            if (!characterMap.get(inputString1.charAt(i)).equals(inputString2.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
