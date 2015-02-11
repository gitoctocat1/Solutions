

import java.util.*;

public class Triangle {
	
	/**
	 * [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		
		List<Integer> top = new ArrayList<Integer>();
		top.add(2);
		
		List<Integer> top1 = new ArrayList<Integer>();
		top1.add(3); top1.add(4);
		
		List<Integer> top2 = new ArrayList<Integer>();
		top2.add(6); top2.add(5); top2.add(7);
		
		List<Integer> top3 = new ArrayList<Integer>();
		top3.add(4); top3.add(1); top3.add(8); top3.add(3);
		
		triangle.add(top); triangle.add(top1); triangle.add(top2); triangle.add(top3);
		
		minimumTotal(triangle);
		
	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {
		int[] total = new int[triangle.size()];
		int l = triangle.size() - 1;
	 
		for (int i = 0; i < triangle.get(l).size(); i++) {
			total[i] = triangle.get(l).get(i);
		}
	 
		// iterate from last second row
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
				int tmp =triangle.get(i).get(j);
				
				total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
			}
		}
	 
		return total[0];
	}

}
