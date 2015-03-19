package Leetcode;

/**
 * sort color, Object version
 * Whenever a.equals(b), then a.hashCode() must be same as b.hashCode().
 * @author cuiyang36
 *
 */
public class SortColor {
	
	public static class Color{
		public int number;
		public Color(int number){
			this.number = number;
		}
		
		public boolean equals(Color o){
			
			return number == o.number;
		}
	}

	public static void sortColor(Color[] array){
		if (array == null || array.length < 1){
			return;
		}
		int left = 0, right = array.length - 1, traverse = 0;
		while (traverse <= right){
			if (array[traverse].number == 2){
				traverse += 1;
			}else if (array[traverse].number == 1){
				swap(array, left++, traverse++);
			}else{
				swap(array, right--, traverse);
			}
		}
	}
	
	private static void swap(Color[] array, int i, int j){
		Color tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
