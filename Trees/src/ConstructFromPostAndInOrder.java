import java.util.HashMap;
import java.util.Map;


public class ConstructFromPostAndInOrder {
	
	Map<Integer, Integer> lookUpInOrderIndex = new HashMap<Integer, Integer>();

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// Build a lookup map to get index of any node in the inorder array
		for (int i = 0; i < inorder.length; i++) {
			lookUpInOrderIndex.put(Integer.valueOf(inorder[i]),
			        Integer.valueOf(i));
		}

		return buildTreeUtil(inorder, 0, inorder.length - 1, postorder, 0,
		        postorder.length - 1);
	}

	public TreeNode buildTreeUtil(int[] inorder, int inStart, int inEnd,
	        int[] postorder, int postStart, int postEnd) {

		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}

		// Root is always at the end of postorder array
		int rootValue = postorder[postEnd];
		
		// Get the index of root in inorder array
		int rootIndex = lookUpInOrderIndex.get(Integer.valueOf(rootValue));
		
		// get the num of nodes in the left sub tree, use this calc start and
		// end index of next recursion
		int lenOfLeftSubtree = rootIndex - inStart;

		TreeNode root = new TreeNode(rootValue);

		/*
		 * For Left subtree
		 * Inorder new indices
		 *  start index is same 
		 *  End index is one left to the root
		 * 
		 * Postorder new indices 
		 * 	start is same 
		 * 	end will be postStart +
		 * lenOfLeftSubtree - 1 because we know there are lenOfLeftSubtree nodes
		 * in the left subtree and in the postorder array we must have these at
		 * the left most end
		 */
		root.left = buildTreeUtil(inorder, inStart, rootIndex - 1, postorder,
		        postStart, postStart + lenOfLeftSubtree - 1);

		/*
		 * For Right subtree
		 * Inorder new indices
		 *  start index one to the right of root 
		 *  End index is same
		 * 
		 * Postorder new indices 
		 * 	start is next element to the left subtree's end 
		 * 	aka postStart + lenOfLeftSubtree - 1 + 1  
		 * 	end is old end - 1 because we used last element as root 	
		 */
		root.right = buildTreeUtil(inorder, rootIndex + 1, inEnd, postorder,
		        postStart + lenOfLeftSubtree, postEnd - 1);

		return root;
	}


}

