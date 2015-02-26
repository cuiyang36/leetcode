package Exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 从stdin读入一行String，String中同时包括单词和数字，以空格分开。
 * 需要将输入进行排序，要求：
 * （1）字母和数字分别顺序排序
 * （2）输入中原本是字母/数字的地方依然是字母/数字。
    比如:
    
    输入：d 3 c 2 1 a 输出为 a 1 c 2 3 d 

    输入：add 6 abb at 输出为 abb 6 add at
 * @author cuiyang36
 *
 */
public class MixSort {
	
	public static void main(String[] args) throws Exception{
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String line = null;
		while ((line = br.readLine()) != null){
			mixSort(line);
		}
	}
	
	private static void mixSort(String line){
		String[] input = line.split(" ");
		List<String> words = new ArrayList<String>();
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < input.length; i++){
			if (isNumber(input[i])){
				numbers.add(Integer.parseInt(input[i]));
				input[i] = "0";
			}else{
				words.add(input[i]);
				input[i] = "1";
			}
		}
		Collections.sort(words);
		Collections.sort(numbers);
		
		// fill in the input array again
		int pn = 0;
		int pw = 0;
		for (int i = 0; i < input.length; i++){
			if (input[i].equals("0")){
				input[i] = String.valueOf(numbers.get(pn++));
			}else{
				input[i] = words.get(pw++);
			}
			if (i == input.length - 1){
				System.out.println(input[i]);
			}else{
				System.out.print(input[i] + " ");
			}
		}
	}
	
	private static boolean isNumber(String s){
		return s.matches("[+-]?\\d*.?\\d+");
	}

}
