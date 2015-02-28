import java.util.HashMap;
import java.util.TreeMap;


public class VerticalSum {
	
	
	public static void main(String[] args) {
		
		//      1
		//     / \
		//    2   3
		//   /   / \
		//  4    4   5
		
		TreeNode n = new TreeNode(1);
		n.left = new TreeNode(2);
		n.right = new TreeNode(3);
		
		n.left.left = new TreeNode(4);
		n.right.right = new TreeNode(5);
		n.right.left = new TreeNode(4);
		
		VerticalSum vs = new VerticalSum();
		vs.getVerticalSum(n);
	}
	
	private void getVerticalSum(TreeNode root) {
		  
        // base case
        if (root == null) { return; }
  
        // Creates an empty hashMap hM
        TreeMap<Integer, Integer> hM = new TreeMap<Integer, Integer>();
  
        // Calls the VerticalSumUtil() to store the vertical sum values in hM
        VerticalSumUtil(root, 0, hM);
  
        // Prints the values stored by VerticalSumUtil()
        if (hM != null) {
        	
        	TreeMap<Integer, Integer> treeMap = new TreeMap<Integer,Integer>(hM);
            System.out.println(treeMap.values());
        }
    }
  
    // Traverses the tree in Inoorder form and builds a hashMap hM that
    // contains the vertical sum
    private void VerticalSumUtil(TreeNode root, int hD,
    		TreeMap<Integer, Integer> hM) {
  
        // base case
        if (root == null) {  return; }
  
        // Store the values in hM for left subtree
        VerticalSumUtil(root.left, hD - 1, hM);
  
        // Update vertical sum for hD of this node
        int prevSum = (hM.get(hD) == null) ? 0 : hM.get(hD);
        hM.put(hD, prevSum + root.value);
  
        // Store the values in hM for right subtree
        VerticalSumUtil(root.right, hD + 1, hM);
    }

}
