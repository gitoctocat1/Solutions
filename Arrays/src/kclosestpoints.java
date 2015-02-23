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
     * @param p
     * @param k
     * @return
     */
	public List<Point> findKClosest(Point[] p, int k) {
		PriorityQueue<Point> pq = new PriorityQueue<Point>(10, new Comparator<Point>() {
					@Override
					public int compare(Point a, Point b) {
						return (b.x * b.x + b.y * b.y)
								- (a.x * a.x + a.y * a.y);
					}
				});

		for (int i = 0; i < p.length; i++) {
			
			//add first K elements to the heap
			if (i < k)
				pq.offer(p[i]);
			else {
				//once we exceed k, compare with the head of queue
				Point temp = pq.peek();
				//check if the current point is farther than the element at the head of queue
				if ((p[i].x * p[i].x + p[i].y * p[i].y)
						- (temp.x * temp.x + temp.y * temp.y) < 0) {
					//if yes, remove the element from priority queue
					pq.poll();
					//add the current point to the queue
					pq.offer(p[i]);
				}
			}
		}

		List<Point> result = new ArrayList<Point>();
		//loop through priority queue and add to result
		while (!pq.isEmpty())
			result.add(pq.poll());

		return result;
	}

	public static void main(String[] args) {
		kclosestpoints p = new kclosestpoints();

		Point p1 = new Point(5, 6);
		Point p2 = new Point(1, 2);
		Point p3 = new Point(3, 4);
		Point p4 = new Point(1, 1);
		Point[] points = new Point[4];
		points[0] = p1;
		points[1] = p2;
		points[2] = p3;
		points[3] = p4;
		List<Point> result = p.findKClosest(points, 3);

		for (int i = 0; i < result.size(); i++) {
			System.out.println("(" + result.get(i).x + "," + result.get(i).y
					+ ")");
		}
	}

}
