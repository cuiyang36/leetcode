package Leetcode;

/**
 * The maximum product for the subarray of the input array
 * @author cuiyang36
 *
 */
public class MaxProductionArray {
	
	public static int maxProductionArray(int[] array){
		if (array == null || array.length < 1){
			return 0;
		}
		int min = array[0], max = array[0], traverse = array[0];
		for (int i = 1; i < array.length; i++){
			int tmp_min = Math.min(min * array[i], max * array[i]);
			int tmp_max = Math.max(min * array[i], max * array[i]);
			min = Math.min(tmp_min, array[i]);
			max = Math.max(tmp_max, array[i]);
			traverse = Math.max(traverse, max);
		}
		return traverse;
	}

	public static void main(String[] args){
		int[] input = new int[]{-1, 2, -5, -8, 9, 1};
		int result = maxProductionArray(input);
		System.out.println(result);
	}
}
