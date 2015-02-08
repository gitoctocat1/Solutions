import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Complexity O(n)
 * Tree
 *       3
 *     /   \
 *    2     4
 *   /
 *  1  
 */


//As we go down the tree, check the previously visited node. If it is the parent of the current node,
//we should add current node to stack. 
//When there is no children for current node, pop it from stack. 
//Then the previous node become to be under the current node for next loop.
public class PostOrderTraversal {
	
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        if(root==null){
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        stack.push(root);
        
        TreeNode prev = null;
        
        while(!stack.isEmpty()){
            
        	//see what is at the top of the stack
            TreeNode curr = stack.peek();
            
            //Case 1: go down the tree and current node is a leaf
            if(prev == null || prev.left == curr || prev.right == curr){
                
                if(curr.left!=null){
                    stack.push(curr.left);
                    
                } else if(curr.right!=null){
                    stack.push(curr.right);
                } else {
                    result.add(stack.pop().value);
                }
            }
            
            //Case 2 : go up tree from left node
            else if(curr.left == prev){
                
                if(curr.right!=null){
                    stack.push(curr.right);
                } else {
                     result.add(stack.pop().value);
                }
            }
            
            //case 3 : go up tree from right node
            else if (curr.right == prev){
                result.add(stack.pop().value);
            }
            
            prev = curr;
        }
        
        return result;
    }

}
