
public class pow {
	
	
	public static void main(String[] args) {
		
		System.out.println(Math.pow(3.0, Integer.MIN_VALUE));
		System.out.println(pow(1.0, Integer.MIN_VALUE));
	}
	
	 //Complexity O(lg n)
    public static double pow(double x, int n) {
        
     //if n is negative    
      if (n < 0) {
		return 1 / power(x, -n);
	} else {
		return power(x, n);
	}
        
    }
    
    
    public static double power(double x, int n) {
	if (n == 0)
		return 1;
 
    // storing this result 
	double v = power(x, n / 2);
 
	if (n % 2 == 0) {
		return v * v;
	} else {
		return v * v * x;
	}
}
}
