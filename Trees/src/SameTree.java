public class SameTree {

	/**
	 * Complexity O(n)
	 * Recursively check if left and right subtrees are equal
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null) {
			return true;
		}

		if (p != null && q != null) {
			return (p.value == q.value && isSameTree(p.left, q.left) && isSameTree(
					p.right, q.right));
		}
		return false;
	}
}
