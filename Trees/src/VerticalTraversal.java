
	import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
	

/**
 * Complexity O(n)
 *
 */
public class VerticalTraversal {

	


		
		
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
			
			VerticalTraversal vs = new VerticalTraversal();
			vs.printVerticalOrder(n);
		}
		
		
		
		// Utility function to store vertical order in map 'm'
		// 'hd' is horigontal distance of current node from root.
		// 'hd' is initally passed as 0
		void getVerticalOrder(TreeNode root, int hd, HashMap<Integer, List<Integer>> map){
		
		    // Base case
		    if (root == null)
		        return;
		 
		    // Store current node in map 'm'
		    
		    if(map.containsKey(hd)){
		    	List<Integer> list = map.get(hd);
		    	list.add(root.value);
		    	map.put(hd, list);
		    } else {
		    	List<Integer> l = new ArrayList<Integer>();
		    	l.add(root.value);
		        map.put(hd,l);
		    }
		 
		    // Store nodes in left subtree
		    getVerticalOrder(root.left, hd-1, map);
		 
		    // Store nodes in right subtree
		    getVerticalOrder(root.right, hd+1, map);
		}
		 
		// The main function to print vertical oder of a binary tree
		// with given root
		void printVerticalOrder(TreeNode root)
		{
		    // Create a map and store vertical oder in map using
		    // function getVerticalOrder()
			HashMap<Integer, List<Integer>> map = new HashMap<Integer,List<Integer>>();
		    int hd = 0;
		    getVerticalOrder(root, hd,map);
		 
		    // Traverse the map and print nodes at every horigontal
		    // distance (hd)
		    
		    TreeMap<Integer, List<Integer>> treeMap = new TreeMap<Integer,List<Integer>>(map);
            System.out.println(treeMap.values());
		   
		}

	

}
