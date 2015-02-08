public class SortedArrayToBST {
	
    /**
     * Complexity O(n)
     * Similar to binary search. Recursively build left and right subtrees
     * Since array is sorted for every ith element, i-1 elements form left subtree and i+1 form right
     * subtree
     * @param num
     * @return
     */
	public TreeNode sortedArrayToBST(int[] num) {

		if (num.length == 0) {
			return null;
		}

		return sortedArrayToBST(num, 0, num.length - 1);
	}

	public TreeNode sortedArrayToBST(int[] num, int start, int end) {

		if (start > end) {
			return null;
		}

		else {

			int mid = (end + ((start - end) / 2));

			TreeNode root = new TreeNode(num[mid]);

			//build left subtree
			root.left = sortedArrayToBST(num, start, mid - 1);

			//build right subtree
			root.right = sortedArrayToBST(num, mid + 1, end);

			return root;
		}
	}
}
