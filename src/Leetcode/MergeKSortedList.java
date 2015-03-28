package Leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge K sorted lists, list version
 * @author cuiyang36
 *
 */
public class MergeKSortedList {
	
	public static class Node{
		int listNum;
		int index;
		public Node(int listNum, int index){
			this.listNum = listNum;
			this.index = index;
		}
	}
	
	public static List<Integer> mergeKSortedList(List<List<Integer>> input){
		List<Integer> rst = new ArrayList<Integer>();
		if (input == null || input.size() < 1){
			return rst;
		}
		final List<List<Integer>> data = new ArrayList<List<Integer>>(input);
		Comparator<Node> cp = new Comparator<Node>(){

			@Override
			public int compare(Node o1, Node o2) {
				return data.get(o1.listNum).get(o1.index) - data.get(o2.listNum).get(o2.index);
			}		
		};
		
		Queue<Node> queue = new PriorityQueue<Node>(data.size(), cp);
		
		for (int i = 0; i < data.size(); i++){
			if (data.get(i).size() > 0){
				queue.add(new Node(i, 0));
			}
		}
		
		while (!queue.isEmpty()){
			Node curr = queue.poll();
			rst.add(data.get(curr.listNum).get(curr.index));
			if (curr.index < data.get(curr.listNum).size() - 1){
				queue.add(new Node(curr.listNum, curr.index + 1));
			}
		}
		return rst;
	}
	
	public static void main(String[] args){
		List<List<Integer>> input = new ArrayList<List<Integer>>();
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		List<Integer> list4 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(10);
		list2.add(15);
		list3.add(2);
		list3.add(6);
		list3.add(8);
		list3.add(13);
		list3.add(15);
		list3.add(20);
		input.add(list1);
		input.add(list2);
		input.add(list3);
		input.add(list4);
		List<Integer> rst = mergeKSortedList(input);
		for (Integer e: rst){
			System.out.println(e);
		}
	}
	

}
