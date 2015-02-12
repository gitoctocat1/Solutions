import java.util.HashMap;
import java.util.Map;


public class ConstructFromPreOrderInorder {

	
	 /*
	 
    1
   / \
  2   3
 /   /
4   5

inorder   = 4 2 1 5 3
preorder  = 1 2 4 3 5

Refer to https://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/ 
for complete explanation
*/

	Map<Integer, Integer> lookUpInOrderIndex = new HashMap<Integer, Integer>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			lookUpInOrderIndex.put(Integer.valueOf(inorder[i]),
					Integer.valueOf(i));
		}

		return buildTreeUtil(inorder, 0, inorder.length - 1, preorder, 0,
				preorder.length - 1);

	}

	public TreeNode buildTreeUtil(int[] inorder, int inStart, int inEnd,
			int[] preorder, int preStart, int preEnd) {
		if (inStart > inEnd || preStart > preEnd) {
			return null;
		}

		int rootValue = preorder[preStart];
		int rootIndex = lookUpInOrderIndex.get(Integer.valueOf(rootValue));
		int lenOfLeftSubTree = rootIndex - inStart;

		TreeNode root = new TreeNode(rootValue);
		root.left = buildTreeUtil(inorder, inStart, rootIndex - 1, preorder,
				preStart + 1, preStart + lenOfLeftSubTree);
		root.right = buildTreeUtil(inorder, rootIndex + 1, inEnd, preorder,
				preStart + lenOfLeftSubTree + 1, preEnd);

		return root;
	}
}

