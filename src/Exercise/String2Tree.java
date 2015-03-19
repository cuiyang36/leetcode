package Exercise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class String2Tree {

	public static TreeNode string2Tree(String s){
		if (s == null || s.length() < 1 || s.length() % 2 == 0){
			return null;
		}
		TreeNode root = new TreeNode(s.charAt(0));
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		for (int i = 1; i < s.length(); i += 2){
			TreeNode node = new TreeNode(s.charAt(i + 1));
			if (s.charAt(i) == '?'){
				stack.peek().left = node;
			}else{
				stack.pop().right = node;
			}
			if (i + 2 < s.length() && s.charAt(i + 2) == '?'){
				stack.push(node);
			}
		}
		return root;
	}
	
	public static void levelTraversal(TreeNode root){
		if (root == null){
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()){
			int size = queue.size();
			for (int i = 0; i < size; i++){
				TreeNode curr = queue.poll();
				System.out.print((char)curr.val + " ");
				if (curr.left != null){
					queue.add(curr.left);
				}
				if (curr.right != null){
					queue.add(curr.right);
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		String s = "a?b?c:d:e";
		TreeNode root = string2Tree(s);
		levelTraversal(root);
		String s2 = "a?b?c?e:f:d?g:h:i?j:k";
		levelTraversal(string2Tree(s2));
	}
}
