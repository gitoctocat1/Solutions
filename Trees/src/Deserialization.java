import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * 
 *Complexity O(n)
 *
 */
public class Deserialization {
	
	public static void main(String[] args) throws IOException {
		File file = new File("example.txt");
		FileReader reader = new FileReader(file);
	    final BufferedReader input = new BufferedReader(reader);
	    deserialize(null, input);
	}
   
	
	public static void deserialize(TreeNode root, final BufferedReader reader) throws IOException {
		
		int token = reader.read();
		
		if(token == '#'){
			return ;
		} else {
			//ASCII to integer conversion
			root = new TreeNode(token - '0');
			deserialize(root.left, reader);
			deserialize(root.right, reader);
		}	
	}
}
