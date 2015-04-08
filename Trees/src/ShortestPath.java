import java.util.List;
import java.util.Stack;


public class ShortestPath {
	public static <V> void shortestpath(
	        TreeNode root, TreeNode a, TreeNode b, 
	        Stack<TreeNode> outputPath) {
	    if (root == null) {
	        return;
	    }
	    if ((root.value == a.value) || (root.value ==b.value)) {
	        outputPath.push(root);
	        return;
	    }
	    
	    shortestpath(root.left, a, b, outputPath);
	    shortestpath(root.right, a, b, outputPath);
	    
	    outputPath.push(root);
	}
	 
	public static List<TreeNode> shortestPath(TreeNode root, TreeNode a, TreeNode b) {
		
	    Stack<TreeNode> path1 = new Stack<TreeNode>();
	    Stack<TreeNode> path2 = new Stack<TreeNode>();
	    
	    
	    		LCA lc = new LCA();
	    		TreeNode lca = lc.LCA(root, a, b);
	    
	    // This is to handle the case where one of the nodes IS the LCA
	    TreeNode r = lca.equals(a) ? a : (lca.equals(b) ? b : lca);
	    
	    shortestpath(r.left, a, b, path1);
	    shortestpath(r.right, a, b, path2);
	    
	    path1.push(r);
	    // invert the second path
	    while (!path2.isEmpty()) {
	        path1.push(path2.pop());
	    }
	    return path1;
	}

}
