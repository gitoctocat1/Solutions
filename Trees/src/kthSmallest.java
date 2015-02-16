import javax.print.attribute.standard.Finishings;


/**
	 * Modified tree node to store size of left subtree
	 *
	 */
	class Node{
		int val;
		Node left;
		Node right;
		//store the size of left subtree
		int lsize;
		
		Node(int x){
			val = x;
			lsize = 0;
		}
	}

public class kthSmallest {
	
	
	
	public static void main(String[] args) {
		Node root = new Node(6);
		root.lsize = 3;
		root.left = new Node(3);
		root.left.lsize = 1;
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		
		root.right = new Node(8);
		root.right.left = new Node(7);
		root.right.lsize = 1;
		root.right.right = new Node(16);
		root.right.right.lsize = 1;
		root.right.right.left = new Node(9);
		
		
		System.out.println(findKth(3, root));
	}
	
	/**
	 * Complexity O(lg n ) if height balanced
	 * @param k
	 * @param node
	 * @return
	 * 
	 * 
	 *        6
	 *       / \
	 *      3    8
	 *     / \  / \
	 *    2  4 7  16
	 *            /
	 *           9 
	 */
	 public static int findKth( int k, Node node )
	    {
		 
		    int result = -1;
	        if( node == null )
	           return result;
	       
	        //kth smallest is in left subtree
	        if( k <= node.lsize )
	            return findKth( k, node.left );
	        
	        //if root is kth smallest
	        if( k == node.lsize + 1 )
	            return node.val;
	        
	        //kth smallest is in right subtree
	        return findKth( k - node.lsize - 1, node.right );
	    }
	    
	
	

}
