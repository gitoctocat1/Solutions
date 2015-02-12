
public class LCAParentPointer {

	/**
	 * Get the distance (height) of both nodes from the root
	 * @param node
	 * @return
	 */
	public int getHeight(TreeNodeWithParent node) {
	    int height = 0;
	    while (node != null) {
	        node = node.parent;
	        height++;
	    }
	    return height;
	}
	
	/**
	 * Complexity O(lg n) balanced tree
	 * Otherwise O(n)
	 * Find LCA 
	 * @param a
	 * @param b
	 * @return
	 */
	public TreeNodeWithParent LCA(TreeNodeWithParent a, TreeNodeWithParent b) {
	    if (a ==null || b==null)
	        return null;
	 
	    int height1 = getHeight(a);
	    int height2 = getHeight(b);
	 
	    // invariant: h1 <= h2.
	    int dh = Math.abs(height2 - height1);
		if (height2 > height1) {
			//if node b is deeper, bring it to the same level as node a
			for (int h = 0; h < dh; h++) {
				b = b.parent;
			}

		} else {
			//if node a is deeper, bring it to the same level as node b
			for (int h = 0; h < dh; h++) {
				a = a.parent;
			}
		}

		//if LCA exists, node a = node b 
	    while (a != null && b!=null) {
	        if (a == b)
	            return a;
	        a = a.parent;
	        b = b.parent;
	    }
	 
	    return null;
	}

}


class TreeNodeWithParent {

	int value;
	TreeNode left;
	TreeNode right;
	TreeNodeWithParent parent;
	
	TreeNodeWithParent(int x){
		value = x;
		
	}
}
