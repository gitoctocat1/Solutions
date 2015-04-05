import java.util.ArrayList;
import java.util.List;

public class PrintPaths {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);

		root.left = new TreeNode(3);

		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);

		root.right = new TreeNode(8);
		root.right.left = new TreeNode(7);

		root.right.right = new TreeNode(16);

		root.right.right.left = new TreeNode(9);

		PrintPaths ps = new PrintPaths();
		ps.printPaths(root);
	}

	/*
	 * Complexity O(n)
	 * Given a binary tree, print out all of its root-to-leaf paths, one per
	 * line. Uses a recursive helper to do the work.
	 */
	void printPaths(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		List<Integer> currentPath = new ArrayList<Integer>();

		printPaths(root, currentPath, result);
	}

	/*
	 * Recursive helper function -- given a node, and an array containing the
	 * path from the root node up to but not including this node, print out all
	 * the root-leaf paths.
	 */
	void printPaths(TreeNode root, List<Integer> currentPath,
			List<List<Integer>> result) {
		if (root == null)
			return;

		/* append this node to the path array */
		currentPath.add(root.value);

		/* it's a leaf, so print the path that led to here */
		if (root.left == null && root.right == null) {
			result.add(currentPath);
			printArray(currentPath);
		} else {
			/* otherwise try both subtrees */
			printPaths(root.left, currentPath, result);
			printPaths(root.right, currentPath, result);
		}

		//remove last element
		currentPath.remove(currentPath.size() - 1);
	}

	/* Utility that prints out an arraylist on a line. */
	void printArray(List<Integer> path) {
		int i;
		for (i = 0; i < path.size(); i++) {
			System.out.print(path.get(i)+" ");
		}
		System.out.println("\n");
	}

}
