
public class MoveZeroes {
	
	public int[] moveZeroes(int[] array){
		
		int i = 0;
		
		for(int j = 0; j < array.length; j++){	
			while(array[j] == 0){
				j++;
			}
			array[i] = array[j];
			i++;
		}
		for(int x = i ; x < array.length ; x++){
			array[x] = 0;
		}
		return array;
		
	}

}
