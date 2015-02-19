package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GoodNode {
	
	public static void main(String[] args){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		try{
			int number = Integer.valueOf(br.readLine());
			if (number <= 1){
				return;
			}
			String line;
			Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
			// set up the graph
			for (int i = 0; i < number; i++){
				graph.put(i, new HashSet<Integer>());
			}
			for (int i = 0; i < number; i++){
				line = br.readLine();
				int node1 = Integer.valueOf(line.split("\t")[0]) - 1;
				int node2 = Integer.valueOf(line.split("\t")[1]) - 1;
				graph.get(node1).add(node2);
				graph.get(node2).add(node1);
			}
			// start bfs from the root node
			Set<Integer> good = new HashSet<Integer>();
			Queue<Integer> queue = new LinkedList<Integer>();
			good.add(0);
			queue.add(0);
			while (!queue.isEmpty()){
				int curr = queue.poll();
				for (Integer node: graph.get(curr)){
					if (good.contains(node)){
						continue;
					}
					good.add(node);
					queue.add(node);
				}
			}
			for (int i = 0; i < number; i++){
				if (!good.contains(i)){
					System.out.println(i + 1);
				}
			}
		} catch (IOException e){
			e.printStackTrace();
		}
	}

}
