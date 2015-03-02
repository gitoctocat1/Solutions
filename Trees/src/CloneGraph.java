import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class CloneGraph {

	/**
	 * Complexity O(n)
	 * 
	 * Check for cycle
	 * As we copy a node, we insert it into the table. If we later find that one of a node’s neighbor is already in the table, we do not make a copy of that neighbor,
	 *  but to push its neighbor’s copy to its copy instead.
	 *  Therefore, the hash table would need to store a mapping of key-value pairs, where the key is a node in the original graph and its value is the node’s copy.
	 * @param root
	 * @return
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {

		if (root == null) {
			return root;
		}

		List<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		
		//add root to the queue
		queue.add(root);

		HashMap<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		
		UndirectedGraphNode rootCopy = new UndirectedGraphNode(root.label);
		//for every node we add to the queue, we add a copy of the node to hashmap
		visited.put(root, rootCopy);

		// BFS
		while (!queue.isEmpty()) {
			root = queue.remove(0);
			UndirectedGraphNode rc = visited.get(root);
			
			for (UndirectedGraphNode neighbor : root.neighbors) {
				//check if the neighbor has been visited 
				if (visited.containsKey(neighbor)) {
					rc.neighbors.add(visited.get(neighbor));
				} else {
					
					//if neighbor has not been visited, make a copy and add to map. Add the neighbor itself to the queue
					UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
					rc.neighbors.add(neighborCopy);
					visited.put(neighbor, neighborCopy);
					queue.add(neighbor);
				}
			}
		}

		return rootCopy;

	}
}
