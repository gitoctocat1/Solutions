import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Complexity O(n); Use stack to push nodes in order root,left, right
 * @author deepa
 *
 */
public class InOrderTraversal {
	
	public List<Integer> inorderTraversal(TreeNode root) {

		Stack<TreeNode> stack = new Stack<TreeNode>();

		List<Integer> result = new ArrayList<Integer>();

		if (root == null) {
			return result;
		}

		stack.push(root);

		TreeNode p = root.left;

		while (!stack.isEmpty() || p != null) {

			//while left is not null, keep pushing into stack
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				p = stack.pop();
				result.add(p.value);
				p = p.right;
			}
		}

		return result;

	}
}
