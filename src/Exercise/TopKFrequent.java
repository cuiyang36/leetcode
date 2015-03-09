package Exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Top K frequent elements
 * 1. in unsorted array
 * 2. in input stream
 * suppose the element is String
 * 
 * @author cuiyang36
 *
 */
public class TopKFrequent {
	
	// inner static class for dynamic class
	public static class Node{
		public String s;
		public int n;
		
		public Node(String s, int n){
			this.s = s;
			this.n = n;
		}
	}
	
	public static List<String> inUnsortedArray(String[] array, int k){
		List<String> rst = new ArrayList<String>();
		if (array == null || array.length < 1 || k > array.length){
			return rst;
		}
		// set the string - number map, use LinkedHashMap for the initial sequence
		// to maintain as the original sequence
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		for (String s: array){
			if (!map.containsKey(s)){
				map.put(s, 1);
			}else{
				map.put(s, map.get(s) + 1);
			}
		}

		// define the comparator
		Comparator<Map.Entry<String, Integer>> cp = new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				// smallest element at the top 
				return o1.getValue() - o2.getValue();
			}	
		};
		
		// define the pq, it's a minHeap
		Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<Map.Entry<String, Integer>>(k, cp);
		int index = 0;
		for (Map.Entry<String, Integer> entry: map.entrySet()){
			if (index < k){
				queue.add(entry);
			}else{
				if (entry.getValue() > queue.peek().getValue()){
					queue.poll();
					queue.add(entry);
				}
			}
			index += 1;
		}
		
		// output the rst from the queue
		while (!queue.isEmpty()){
			rst.add(queue.poll().getKey());
		}
		return rst;
	}
	
	public static void main(String[] args) throws Exception{
		int k = 3;
		String[] array = new String[]{"a", "b", "c", "b", "b", "a", "d", "d", "c", "e"};
		List<String> rst = inUnsortedArray(array, k);
		for (String s: rst){
			System.out.print(s + " ");
		}
		System.out.println("\nstreaming: ");
		// set up the dynamic map
		Map<String, Node> map = new HashMap<String, Node>();
		
		// record the Strings that are in the pq now
		Set<String> set = new HashSet<String>();
		
		// define the comparator
		Comparator<Node> cp = new Comparator<Node>(){

			@Override
			public int compare(Node o1, Node o2) {
				return o1.n - o2.n;
			}	
		};
		
		// define the pq, it's a minHeap, the smallest is on the top
		Queue<Node> queue = new PriorityQueue<Node>(k, cp);
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String line = null;
		while (!(line = br.readLine()).equals("")){
			if (map.containsKey(line)){
				map.get(line).n += 1;
			}else{
				map.put(line, new Node(line, 1));
			}
			
			// check the status of the node when we need to adjust the queue
			// when the size of the queue is smaller than k
			if (queue.size() < k){
				queue.add(map.get(line));
				set.add(line);
			// when the Node is not in the queue, but its n is larger than the 
			// n of the top element in the queue
			}else if (!set.contains(line) && map.get(line).n > queue.peek().n){
				set.remove(queue.poll().s);
				queue.add(map.get(line));
				set.add(line);
			}
		}
		System.out.println();
		while (!queue.isEmpty()){
			Node curr = queue.poll();
			System.out.print("{" + curr.s + " " + curr.n + "} ");
		}
	}

}
