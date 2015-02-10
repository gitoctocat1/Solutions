import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	/**
	 * Complexity O(n) if intervals are sorted based on start times
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		List<Interval> result = new ArrayList<Interval>();

		if (intervals == null || intervals.isEmpty()) {
			result.add(newInterval);
			return result;
		}

		for (Interval interval : intervals) {

			// Case 1 : newInterval to the right
			if (interval.end < newInterval.start) {
				result.add(interval);

			}

			// Case 2 : newInterval to the left
			else if (newInterval.end < interval.start) {
				result.add(newInterval);

				// current interval becomes new interval
				newInterval = interval;
			}

			// Case 3 : there is overlap, so merge
			else if (interval.end >= newInterval.start) {

				newInterval = new Interval(Math.min(interval.start,
						newInterval.start), Math.max(interval.end,
						newInterval.end));
				// result.add(newInterval);
			}

		}

		result.add(newInterval);

		return result;
	}

}
