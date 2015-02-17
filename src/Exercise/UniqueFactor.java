package Exercise;
import java.util.ArrayList;
import java.util.List;

public class UniqueFactor {
	
	public static List<List<Integer>> uniqueFactor(int n){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (n <= 0){
			return result;
		}
		List<Integer> general = new ArrayList<Integer>();
		general.add(1);
		general.add(n);
		result.add(general);
		List<Integer> solution = new ArrayList<Integer>();
		helper(result, solution, n, 2);
		return result;
	}
	
	private static void helper(List<List<Integer>> result, List<Integer> solution, int n, int factor){
		if (solution.size() > 0){
			solution.add(n);
			result.add(new ArrayList<Integer>(solution));
			solution.remove(solution.size() - 1);
		}
		for (int i = factor; i <= n / factor; i++){
			if (n % i == 0 && n / i >= i){
				solution.add(i);
				helper(result, solution, n / i, i);
				solution.remove(solution.size() - 1);
			}
		}
	}
	
	public static void main(String[] args){
		int n = 48;
		List<List<Integer>> result = uniqueFactor(n);
		for (List<Integer> list: result){
			for (Integer ele: list){
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}

}
