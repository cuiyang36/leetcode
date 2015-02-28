package Exercise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BtMarker {

	private static final String MARKER = "$";
	private static final String PATH = "/Users/cuiyang36/Desktop/test.txt";

	public static boolean serialize(TreeNode root) throws IOException {
		if (root == null) {
			return false;
		}
		FileWriter fw = new FileWriter(PATH);
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode curr = null;
		while (!stack.isEmpty()) {
			curr = stack.pop();
			if (curr == null) {
				fw.write(MARKER + " ");
			} else {
				fw.write(String.valueOf(curr.val) + " ");
				stack.push(curr.right);
				stack.push(curr.left);
			}
		}
		fw.close();
		return true;
	}

	
	@SuppressWarnings("resource")
	public static TreeNode deserialize() {
		FileReader fr = null;
		Scanner scan = null;
		try {
			fr = new FileReader(PATH);
			scan = new Scanner(fr);
			TreeNode root = new TreeNode(Integer.parseInt(scan.next()));
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(root);
			String nextString = null;
			while (scan.hasNext()) {
				nextString = scan.next();
				if (nextString.equals(MARKER)) {
					if (!stack.isEmpty() && stack.peek() != null) {
						if (stack.peek().left != null){
							stack.pop();
						}else{
							stack.push(null);
						}
					} else {
						stack.pop();
						stack.pop();
					}
				} else {
					TreeNode curr = new TreeNode(Integer.parseInt(nextString));
					if (stack.isEmpty()) {
						stack.push(curr);
					} else if (stack.peek() == null) {
						stack.pop();
						stack.peek().right = curr;
						stack.pop();
						stack.push(curr);
					} else if (stack.peek().left != null) {
						stack.peek().right = curr;
						stack.pop();
						stack.push(curr);
					} else {
						stack.peek().left = curr;
						stack.push(curr);
					}
				}
			}
			return root;
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	
	public static void main(String[] args) throws IOException {
		TreeNode node20 = new TreeNode(20);
		TreeNode node8 = new TreeNode(8);
		TreeNode node4 = new TreeNode(4);
		TreeNode node12 = new TreeNode(12);
		TreeNode node10 = new TreeNode(10);
		TreeNode node14 = new TreeNode(14);
		node20.left = node8;
		node8.left = node4;
		node8.right = node12;
		node12.left = node10;
		node12.right = node14;
		boolean result = BtMarker.serialize(node20);
		System.out.println("serialize: " + result);
		TreeNode root = BtMarker.deserialize();
		System.out.println("deserialize: " + root.left.right.right.val);
		
	}

}
