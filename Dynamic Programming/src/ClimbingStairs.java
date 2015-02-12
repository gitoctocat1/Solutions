
public class ClimbingStairs {
	
	/**
	 * Complexity O(n)
	 * @param n
	 * @return
	 */
    public int climbStairs(int n) {
        
    	//one stair only
        if(n==1){
            return 1;
        }
        
        //two stairs
        if(n==2){
            return 2;
        }
      
        
        int onePrev =2; int twoPrev = 1; 
        
        int current = 0;
        
        //start the loop index from 3
        for(int i = 3; i<= n ; i++){
            
            current = onePrev + twoPrev;
            
            twoPrev = onePrev;
            onePrev = current;
           
        }
        
        return current;
    }

}
