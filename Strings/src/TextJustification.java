import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public List<String> fullJustify(String[] words, int L) {
		int start = 0, end = -1, totalLength = 0;
		boolean isLast = false;
		List<String> result = new ArrayList<String>();
		int i = 0;
		while (i < words.length) {
			
			if (words[i].length() > L){
				return result;
			}
			
			int newLen = totalLength + (end - start + 1) + words[i].length();
			
			if (newLen <= L) { // words[i] can be in current line
				end = i;
				totalLength += words[i].length();
				i++;
			} else { // word[i-1] is the end of a line
				String line = createLine(words, L, start, end, totalLength, isLast);
				result.add(line);
				start = i;
				end = i - 1;
				totalLength = 0;
			}
		}

		//this is for the remaining words to get the last line
		isLast = true;
		String lastLine = createLine(words, L, start, end, totalLength, isLast);
		result.add(lastLine);
		return result;
	}

	public String createLine(String[] words, int L, int start, int end,
			int totalLength, boolean isLast) {
		
		StringBuilder line = new StringBuilder();
		if (start < 0 || end >= words.length || start > end){
			return line.toString();
		}	
		line.append(words[start]);
		int n = end - start + 1;

		// special case: one word or last line - left justified
		if (n == 1 || isLast) {
			for (int i = start + 1; i <= end; i++)
				line.append(" " + words[i]);
			int j = L - totalLength - (n - 1);
			for (int k = 0 ; k < j; k++){
				line.append(' ');	
			}
			
			return line.toString();
		}

		// normal case: fully justified
		int k = (L - totalLength) / (n - 1), m = (L - totalLength) % (n - 1);
		for (int i = start + 1; i <= end; i++) {
			int nspace = i - start <= m ? k + 1 : k;
			//append space n times
			for (int x = 0 ; x < nspace; x++){
				line.append(' ');	
			}
			
			line.append(words[i]);
		}
		return line.toString();
	}

	public static void main(String[] args) {
		String[] words = { "This", "is", "an", "example", "of", "text",
				"justification." };
		TextJustification tj = new TextJustification();
		List<String> result = tj.fullJustify(words, 16);
		System.out.println(result.size());
	}

	public List<String> fullJustify1(String[] words, int L) {

		List<String> result = new ArrayList<String>();

		if (words == null || words.length == 0) {
			return result;
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < words.length; i++) {
			sb = sb.append(words[i]).append(" ");

			if (sb.length() >= L) {
				result.add(sb.toString());
				sb.setLength(0);
				continue;
			} else if (i < words.length - 1
					&& sb.length() + words[i + 1].length() > L) {
				// add existing line to result
				result.add(sb.toString());
				// start new line
				sb.setLength(0);

			}
		}

		result.add(sb.toString());

		return result;
	}

}
