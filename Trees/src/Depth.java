
/**
 * Complexity O(n)
 *
 */
public class Depth {
	 public int maxDepth(TreeNode root) {
	        
	        if(root == null){
	            return 0;
	        }
	        
	        int l = maxDepth(root.left);
	        int r = maxDepth(root.right);
	        
	        if (l==0 && r==0){
	            return 1;
	        }
	        
	        return Math.max (l,r)+1;
	        
	    }
	 
	 
	 public int minDepth(TreeNode root) {
	        //empty tree
	        if(root ==null){
	            return 0;
	        }
	        
	            
	          int l = minDepth(root.left);
	          int r = minDepth(root.right);
	          
	          if( l==0 || r ==0){
	              return Math.max(l,r) +1;
	          }
	          return Math.min(l,r)+1;
	          
	        
	        
	    }
}
