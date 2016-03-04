
public class CompactSpaces {
	
	
	public String compactSpaces(String s){
		
		s = s.trim();
		
		char[] array = s.toCharArray();
		int i =0;
		
		for(int j = 0; j < array.length; j++){
			
			if(array[j]!= ' ' ){
				array[i] = array[j];
				
			} else {
				array[i] = array[j];

				while(array[j+1] == ' '){
					j++;
				}
			}
			
			i++;
		}
		String result = String.valueOf(array).substring(0, i);
		return result ;
	}

}
