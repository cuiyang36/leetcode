package Exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 题目：

   输入：第一行是一个0-999999之间的整数，代表数据中心（data center）的数量。接着的每一行分别是一个数据中心，
   每一行最先是一个0-299的整数代表该数据中心的数据组（data sets）. 
   然后就是以空格分开的数据。数据都是1-999999之间的整数。每一行最多999个字符长。

   输出：

   要求输出分布式备份的步骤，将数据在数据中心间互相拷贝，最后使得所有数据中心都有所有的数据。
   打印出的步骤的格式是： <data-set-id> <from> <to>

   <data-set-id> 就是所要拷贝的数据， <from> 是该数据所在数据中心的索引， <to>是即将拷贝过去的数据中心的索引

   当步骤结束后，打印“done”。

   能实现分布式备份的步骤往往不是唯一的，打印出任何正确地步骤均可。


   约束:

   输入必须来自stdin，输出必输到stdout。可以假设输入是有效的。
   例如：

   输入:
   3
   5 1 3 4 5 7
   2 1 3
   1 2


   一种正确地输出:
   2 3 2
   2 3 1
   1 1 3
   4 1 2
   5 1 3
   5 3 2
   4 2 3
   3 1 3
   7 1 2
   7 1 3
   done
   
 * @author cuiyang36
 *
 */
public class DistributedBackUp {
	
	public static void main(String[] args) throws Exception{
		// center2data stores the graph of data center to data
		Map<Integer, Set<Integer>> center2data = new HashMap<Integer, Set<Integer>>();
		// data stores all the data in the data centers
		Set<Integer> data = new HashSet<Integer>();
		// data2center stores the graph of data to data center, just record as the first encountered 
		Map<Integer, Integer> data2center = new HashMap<Integer, Integer>();
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		
		int number = Integer.parseInt(br.readLine());
		for (int i = 1; i <= number; i++){
			String[] input = br.readLine().split(" ");
			Set<Integer> tmp = new HashSet<Integer>();
			for (String s: input){
				int part = Integer.parseInt(s);
				tmp.add(part);
				data.add(part);
				if (!data2center.containsKey(part)){
					data2center.put(part, i);
				}
			}
			center2data.put(i, tmp);
		}
		
		// try to compare each data center with the complete data
		for (Map.Entry<Integer, Set<Integer>> entry: center2data.entrySet()){
			int toCenter = entry.getKey();
			Set<Integer> dataSet = entry.getValue();
			for (Integer i: data){
				if (!dataSet.contains(i)){
					int fromCenter = data2center.get(i);
					System.out.println(i + " " + fromCenter + " " + toCenter);
				}
			}
		}
		
		System.out.println("done");
	}
	
	
	
	

}
