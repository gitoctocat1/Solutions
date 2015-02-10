import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

	/**
	 * Complexity O(n lg n) because the intervals are sorted
	 */
	public List<Interval> merge(List<Interval> intervals) {

		List<Interval> result = new ArrayList<Interval>();

		if (intervals == null || intervals.isEmpty()) {
			return result;
		}

		if (intervals.size() == 1) {
			return intervals;
		}

		// sort the intervals
		Collections.sort(intervals, new IntervalComparator());

		Interval prevInterval = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {

			Interval currentInterval = intervals.get(i);

			if (prevInterval.end >= currentInterval.start) {
				// merge intervals
				//if prevInterval.end >= currInterval.start
				Interval mergedInterval = new Interval(Math.min(
						prevInterval.start, currentInterval.start), Math.max(
						prevInterval.end, currentInterval.end));
				prevInterval = mergedInterval;

			} else {

				result.add(prevInterval);
				prevInterval = currentInterval;
			}

		}

		result.add(prevInterval);

		return result;
	}

}
/**
 * Comparator class to sort the intervals
 *
 */
class IntervalComparator implements Comparator<Interval> {

	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
}

/**
 * Interval class 
 *
 */
class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}