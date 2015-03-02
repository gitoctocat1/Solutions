import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Point {
	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class kclosestpoints {
	
	
    /**
     * Complexity O(n log n)  - worst case k is large and we add/insert every element to priority queue N * logn
     * This happens if the points are reverse sorted by distance from origin
     * @param p
     * @param k
     * @return
     */
	public List<Point> findKClosest(Point[] p, int k) {
		
		List<Point> result = new ArrayList<Point>();
		
		if(k == 0 || p == null || p.length == 0){
			return result;
		}
		Comparator<Point> c = new Comparator<Point>() {
			@Override
			public int compare(Point a, Point b) {
				return (b.x * b.x + b.y * b.y)
						- (a.x * a.x + a.y * a.y);
			}
		};

		PriorityQueue<Point> pq = new PriorityQueue<Point>(k, c);

		for (int i = 0; i < p.length; i++) {
			
			//add first K elements to the heap
			if (i < k)
				pq.offer(p[i]);
			else {
				//once we exceed k, compare with the head of queue
				Point head = pq.peek();
				//check if the current point is farther than the element at the head of queue
				if (c.compare(p[i], head) > 0) {
					//if yes, remove the element from priority queue
					pq.poll();
					//add the current point to the queue
					pq.offer(p[i]);
				}
				
			}
		}

		
		//loop through priority queue and add to result
		while (!pq.isEmpty())
			result.add(pq.poll());

		return result;
	}
	
	
	public List<Point> kClosestToGivenPoint(Point[] points, final Point p, int k) {

		List<Point> result = new ArrayList<Point>();

		if (k == 0 || p == null || points == null || points.length == 0) {
			return result;
		}
		Comparator<Point> c = new Comparator<Point>() {
			@Override
			public int compare(Point a, Point b) {
				int d1 = (a.x - p.x) * (a.x - p.x) + (a.y - p.y) * (a.y - p.y);
				int d2 = (b.x - p.x) * (b.x - p.x) + (b.y - p.y) * (b.y - p.y);
				return d2 - d1;
			}
		};

		PriorityQueue<Point> pq = new PriorityQueue<Point>(k, c);

		for (int i = 0; i < points.length; i++) {

			if (i < k) {
				pq.add(points[i]);
			} else {

				Point head = pq.peek();
				// check if the current point is farther than the element at the
				// head of queue
				if (c.compare(points[i], head) > 0) {
					// if yes, remove the element from priority queue
					pq.poll();
					// add the current point to the queue
					pq.offer(points[i]);

				}
			}
		}
		// loop through priority queue and add to result
		while (!pq.isEmpty())
			result.add(pq.poll());

		return result;
	}

	public static void main(String[] args) {
		kclosestpoints p = new kclosestpoints();

		Point p1 = new Point(5, 6);
		Point p2 = new Point(1, 2);
		Point p3 = new Point(3, 4);
		//Point p4 = new Point(1, 1);
		Point[] points = new Point[3];
		points[0] = p1;
		points[1] = p2;
		points[2] = p3;
		//points[3] = p4;
		
		
	//	List<Point> result = p.findKClosest(points, 3);
		
		Point pp = new Point(1,1);
		List<Point> result = p.kClosestToGivenPoint(points,pp, 2);

		for (int i = 0; i < result.size(); i++) {
			System.out.println("(" + result.get(i).x + "," + result.get(i).y
					+ ")");
		}
	}

}
