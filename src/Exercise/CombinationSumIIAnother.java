package Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIIAnother {
	
	public List<List<Integer>> combinationSumIIAnother(int[] input, int target){
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (input == null || input.length < 1){
			return rst;
		}
		Arrays.sort(input);
		List<Integer> solution = new ArrayList<Integer>();
		helper(rst, solution, input, 0, target);
		return rst;
	}

	private static void helper(List<List<Integer>> rst, List<Integer> solution, int[] input, int start, int target){
		if (target == 0){
			rst.add(new ArrayList<Integer>(solution));
			return;
		}
		if (target < 0){
			return;
		}
		for (int i = start; i < input.length; i++){
			if (i > start && input[i] == input[i - 1]){
				continue;
			}
			solution.add(input[i]);
			helper(rst, solution, input, i + 1, target - input[i]);
			solution.remove(solution.size() - 1);
		}
	}
}
