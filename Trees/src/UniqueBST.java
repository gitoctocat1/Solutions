
public class UniqueBST {
	 //complexity : O(n^2)
    public int numTrees(int n) {
         if(n==0) return 1;
        if(n==1) return 1;
        int res = 0;
        for(int i=1;i<=n;i++){
            //if i is root, i-1 elements form left subtree and i+1 form right subtree
            int left = numTrees(i-1);
            int right = numTrees(n-i);
            res += left*right;
        }
        return res;
    }
}
