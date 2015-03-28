package Exercise;

import java.util.ArrayList;

/**
 * LCA problem, elements could be same
 * @author cuiyang36
 *
 */
public class LCAoptimization {
	
	public static int solution(int[] array){
		if (array == null || array.length < 1){
			return 0;
		}
		ArrayList<Integer> rst = new ArrayList<Integer>();
		rst.add(array[0]);
		for (int i = 1; i < array.length; i++){
			if (array[i] >= rst.get(rst.size() - 1)){
				rst.add(array[i]);
			}else{
				// find the first element that is bigger than 
				// the current one
				int left = 0, right = rst.size() - 1;
				while (left + 1 < right){
					int mid = left + (right - left) / 2;
					if (rst.get(mid) <= array[i]){
						left = mid + 1;
					}else{
						right = mid; 
					}
				}
				int index = rst.get(left) > array[i]? left: right;
				rst.set(index, array[i]);
			}
		}
		return rst.size();
	}
	
	public static void main(String[] args){
		int rst = solution(new int[]{1,1,5,8,3,3,6,7});
		System.out.println(rst);
	}

}
