
public class sqrt {
	
	public static void main(String[] args) {
		sqrt s = new sqrt();
		s.sqrt(8);
	}
	
	/**
	 * Complexity O (lg n)
	 * @param x
	 * @return
	 */
	 public int sqrt(int x) {
	        
	        if(x==0 || x ==1){
	            return x ==0 ? 0 : 1;
	        }
	      
	      
	       long i = 1; 
	       long j = x/2  ;
	    
	       while ( i <= j){
	           long mid = j + (i - j)/2 ;
	           
	           if(mid * mid == x){
	               return (int)mid;
	               
	           } else if ( mid * mid < x) {
	               i = mid + 1 ;
	           } else {
	               j = mid - 1;
	           }
	           
	           
	       }
	        
	        return (int)j;
	    }

}
