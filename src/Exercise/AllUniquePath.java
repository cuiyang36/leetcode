package Exercise;

import java.util.ArrayList;
import java.util.List;

public class AllUniquePath {

	public static List<String> allUniquePath(int m, int n){
		return helper(0, 0, m, n);
	}
	
	private static List<String> helper(int i, int j, int m, int n){
		List<String> rst = new ArrayList<String>();
		if (i == m || j == n){
			return rst;
		}
		
		String curr = i + "," + j;
		if (i == m - 1 && j == n - 1){
			rst.add(curr);
			return rst;
		}
		
		List<String> rst1 = helper(i + 1, j, m, n);
		List<String> rst2 = helper(i, j + 1, m, n);
		for (String s1: rst1){
			rst.add(curr + " -> " + s1);
		}
		
		for (String s2: rst2){
			rst.add(curr + " -> " + s2);
		}
		//System.out.println(curr + " " + rst.size());
		return rst;
	}
	
	public static void main(String[] args){
		List<String> rst = allUniquePath(4, 4);
		for (String s: rst){
			System.out.println(s);
		}
	}
}
