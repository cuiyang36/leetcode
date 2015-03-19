package Leetcode;

import Exercise.TreeNode;

public class CommonAncester {
	
	public static TreeNode commonAncester(TreeNode node1, TreeNode node2, TreeNode root){
		if (root == null || node1 == null || node2 == null){
			return null;
		}
		return helper(root, node1, node2);
	}
	
	private static TreeNode helper(TreeNode curr, TreeNode node1, TreeNode node2){
		if (curr == null){
			return null;
		}
		if (curr == node1 || curr == node2){
			return curr;
		}
		TreeNode left = helper(curr.left, node1, node2);
		TreeNode right = helper(curr.right, node1, node2);
		if (left != null && right != null){
			return curr;
		}
		return (left == null)? right: left;
	}

	public static void main(String[] args){
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		one.left = two;
		one.right = three;
		TreeNode rst = commonAncester(two, new TreeNode(4), one);
		System.out.println(rst.val);
	}
}
