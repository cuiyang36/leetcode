package Leetcode;

/**
 * The maximum sum for the subarray of the input array
 * @author cuiyang36
 *
 */
public class MaxSumArray {
	
	public static int maxSumArray(int[] array){
		if (array == null || array.length < 1){
			return 0;
		}
		int result = Integer.MIN_VALUE;
		int traverse = 0;
		for (int i = 0; i < array.length; i++){
			traverse = Math.max(0, traverse) + array[i];
			result = Math.max(result, traverse);
		}
		return result;
	}
	
	public static void main(String[] args){
		int[] array = new int[]{-1, 2, 6, 5, -7, -3, 6};
		int result = maxSumArray(array);
		System.out.println(result);
	}

}
