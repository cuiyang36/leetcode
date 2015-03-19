package Exercise;

import java.util.Stack;

/**
 * next node in BST
 * has a parent pointer
 * no parent pointer, but the root node is given
 * 
 * @author cuiyang36
 *
 */
public class NextNode {
	
	public static TreeNodeParent findNextNode(TreeNodeParent node){
		if (node == null){
			return null;
		}
		TreeNodeParent curr;
		TreeNodeParent parent;
		
		// the first condition, if the node has the right child
		// the next node should be the smallest child of it
		if (node.right != null){
			curr = node.right;
			while (curr != null){
				curr = curr.left;
			}
			return curr;
		}
		// traverse to the top level until find the first parent
		// as its left parent
		curr = node;
		while (curr.parent != null){
			parent = curr.parent;
			// find as the left parent, return
			if (parent.left == curr){
				return parent;
			}
			curr = parent;
		}
		// all the parents are the right ones
		return null;
	}
	
    // here I will use stack and the root node to do the inorder traversal
	public static TreeNode findNextNode(TreeNode node, TreeNode root){
		if (node == null || root == null){
			return null;
		}
		// if the node has the right child, find the smallest child
		// bigger than it
		if (node.right != null){
			TreeNode curr = node.right;
			while (curr != null){
				curr = curr.left;
			}
			return curr;
		}
		// else, use stack to traverse
		Stack<TreeNode> stack = new Stack<TreeNode>();
		boolean flag = false;
		while (root != null || !stack.isEmpty()){
			if (root != null){
				stack.push(root);
				root = root.left;
			}else{
				root = stack.pop();
				if (flag){
					return root;
				}
				if (root == node){
					flag = true;
				}
				root = root.right;
			}
		}
		return null;
	}
	
	public static void main(String[] args){
		TreeNodeParent four = new TreeNodeParent(4);
		TreeNodeParent two = new TreeNodeParent(2);
		TreeNodeParent five = new TreeNodeParent(5);
		TreeNodeParent three = new TreeNodeParent(3);
		four.left = two;
		four.right = five;
		two.right = three;
		two.parent = four;
		five.parent = four;
		three.parent = two;
		TreeNodeParent rst = findNextNode(three);
		System.out.println(rst.val);
		TreeNode four1 = new TreeNode(4);
		TreeNode two1 = new TreeNode(2);
		TreeNode five1 = new TreeNode(5);
		TreeNode three1 = new TreeNode(3);
		four1.left = two1;
		four1.right = five1;
		two1.right = three1;
		TreeNode rst1 = findNextNode(three1, four1);
		System.out.println(rst1.val);
	}

}
