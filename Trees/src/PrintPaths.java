public class PrintPaths {

	/*
	 * Given a binary tree, print out all of its root-to-leaf paths, one per
	 * line. Uses a recursive helper to do the work.
	 */
	void printPaths(TreeNode node) {
		int[] path = null;
		printPaths(node, path, 0);
	}

	/*
	 * Recursive helper function -- given a node, and an array containing the
	 * path from the root node up to but not including this node, print out all
	 * the root-leaf paths.
	 */
	void printPaths(TreeNode node, int[] path, int pathLen) {
		if (node == null)
			return;

		/* append this node to the path array */
		path[pathLen] = node.value;
		pathLen++;

		/* it's a leaf, so print the path that led to here */
		if (node.left == null && node.right == null) {
			printArray(path, pathLen);
		} else {
			/* otherwise try both subtrees */
			printPaths(node.left, path, pathLen);
			printPaths(node.right, path, pathLen);
		}
	}

	/* Utility that prints out an array on a line. */
	void printArray(int[] path, int len) {
		int i;
		for (i = 0; i < len; i++) {
			System.out.println(path[i]);
		}
		System.out.println("\n");
	}

}
