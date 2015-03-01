package Exercise;

import java.util.Stack;

/**
 * serialize / deserialize n tree
 * @author cuiyang36
 *
 */
public class Serialize_Deserialize_NTree {
	
	public static String serializeDFS(TreeNodeII root){
		StringBuffer sb = new StringBuffer();
		serializeDFSHelper(root, sb);
		return sb.toString();
	}
	
	private static void serializeDFSHelper(TreeNodeII root, StringBuffer sb){
		if (root == null){
			return;
		}
		sb.append(root.val);
		// separate the strings of the node
		sb.append("#");
		for (TreeNodeII node: root.neighbors){
			serializeDFSHelper(node, sb);
		}
		sb.append("|");
		sb.append("#");
	}
	
	public static TreeNodeII deserializeDFS(String s){
		if (s == null || s.length() < 1){
			return null;
		}
		String[] array = s.split("#");
		TreeNodeII root = new TreeNodeII(array[0]);
		Stack<TreeNodeII> stack = new Stack<TreeNodeII>();
		stack.push(root);
		for (int i = 1; i < array.length; i++){
			if (array[i].equals("")){
				continue;
			}
			if (array[i].equals("|")){
				stack.pop();
			}else{
				TreeNodeII node = new TreeNodeII(array[i]);
				stack.peek().neighbors.add(node);
				stack.push(node);
			}
		}
		return root;
	}
	
	public static void main(String[] args){
		TreeNodeII a = new TreeNodeII("a");
		TreeNodeII b = new TreeNodeII("b");
		TreeNodeII c = new TreeNodeII("c");
		TreeNodeII d = new TreeNodeII("d");
		TreeNodeII e = new TreeNodeII("e");
		TreeNodeII f = new TreeNodeII("f");
		TreeNodeII g = new TreeNodeII("g");
		TreeNodeII h = new TreeNodeII("h");
		TreeNodeII i = new TreeNodeII("i");
		TreeNodeII j = new TreeNodeII("j");
		a.neighbors.add(b);
		a.neighbors.add(c);
		a.neighbors.add(d);
		b.neighbors.add(e);
		b.neighbors.add(f);
		c.neighbors.add(g);
		c.neighbors.add(h);
		c.neighbors.add(i);
		d.neighbors.add(j);
		String rst = serializeDFS(a);
		System.out.println(rst);
		TreeNodeII root = deserializeDFS(rst);
		System.out.println(serializeDFS(root));
	}

}
