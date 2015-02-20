package Exercise;

import java.util.Stack;

public class LongestTimeSeries {
	
	public static int[] longestTimeSeries(int[] input){
		if (input == null || input.length < 1){
			return null;
		}
		int[] rst = new int[input.length];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < input.length; i++){
			while (!stack.isEmpty() && input[stack.peek()] <= input[i]){
				stack.pop();
			}
			rst[i] = (stack.isEmpty())? i + 1: i - stack.peek();
			stack.push(i);
		}
		return rst;
	}
	
	public static void main(String[] args){
		int[] input = {3, 5, 6, 4, 5, 6, 1, 1, 1, 9, 8, 7};
		int[] rst = longestTimeSeries(input);
		for (int ele: rst){
			System.out.println(ele);
		}
	}

}
