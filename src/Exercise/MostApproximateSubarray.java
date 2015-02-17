package Exercise;


/**
 * Find the subarray that its sum is the most approximate value when compared 
 * with the target value
 * @author cuiyang36
 *
 */
public class MostApproximateSubarray {

	public static int mostApproximateSubarray(int[] array, int target){
		if (array == null || array.length < 1){
			return Integer.MAX_VALUE;
		}
		int[] sums = new int[array.length + 1];
		sums[0] = 0;
		for (int i = 1; i < sums.length; i++){
			sums[i] = sums[i - 1] + array[i - 1];
		}
		int rst = Integer.MAX_VALUE;
		for (int i = 0; i < sums.length - 1; i++){
			for (int j = i + 1; j < sums.length; j++){
				int curr = sums[j] - sums[i];
				if (Math.abs(rst - target) > Math.abs(curr - target)){
					rst = curr;
				}
			}
		}
		return rst;
	}
	
	public static void main(String[] args){
		int[] array = new int[]{-1, 2, 4, -4, 5, 9, -2, -3, 7};
		int rst = mostApproximateSubarray(array, 0);
		System.out.println(rst);
	}
}
