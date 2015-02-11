public class ValidNumber {

	/**
	 * Complexity O(n)
	 * Check for whitespaces, digits, exponent, sign
	 * @param s
	 * @return
	 */
	public boolean isNumber(String s) {

		//remove whitespaces
		s = s.trim();
		
		int state = 1;
		//symbols + or -
		boolean canSymbolAppear = true;
		
		boolean valid = false;
		
		//for exponent
		boolean canPointAppear = true;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			//symbols can appear only once at the start
			if ((c == '+' || c == '-') && canSymbolAppear) {
				canSymbolAppear = false;
				continue;
			}
			switch (state) {
			case 1:
				if (isDigit(c)) {
					valid = true;
					//once we have a digit, + or - cant appear
					canSymbolAppear = false;
					continue;
				} else if (isPoint(c) && canPointAppear) {
					canPointAppear = false;
					canSymbolAppear = false;
					continue;
				} else if (isE(c) && valid) {
					//allow only digits going forward e.g 2e10
					state = 2;
					canSymbolAppear = true;
					valid = false;
					continue;
				} else
					return false;

			case 2:
				if (isDigit(c)) {
					valid = true;
					canSymbolAppear = false;
					continue;
				} else
					return false;
			default:
				return false;
			}

		}
		
		if (valid)
			return true;
		else
			return false;

	}

	//check if a character is between 0 and 9
	public boolean isDigit(char s) {
		return (s >= '0' && s <= '9');
	}

	public boolean isPoint(char s) {
		return s == '.';
	}

	public boolean isE(char s) {
		return (s == 'e' || s == 'E');
	}
}
