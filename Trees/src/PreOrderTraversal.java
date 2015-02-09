import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Complexity O(n)
 *
 *
 */
public class PreOrderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {

		Stack<TreeNode> stack = new Stack<TreeNode>();

		List<Integer> result = new ArrayList<Integer>();

		if (root == null) {
			return result;
		}

		stack.push(root);

		while (!stack.isEmpty()) {

			TreeNode node = stack.pop();
			result.add(node.value);

			// push the right node before left node
			if (node.right != null) {
				stack.push(node.right);
			}

			if (node.left != null) {
				stack.push(node.left);
			}
		}

		return result;
	}

}
