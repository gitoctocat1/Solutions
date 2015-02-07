
public class BalancedBinaryTree {

	
	// Bottom up approach;
	//Each node in the tree only need to be accessed once. Thus the time complexity is O(N)
		public boolean isBalanced(TreeNode root) {
			if (root == null)
				return true;
	 
			if (getHeight(root) == -1)
				return false;
	 
			return true;
		}
	 
		public int getHeight(TreeNode root) {
			if (root == null)
				return 0;
	 
			int left = getHeight(root.left);
			int right = getHeight(root.right);
	 
			//if any of the subtrees break the balanced tree property , return -1
			if (left == -1 || right == -1)
				return -1;
	 
			//difference between height of left and right subtrees shouldnt be > 1
			if (Math.abs(left - right) > 1) {
				return -1;
			}
	 
			return Math.max(left, right) + 1;
	 
		}
}
