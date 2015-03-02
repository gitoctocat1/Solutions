import java.util.ArrayList;
import java.util.List;


public class Permutation {
	
	public static void main(String[] args) {

		int[] prices = { 1,2,3 };
		Permutation bss = new Permutation();
		bss.permute1(prices);
	} 

	
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		permute(num, 0, result);
		return result;
	}
	 
	void permute(int[] num, int start, List<List<Integer>> result) {
	 
		if (start >= num.length) {
			ArrayList<Integer> item = convertArrayToList(num);
			result.add(item);
		}
	 
		for (int j = start; j <= num.length - 1; j++) {
			swap(num, start, j);
			permute(num, start + 1, result);
			swap(num, start, j);
		}
	}
	 
	private ArrayList<Integer> convertArrayToList(int[] num) {
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < num.length; h++) {
			item.add(num[h]);
		}
		return item;
	}
	 
	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
	public List<List<Integer>> permute1(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
	 
		//start from an empty list
		result.add(new ArrayList<Integer>());
	 
		for (int i = 0; i < num.length; i++) {
			//list of list in current iteration of the array num
			List<List<Integer>> current = new ArrayList<List<Integer>>();
	 
			for (List<Integer> l : result) {
				// # of locations to insert is largest index + 1
				for (int j = 0; j < l.size()+1; j++) {
					// + add num[i] to different locations
					l.add(j, num[i]);
	 
					List<Integer> temp = new ArrayList<Integer>(l);
					current.add(temp);
					
					// - remove num[i] add
					l.remove(j);
				}
			}
	 
			result = new ArrayList<List<Integer>>(current);
		}
	 
		return result;
	}

}
