public class Symmetric {

	/**
	 * Complexity :O(n) Two trees are symmetric if left subtree of tree1 = right
	 * subtree of tree2 Return true if both subtrees are empty Return false if
	 * one of subtree is empty
	 */

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null)
			return true;
		if (root.left == null || root.right == null)
			return false;

		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(TreeNode a, TreeNode b) {

		if (a == null && b == null) {
			return true;
			
		} else if (a == null || b == null) {
			return false;
		}

		boolean isLeftSymmetric = isSymmetric(a.left, b.right);

		boolean isRightSymmetric = isSymmetric(a.right, b.left);

		return (a.value == b.value && isLeftSymmetric && isRightSymmetric);
	}

}
