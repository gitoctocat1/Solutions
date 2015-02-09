import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class ZigZagLevelOrderTraversal {

	public static void main(String[] args) {
		
		TreeNode n = new TreeNode(1);
		n.left = new TreeNode(2);
		n.right = new TreeNode(3);
		
		n.left.left = new TreeNode(4);
		n.right.right = new TreeNode(5);
		ZigZagLevelOrderTraversal.zigZagTwo(n);
	}
	
	/**
	 * Using Dequeue INCOMPLETE!!
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> zigZagTwo(TreeNode root) {

		List<List<Integer>> result = new LinkedList<List<Integer>>();

		// use a queue to keep track of nodes
		Deque<TreeNode> queue = new LinkedList<TreeNode>();

		// holds the nodes in each level
		List<Integer> list = new ArrayList<Integer>();

		int nodesInCurrentLevel = 1;

		int nodesInNextLevel = 0;

		boolean reverse = true;

		if (root == null) {
			return result;
		}

		queue.addFirst(root);

		TreeNode node = null;

		while (!queue.isEmpty()) {

			node = reverse ? queue.removeFirst() : queue.removeLast();
			nodesInCurrentLevel--;

			if (node != null) {
				list.add(node.value);

				// check for empty nodes
				if (node.left != null) {
					if (reverse) {
						queue.addLast(node.left);
					} else {
						queue.addFirst(node.left);
					}
					nodesInNextLevel++;
				}

				if (node.right != null) {
					if (reverse) {
						queue.addLast(node.right);
					} else {
						queue.addFirst(node.right);
					}
					nodesInNextLevel++;
				}
			}

			// once we finished processing all nodes in current level, reset the
			// count and clear the list
			if (nodesInCurrentLevel == 0) {
				nodesInCurrentLevel = nodesInNextLevel;
				nodesInNextLevel = 0;

				reverse = !reverse;

				result.add(list);
				// clear the list
				list = new ArrayList();
			}

		}

		return result;

	}
	 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		 List<List<Integer>> result = new LinkedList<List<Integer>>();

			//use a queue to keep track of nodes
			List<TreeNode> queue = new LinkedList<TreeNode>();

			//holds the nodes in each level
			List<Integer> list = new ArrayList<Integer>();

			int nodesInCurrentLevel = 1;

			int nodesInNextLevel = 0;
			
			boolean reverse = false;

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
			
					//check the flag
					if(reverse){
						//does this in linear time
						Collections.reverse(list);
						reverse = false;
					}else {
						reverse = true;
					}
					
					result.add(list);
					//clear the list
					list = new ArrayList();
				}

			}

			return result;
	        
	 }

}
