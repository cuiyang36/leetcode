package Exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodNode {

	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int number = Integer.valueOf(br.readLine());
		if (number <= 1) {
			System.out.println(0);
			return;
		}
		// set up map, i --> group number, i --> {i} initially
		Map<Integer, Integer> i_group = new HashMap<Integer, Integer>();
		Map<Integer, List<Integer>> i_list = new HashMap<Integer, List<Integer>>();
		for (int i = 1; i <= number; i++){
			i_group.put(i, i);
			i_list.put(i, new ArrayList<Integer>());
			i_list.get(i).add(i);
		}
		int curr;
		for (int i = 1; i <= number; i++){
			curr = Integer.parseInt(br.readLine());
			if (curr == i || i == 1){
				continue;
			}
			// i --> curr
			int newGroup = i_group.get(curr);
			int oldGroup = i_group.get(i);
			if (newGroup == oldGroup){
				continue;
			}
			// combine i group to the curr
			for (Integer e: i_list.get(oldGroup)){
				i_group.put(e, newGroup);
				i_list.get(newGroup).add(e);
			}
			// remove the old group
			i_list.remove(oldGroup);
		}
		System.out.println(i_list.size() - 1);
	}

}
