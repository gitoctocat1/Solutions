import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Serialization {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("example.txt");
		FileWriter writer = new FileWriter(file);
	    final BufferedWriter output = new BufferedWriter(writer);
	    
	    //Example 1
        TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.right = new TreeNode(4);
		
		
		//Example 2
		 TreeNode node = new TreeNode(3);
			node.left = new TreeNode(2);
			node.left.left = new TreeNode(1);
			node.right = new TreeNode(4);
			node.right.right = new TreeNode(5);
	    
	    serialize(node, output);
		
	}

	/**
	 * Complexity O(n)
	 * Use "#" sentinel to identify null nodes during deserialization
	 * @param root
	 * @param writer
	 * @throws IOException
	 */
	public static void serialize(TreeNode root, final BufferedWriter writer) throws IOException {
		
		if(root == null){
			writer.write("#");
		} else {
			writer.write(String.valueOf(root.value));
			serialize(root.left, writer);
			serialize(root.right, writer);
		}
		
		writer.flush();
	}
}
