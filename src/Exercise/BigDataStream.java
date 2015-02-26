package Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * All the tasks should be completed in real time input streaming
 * Task 1: only store the String that has no duplication with using the minimum space
 * Task 2: find the top k frequency Strings
 * @author cuiyang36
 *
 */
public class BigDataStream {
	
	private static class Node{
		public String content;
		public int number;
		public Node(String content, int number){
			this.content = content;
			this.number = number;
		}
	}
	
	public static List<String> task1(List<String> input){
		Set<String> rst = new HashSet<String>();
		Set<String> dup = new HashSet<String>();
		
		for (int i = 0; i < input.size(); i++){
			String curr = input.get(i);
			if (dup.contains(curr)){
				continue;
			}
			if (rst.contains(curr)){
				rst.remove(curr);
				dup.add(curr);
			}else{
				rst.add(curr);
			}
			log("rst", rst);
			log("dup", dup);
		}
		List<String> rst1 = new ArrayList<String>();
		for (String s: rst){
			rst1.add(s);
		}
		return rst1;
	}

	public static List<String> task2(List<String> input, int k){
		Map<String, Node> map = new HashMap<String, Node>();
		Set<String> set = new HashSet<String>();
		Comparator<Node> cp = new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2) {
				return o1.number - o2.number;
			}
		};
		Queue<Node> queue = new PriorityQueue<Node>(k, cp);
		// time complexity: nlog(k)
		for (String s: input){
			if (!map.containsKey(s)){
				map.put(s, new Node(s, 1));
			}else{
				map.get(s).number += 1;
			}
			if (!set.contains(s) && set.size() < k){
				set.add(s);
				queue.add(map.get(s));
			}else if (set.size() == k && !set.contains(s) && map.get(s).number > queue.peek().number){
				set.remove(queue.poll().content);
				set.add(s);
				queue.add(map.get(s));
			}
			log("set", set);
		}
		List<String> rst = new ArrayList<String>();
		while (!queue.isEmpty()){
			rst.add(queue.poll().content);
		}
		return rst;
	}
	
	private static void log(String name, Set<String> set){
		System.out.println(name);
		for (String s: set){
			System.out.print(s + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		String[] input = new String[]{"a", "b", "x", "b", "x", "c", "d", "e", "f", "a", "x", "e", "e", "e"};
		List<String> in = Arrays.asList(input);
		List<String> rst1 = task1(in);
		List<String> rst2 = task2(in, 3);
	}
}
