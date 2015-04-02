import java.util.List;




public class IntervalCoverage {
	
	/**
	 * Complexity O(n) if intervals are altready sorted
	 * else O(n lg n)
	 * @param intervals
	 * @return
	 */
	public int getIntervalCoverage (List<Interval> intervals){
		
		int result = 0;
		
		Interval prev = intervals.get(0);
		
		for (int i = 1 ; i< intervals.size(); i++){
			
			Interval current = intervals.get(i);
			
			//merge interval
			if (prev.end >= current.start){
				
				Interval mergedInterval = new Interval (prev.start, Math.max(prev.end,current.end));
				
				prev = mergedInterval;
				
			} else {
				
				result += (prev.end - prev.start);
				
				prev = current;
			}
		}
		
		result += (prev.end - prev.start);
		
		return result;
	}

}
