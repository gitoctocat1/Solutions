import java.util.Stack;

public class ReversePolishNotation {

	/**
	 * Complexity O(n) and O(n) space
	 */
	public int evalRPN(String[] tokens) {

		Stack<String> stack = new Stack<String>();

		String operators = "+-*/";

		int result = 0;

		for (int i = 0; i < tokens.length; i++) {

			if (tokens[i].equals("+") || tokens[i].equals("*")
					|| tokens[i].equals("-") || tokens[i].equals("/")) {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());

				int index = operators.indexOf(tokens[i]);

				switch (index) {
				case 0:
					stack.push(String.valueOf(a + b));
					break;
				case 1:
					stack.push(String.valueOf(b - a));
					break;
				case 2:
					stack.push(String.valueOf(a * b));
					break;
				case 3:

					stack.push(String.valueOf(b / a));
					break;
				}

			}

			else {

				stack.push(tokens[i]);
			}

		}
		result = Integer.valueOf(stack.pop());

		return result;
	}
}
