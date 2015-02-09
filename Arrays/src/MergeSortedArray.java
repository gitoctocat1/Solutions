
public class MergeSortedArray {
	
	//Complexity O (m + n)
	public void merge(int A[], int m, int B[], int n) {
		 
        while(m > 0 && n > 0){
        	//check if last element of A is greater than B
            if(A[m-1] > B[n-1]){
                A[m+n-1] = A[m-1];
                m--;
            }else{
                A[m+n-1] = B[n-1];
                n--;
            }
        }
 
        //If B has elements in it, append them to end of A
        while(n > 0){
            A[m+n-1] = B[n-1];
            n--;
        }
    }
}
