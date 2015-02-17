package Exercise;

import java.util.Arrays;
import java.util.List;

/**
 * return the shortest index distance of word 1 and word 2 in a list
 * @author cuiyang36
 *
 */
public class WordListDistance {
	
	public static int wordListDistance(List<String> input, String a, String b){
		if (input == null || input.size() < 1){
			return Integer.MAX_VALUE;
		}
		int a1 = -1;
		int b1 = -1;
		for (int i = 0; i < input.size(); i++){
			if (a.equals(input.get(i))){
				a1 = i;
			}
			if (b.equals(input.get(i))){
				b1 = i;
			}
		}
		if (a1 == -1 || b1 == -1){
			return Integer.MAX_VALUE;
		}
		return Math.abs(a1 - b1);
	}
	
	public static void main(String[] args){
		String[] array = new String[]{"the", "quick", "brown", "fox", "quick"};
		List<String> input = Arrays.asList(array);
		int result = wordListDistance(input, "quick", "fox");
		System.out.println(result);
	}

}
