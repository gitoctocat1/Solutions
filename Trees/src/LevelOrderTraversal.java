import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Complexity O(n)
 * @author deepa
 *
 */
public class LevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result = new LinkedList<List<Integer>>();

		//use a queue to keep track of nodes
		List<TreeNode> queue = new LinkedList<TreeNode>();

		//holds the nodes in each level
		List<Integer> list = new ArrayList<Integer>();

		int nodesInCurrentLevel = 1;

		int nodesInNextLevel = 0;

		if (root == null) {
			return result;
		}

		queue.add(root);

		while (!queue.isEmpty()) {

			TreeNode node = queue.remove(0);

			nodesInCurrentLevel--;

			if (node != null) {
				list.add(node.value);
				
				//check for empty nodes
				if (node.left != null) {
					queue.add(node.left);
					nodesInNextLevel++;
				}
				if (node.right != null) {
					queue.add(node.right);
					nodesInNextLevel++;
				}
			}

			//once we finished processing all nodes in current level, reset the count and clear the list
			if (nodesInCurrentLevel == 0) {
				nodesInCurrentLevel = nodesInNextLevel;
				nodesInNextLevel = 0;

				result.add(list);
				//clear the list
				list = new ArrayList();
			}

		}

		return result;
	}

	// Using two queues
	public List<List<Integer>> levelOrderWithTwoQueue(TreeNode root) {

		// List<Integer> result = new LinkedList<Integer>();

		List<List<Integer>> result = new LinkedList<List<Integer>>();

		if (root == null) {
			return result;
		}

		List<TreeNode> currentLevel = new LinkedList<TreeNode>();

		List<TreeNode> nextLevel = new LinkedList<TreeNode>();

		List<Integer> list = new ArrayList<Integer>();

		// add root to the current level
		currentLevel.add(root);

		while (!currentLevel.isEmpty()) {

			// removes head of the list
			TreeNode node = currentLevel.remove(0);

			if (node.left != null) {
				nextLevel.add(node.left);
			}

			if (node.right != null) {
				nextLevel.add(node.right);
			}

			list.add(node.value);

			List<TreeNode> temp = new LinkedList<TreeNode>();

			// if we finsihed all nodes in current level, swap current and next
			// level nodes
			if (currentLevel.isEmpty()) {

				temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;

				result.add(list);
				list = new ArrayList();
			}

		}

		return result;
	}
}
