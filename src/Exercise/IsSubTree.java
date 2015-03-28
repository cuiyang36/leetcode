package Exercise;


/* CC150 4.8
 * You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.
 * Create an algorithm to decide if T2 is a subtree of Tl.
 * A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two trees would be identical.
 */

public class IsSubTree {

	public static boolean isSubTree(TreeNode root1, TreeNode root2){
		if (root1 == null && root2 == null){
			return true;
		}
		if (root1 == null || root2 == null){
			return false;
		}
		TreeNode curr = root1;
		while (curr != null && curr.val != root2.val){
			if (curr.val > root2.val){
				curr = curr.right;
			}else{
				curr = curr.left;
			}
		}
		if (curr == null){
			return false;
		}
		return isSameTree(curr, root2);
	}
	
	private static boolean isSameTree(TreeNode root1, TreeNode root2){
		if (root1 == null && root2 == null){
			return true;
		}
		if (root1 == null || root2 == null){
			return false;
		}
		if (root1.val != root2.val){
			return false;
		}
		return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
	}
}
