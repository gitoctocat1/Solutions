
public class kthLargest {

	static int index = 0;
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);

		root.right = new TreeNode(8);
		root.right.left = new TreeNode(7);

		root.right.right = new TreeNode(16);

		root.right.right.left = new TreeNode(9);
		
		getElement(root, 6);
	}
	
	public static void getElement(TreeNode root, int k){
        //Base condition
        if(root == null)
              return ;

        getElement(root.right, k);   //first traverse the right sub tree
        if(++index == k){
        	System.out.println(root.value);
                return ;
               
        }  
          getElement(root.left, k);
}
	
	
	/**
	 * Complexity O(height of tree)
	 * @param root
	 * @param k
	 * @return
	 */
	public static int getKthLargest(Node root, int k){
		
		if(root == null){
			return -1;
		}
		
		if(root.rsize <= k){
			return getKthLargest(root.right, k);
		}
		
		if(root.rsize +1 ==k){
			return root.value;
		}
		
		return getKthLargest(root.left, k-1-root.rsize);
		
	}
	
	class Node {
		int value;
		Node left;
		Node right;
		// store the size of right subtree
		int rsize;

		Node(int x) {
			value = x;
			rsize = 0;
		}
	}
}
