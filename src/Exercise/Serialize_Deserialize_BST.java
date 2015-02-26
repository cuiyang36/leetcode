package Exercise;

import java.util.Stack;

public class Serialize_Deserialize_BST {
	
	public static String serializeBST(TreeNode root){
		StringBuffer sb = new StringBuffer();
		if (root == null){
			return sb.toString();
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()){
			TreeNode curr = stack.pop();
			sb.append(curr.val + "#");
			if (curr.right != null){
				stack.push(curr.right);
			}
			if (curr.left != null){
				stack.push(curr.left);
			}
		}
		return sb.toString();
	}
	
	public static TreeNode deserializeBST(String s){
		if (s == null || s.length() < 1){
			return null;
		}
		String[] array = s.split("#");
		TreeNode root = new TreeNode(Integer.valueOf(array[0]));
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		for (int i = 1; i < array.length; i++){
			if (array[i].equals("")){
				continue;
			}
			TreeNode curr = new TreeNode(Integer.valueOf(array[i]));
			if (curr.val < stack.peek().val){
				stack.peek().left = curr;
			}else{
				TreeNode last = stack.peek();
				while (!stack.isEmpty() && stack.peek().val < curr.val){
					last = stack.pop();
				}
				last.right = curr;
			}
			stack.push(curr);
		}
		return root;
	}
	
	public static void main(String[] args){
		String input = "5#3#2#1#4#6#7#";
		TreeNode root = deserializeBST(input);
		String rst = serializeBST(root);
		System.out.println(rst);
	}

}
