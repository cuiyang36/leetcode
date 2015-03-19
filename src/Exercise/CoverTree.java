package Exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CoverTree {
	
	public static List<TreeNode> coverTree(TreeNode root){
		List<TreeNode> rst = new ArrayList<TreeNode>();
		if (root == null){
			return rst;
		}
		Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		map.put(root, 0);
		int leftBound = Integer.MAX_VALUE, rightBound = Integer.MIN_VALUE;
		while (!queue.isEmpty()){
			TreeNode curr = queue.poll();
			int pos = map.get(curr);
			if (pos > rightBound || pos < leftBound){
				rst.add(curr);
				rightBound = Math.max(pos, rightBound);
				leftBound = Math.min(pos, leftBound);
			}
			if (curr.left != null){
				map.put(curr.left, pos - 1);
				queue.add(curr.left);
			}
			if (curr.right != null){
				map.put(curr.right, pos + 1);
				queue.add(curr.right);
			}
		}
		return rst;
	}

}
