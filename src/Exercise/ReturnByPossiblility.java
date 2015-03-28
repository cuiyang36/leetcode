package Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ReturnByPossiblility {
	
	public static class City{
		String name;
		int number;
		City(String name, int number){
			this.name = name;
			this.number = number;
		}
	}
	
	// make it a method for convience
	public static City returnByPossibility(City[] array){
		//System.out.println("here 1");
		// handle some invalid cases
		if (array == null || array.length < 1){
			return null;
		}
		//System.out.println("here 2");
		int[] pool = new int[array.length];
		Map<Integer, City> map = new HashMap<Integer, City>();
		int sum = 0;
		for (int i = 0; i < array.length; i++){
			pool[i] = sum;
			map.put(sum, array[i]);
			sum += array[i].number;
		}
		int random = new Random().nextInt(sum);
		
		// left one is always smaller than target and right one is always larger
		// than the target
		int left = 0, right = pool.length - 1;
		while (left < right - 1){
			int mid = left + (right - left) / 2;
			if (random == pool[mid]){
				return map.get(pool[mid]);
			}else if (random > pool[mid]){
				left = mid;
			}else{
				// so right may be smaller than the random
				right = mid - 1;
			}
		}
		//System.out.println(sum + " " + random + " " + pool[left]);
		return (pool[right] <= random)? map.get(pool[right]): map.get(pool[left]);
	}
	
	public static void main(String[] args){
		City[] array = new City[]{new City("A", 2), new City("B", 3), new City("C", 5)};
		int number = 100;
		int A = 0, B = 0, C = 0;
		for (int i = 0; i < number; i++){
			City tmp = returnByPossibility(array);
			String rst = tmp.name;
			//System.out.println(rst);
			if (rst.equals("A")){
				A += 1;
			}else if (rst.equals("B")){
				B += 1;
			}else{
				C += 1;
			}
			//System.out.println(rst);
		}
		System.out.println("A: " + A);
		System.out.println("B: " + B);
		System.out.println("C: " + C);
	}

}
