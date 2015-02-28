package Exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RecontructTreeFromPair {
	
	public static void main(String[] args) throws Exception{
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String line = null;
		Set<String> parents = new HashSet<String>();
		Set<String> childs = new HashSet<String>();
		Map<String, TreeNodeII> tree = new HashMap<String, TreeNodeII>();
		while (!(line = br.readLine()).equals("")){
			String parent = line.split(" ")[0];
			String child = line.split(" ")[1];
			parents.add(parent);
			childs.add(child);
			if (!tree.containsKey(parent)){
				tree.put(parent, new TreeNodeII(parent));
			}
			if (!tree.containsKey(child)){
				tree.put(child, new TreeNodeII(child));
			}
			tree.get(parent).neighbors.add(tree.get(child));
		}
		
		TreeNodeII root = null;
		for (String key: parents){
			if (!childs.contains(key)){
				root = tree.get(key);
				break;
			}
		}
		String rst = Serialize_Deserialize_NTree.serializeDFS(root);
		System.out.println(rst);
	}
}
