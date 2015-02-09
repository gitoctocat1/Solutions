import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseLevelOrderTraversal {
	
	//Complexity O(n)
    // Same as level order traversal but change the order of insertion into the list	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		
		
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();

		//use a queue to keep track of nodes
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

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

			    // list.add() adds elements to the end of list. In this case, we
				// want to reverse
				result.addFirst(list);
				//clear the list
				list = new ArrayList();
			}

		}

		return result;
	}
}
