public class BuySellStock {

	public static void main(String[] args) {

		int[] prices = { 10, 5, 4, 100, 30,300 };
		BuySellStock bss = new BuySellStock();
		System.out.println("Maximum profit " + bss.maxProfit(prices));
		
		System.out.println("Maximum profit with unlimited " + bss.maxProfitUnlimitedTransaction(prices));
	}

	/**
	 * Buy and sell stock with 1 transaction 
	 * Complexity O(n)
	 *  e.g {10,5,4,6} -->maxProfit = 6-4 = 2 
	 *  {10,5,4,100, 200} --> maxProfit = 200-4 = 196
	 */
	public int maxProfit(int[] prices) {

		int minimum = Integer.MAX_VALUE;

		int maxProfit = 0, profit = 0;
		
		if(prices == null ){
			return maxProfit;
		}

		for (int i = 0; i < prices.length; i++) {

			// find the stock with lowest price
			if (prices[i] < minimum) {
				minimum = prices[i];
			}

			// calculate the profit made for that day
			profit = prices[i] - minimum;

			//make sure we have reached end of array to know this is the best combination
			if (profit > maxProfit && i == prices.length - 1) {
				System.out.println("Best time to buy : " + minimum);
				System.out.println("Best time to sell: " + prices[i]);

			}

			// get the max of current profit and maxProfit so far
			maxProfit = Math.max(maxProfit, profit);

		}

		return maxProfit;
	}

	/**
	 * e.g { 10, 5, 4, 100, 30,300 } ==> maxProfit 366 (Buy : 4, Sell 100, Buy 30, Sell 300)
	 * @param prices
	 * @return
	 */
	 public int maxProfitUnlimitedTransaction(int[] prices) {
	        
		 int maxProfit = 0, profit = 0;
	        
	        if(prices == null || prices.length == 1){
	            return maxProfit;
	        }
	        
	        for(int i = 1 ; i < prices.length ; i++){
	            
	            profit = Math.max(0, prices[i] - prices[i-1]);
	            
	            if(profit > 0){
	            	System.out.println("Buy " +prices[i-1]);
	            	System.out.println("Sell "+prices[i]);
	            }
	            
	            maxProfit = maxProfit + profit;
	            
	        }
	        
	        return maxProfit;
	    
	    }
}
