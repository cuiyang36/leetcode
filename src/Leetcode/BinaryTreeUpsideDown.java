package Leetcode;

import Exercise.Serialize_Deserialize_BST;
import Exercise.TreeNode;

/**
 * Given a binary tree where all the right nodes are either 
 * leaf nodes with a sibling (a left node that shares the same 
 * parent node) or empty, flip it upside down and turn it into 
 * a tree where the original right nodes turned into left leaf 
 * nodes. Return the new root.
 * For example:
   Given a binary tree {1,2,3,4,5},
   return the root of the binary tree [4,5,2,#,#,3,1].
 * @author cuiyang36
 *
 */

public class BinaryTreeUpsideDown {
	
	/**
	 * Method 1, reverse the tree just like reversing the linkedlist
	 * iterative method， bottom down method
	 * @param root
	 * @return
	 */
	public static TreeNode upsideDownBinaryTreeMethod1(TreeNode root){
		TreeNode curr = root, parent = null, rightChild = null;
		while (curr != null){
			TreeNode leftChild = curr.left;
			curr.left = rightChild;
			rightChild = curr.right;
			curr.right = parent;
			parent = curr;
			curr = leftChild;
		}
		return parent;
	}
	
	/**
	 * Method 2, recursion method, bottom up method
	 * @param root
	 * @return
	 */
	public static TreeNode upsideDownBinaryTreeMethod2(TreeNode root){
		return dfsBottomUp(root, null);
	}
	
	private static TreeNode dfsBottomUp(TreeNode curr, TreeNode parent){
		if (curr == null){
			return parent;
		}
		TreeNode root = dfsBottomUp(curr.left, curr);
		curr.left = (parent == null)? null: parent.right;
		curr.right = parent;
		return root;
	}

	public static void main(String[] args){
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		four.left = six;
		String rst = Serialize_Deserialize_BST.serializeBST(upsideDownBinaryTreeMethod2(one));
		//6#4#5#2#3#1#
		System.out.println(rst);
	}
}
