

/**
 * Complexity O(n)
 * 
 * 1) Declare a class variable and initialize to smallest value Integer.MIN_VALUE
 * 2) Recursively calculate the left and right subtree sum and compare with max sum so far. If it is greater, update maximum sum
 * 
 */
public class MaxPathSum {
    
    public int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        
        if(root==null){
            return 0;
        }
        
        getMaxSum (root);
        return maxSum;
    }
    
    public int getMaxSum(TreeNode root){
        
        if(root == null){
            return 0;
        }
        
        //get the sum in left subtree; Math.max is needed if root.left is null
        int leftSum = Math.max(getMaxSum (root.left),0);
        int rightSum = Math.max(getMaxSum (root.right),0);
        
        
        //update the maximum sum
        if(root.value + leftSum +rightSum > maxSum){
            maxSum = root.value + leftSum +rightSum;
        }
        
        //return max sum for the current node
        return Math.max(leftSum, rightSum)+ root.value ;
        
    }
}


