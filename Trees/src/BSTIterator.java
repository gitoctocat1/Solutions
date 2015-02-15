import java.util.Stack;

/**
 * Idea is to do in-order traversal using stack
 * average O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 */
public class BSTIterator {


    Stack<TreeNode> stack ;
    
    TreeNode current = null;

    public BSTIterator(TreeNode root) {
        stack =  new Stack<TreeNode>();
        current = root;
        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        
        //Return true if 1) stack is not empty 2) tree has only one element i.,e root
        if(!stack.isEmpty() || current!= null){
            return true;
        } else {
            return false;
        }
    }

    /** @return the next smallest number */
    public int next() {
        
         //keep pushing left most nodes
         while (current != null) {
                stack.push(current);
                current = current.left ;
          } 
          
          //after pushing all leftmost nodes, pop from stack
            TreeNode t = stack.pop() ;      
            //adjust the pointer to point to right child NOTE: right child's left child 
            //could be next smallest
            //      5
            //     / \
            //    2    6
            //  /   \
            // 1     4
            //      /
            //     3
            current = t.right ;     
            return t.value ;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
