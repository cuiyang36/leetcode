package Exercise;

import java.util.Stack;

public class BstPreorder {
	
	public static TreeNode deserialize(int[] preorder){
		if (preorder == null || preorder.length < 1){
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode last = null;
		for (int i = 1; i < preorder.length; i++){
			TreeNode curr = new TreeNode(preorder[i]);
			if (preorder[i] < stack.peek().val){
				stack.peek().left = curr;
				stack.push(curr);
			}else{
				while (!stack.isEmpty() && stack.peek().val < preorder[i]){
					last = stack.pop();
				}
				last.right = curr;
				stack.push(curr);
			}
		}
		return root;
	}
	
	public static void main(String[] args){
		int[] preorder = {10, 5, 1, 7, 40, 50};
		TreeNode root = BstPreorder.deserialize(preorder);
		System.out.println("left: " + root.left.val);
		System.out.println("right: " + root.right.val);
	}

}
