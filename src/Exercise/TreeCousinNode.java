package Exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the binary Tree and the two nodes say ‘a’ and ‘b’, 
 * determine whether the two nodes are cousins of each other or not. 
 * Two nodes are cousins of each other if they are at same level 
 * and have different parents.
 * @author cuiyang36
 *
 */
public class TreeCousinNode {

	public static boolean treeCousinNode(TreeNode root, TreeNode node1, TreeNode node2){
		if (root == null || node1 == null || node2 == null){
			return false;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode parent1 = null;
		TreeNode parent2 = null;
		while (!queue.isEmpty()){
			int size = queue.size();
			boolean findFirst = false;
			boolean findSecond = false;
			for (int i = 0; i < size; i++){
				TreeNode curr = queue.poll();
				// check whether the two nodes are in the same level
				if (curr.equals(node1)){
					findFirst = true;
				}
				if (curr.equals(node2)){
					findSecond = true;
				}
				// check whether the same parent for the two nodes
				if (curr.left != null){
					if (curr.left.equals(node1)){
						parent1 = curr;
					}else if (curr.left.equals(node2)){
						parent2 = curr;
					}
					queue.add(curr.left);
				}
				if (curr.right != null){
					if (curr.right.equals(node1)){
						parent1 = curr;
					}else if (curr.right.equals(node2)){
						parent2 = curr;
					}
					queue.add(curr.right);
				}
			}
			// find all of them, check parents
			if (findFirst && findSecond){
				return (parent1.equals(parent2))? false: true;
			// find neither of them in this level
			}else if (!findFirst && !findSecond){
				continue;
			// just find one, return false
			}else{
				return false;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		TreeNode six = new TreeNode(6);
		TreeNode three = new TreeNode(3);
		TreeNode five = new TreeNode(5);
		TreeNode seven = new TreeNode(7);
		TreeNode eight = new TreeNode(8);
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		six.left = three;
		six.right = five;
		three.left = seven;
		three.right = eight;
		five.left = one;
		five.right = two;
		boolean rst1 = treeCousinNode(six, seven, eight);
		boolean rst2 = treeCousinNode(six, seven, one);
		boolean rst3 = treeCousinNode(six, three, two);
		System.out.println("rst1: " + rst1);
		System.out.println("rst2: " + rst2);
		System.out.println("rst3: " + rst3);
	}
}
