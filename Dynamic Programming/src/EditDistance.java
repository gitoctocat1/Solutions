
public class EditDistance {
	
/**
 * Complexity O(m*n)	 ; space complexity  (m*n)
 * @param word1
 * @param word2
 * @return
 */
public int minDistance(String word1, String word2) {
        
        int m = word1.length();
        int n = word2.length();
        
        int[][] d = new int[m+1][n+1];
        
        int temp, dist;
        
        //both strings are empty
        d[0][0] = 0;
        
        
        if(word1.isEmpty()){
            return n;
        }
        
        if(word2.isEmpty()){
            return m;
        }
        
        if(n == 0 && m ==0){
            return 0;
        }
        
        //initial state
        for (int i =1 ; i <= m ; i++){
            
            d[i][0] = i;
        }
        
         for(int j= 1; j <=n; j++){
             
              d[0][j] = j;
         }     
        
        for (int i =1 ; i <= m ; i++){
            
            for(int j= 1; j <=n; j++){
                
                //substitution or replace
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dist = 0 ; 
                } else {
                    dist = 1;
                }
                
                //insert or delete
                //insert d[i-1][j] + 1
                //delete d[i][j-1]+ 1
                
                temp = Math.min(d[i-1][j] + 1 , d[i][j-1]+ 1);
                
                //replace
                d[i][j] = Math.min (d[i-1][j-1]+dist, temp);
                
            }
        }
        
        return d[m][n];
        
    }

}
