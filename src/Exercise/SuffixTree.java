package Exercise;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * General Suffix Tree class, can make suffix tree according to
 * input String, I/O contains STreeNode class
 * @author cuiyang36
 *
 */
public class SuffixTree {
	public static final char STARTMARKER = '^';
	public static final char ENDMARKER = '$';
	
	public static STreeNode makeSuffixTree(String s){
		if (s == null || s.length() < 1){
			return null;
		}
		STreeNode root = new STreeNode(STARTMARKER);
		Set<STreeNode> links = new HashSet<STreeNode>();
		links.add(root);
		for (int i = 0; i < s.length(); i++){
			Set<STreeNode> newLinks = new HashSet<STreeNode>();
			newLinks.add(root);
			for (STreeNode link: links){
				boolean isExist = false;
				STreeNode existNode = null;
				for (STreeNode child: link.children){
					if (child.val == s.charAt(i)){
						isExist = true;
						existNode = child;
					}
				}
				if (!isExist){
					STreeNode node = new STreeNode(s.charAt(i));
					link.children.add(node);
					newLinks.add(node);
				}else{
					newLinks.add(existNode);
				}
			}
			links = new HashSet<STreeNode>(newLinks);
		}
		for (STreeNode link: links){
			link.children.add(new STreeNode(ENDMARKER));
		}
		return root;
	}
	
	public static int numberOfNode(STreeNode root){
		int rst = 0;
		if (root == null){
			return rst;
		}
		Stack<STreeNode> stack = new Stack<STreeNode>();
		stack.push(root);
		while (!stack.isEmpty()){
			STreeNode curr = stack.pop();
			if (!(curr.val + "").matches("[/^/$]")){
				rst += 1;
			}
			for (STreeNode child: curr.children){
				stack.push(child);
			}
		}
		return rst;
	}
	
	public static String serialize(STreeNode root){
		StringBuffer sb = new StringBuffer();
		if (root == null){
			return sb.toString();
		}
		Stack<STreeNode> stack = new Stack<STreeNode>();
		stack.push(root);
		while (!stack.isEmpty()){
			STreeNode curr = stack.pop();
			sb.append(curr.val + " ");
			for (STreeNode child: curr.children){
				stack.push(child);
			}
		}
		return sb.toString().trim();
	}
	
	public static void main(String[] args){
		String rst = serialize(makeSuffixTree("xtpxtd"));
		System.out.println(rst);
		int num = numberOfNode(makeSuffixTree("xtpxtd"));
		System.out.println(num);
	}

}
