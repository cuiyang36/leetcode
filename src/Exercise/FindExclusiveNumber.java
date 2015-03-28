package Exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindExclusiveNumber {
	
	public static int findExclusiveNumber(int n, List<Integer> input){
		if (input == null || input.size() < 1){
			return n;
		}
		int flag = 1;
		int rst = 0;
		for (int i = 1; i <= input.size(); i++){
			List<Integer> solution = new ArrayList<Integer>();
			rst += flag * KSum(n, input, 0, solution, i);
			flag = - flag;
		}
		return n - rst;
	}
	
	private static int KSum(int n, List<Integer> input, int start, List<Integer> solution, int k){
		if (solution.size() == k){
			return n / findLeastCommonMultiple(solution);
		}
		int rst = 0;
		for (int i = start; i < input.size(); i++){
			solution.add(input.get(i));
			rst += KSum(n, input, i + 1, solution, k);
			solution.remove(solution.size() - 1);
		}
		return rst;
	}
	
	private static int findLeastCommonMultiple(List<Integer> array){
		if (array == null || array.size() < 1){
			return 1;
		}
		int rst = 1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.size(); i++){
			for (Map.Entry<Integer, Integer> entry: getDecomposition(array.get(i)).entrySet()){
				if (map.containsKey(entry.getKey())){
					map.put(entry.getKey(), Math.max(entry.getValue(), map.get(entry.getKey())));
				}else{
					map.put(entry.getKey(), entry.getValue());
				}
			}
		}
		for (Map.Entry<Integer, Integer> entry: map.entrySet()){
			rst *= Math.pow(entry.getKey(), entry.getValue());
		}
		return rst;
		
	}
	
	private static Map<Integer, Integer> getDecomposition(int n){
		Map<Integer, Integer> rst = new HashMap<Integer, Integer>();
		if (n == 1){
			return rst;
		}
		List<Integer> list = new ArrayList<Integer>();
		while (n > 1){
			int nextPrime = nextPrimeNumber(list);
			list.add(nextPrime);
			int tmp = 0;
			while (n > 1 && n % nextPrime == 0){
				tmp += 1;
				n /= nextPrime;
			}
			if (tmp > 0){
				rst.put(nextPrime, tmp);
			}
		}
		return rst;
	}
	
	private static int nextPrimeNumber(List<Integer> list){
		if (list == null || list.size() < 1){
			return 2;
		}
		int last = list.get(list.size() - 1);
		int i = last == 2? 3: last + 2;
		while (true){
			boolean flag = true;
			for (Integer e: list){
				if (i % e == 0){
					flag = false;
					break;
				}
			}
			if (flag){
				break;
			}
			i += 2;
		}
		return i;
	}
	
	public static void main(String[] args){
		List<Integer> trial = new ArrayList<Integer>();
		trial.add(2);
		trial.add(4);
		trial.add(5);
		//trial.add(15);
		int common = findLeastCommonMultiple(trial);
		System.out.println("common: " + common);
		int rst = findExclusiveNumber(20, trial);
		System.out.println("rst: " + rst);
	}

}
