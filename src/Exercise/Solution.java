package Exercise;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	
	/*
	 * Complete the function below.
	 */

	    public static class STreeNode {

		    public char val;
		    public Map<Character, STreeNode> value2child;
		    public STreeNode(char val){
			    this.val = val;
			    value2child = new HashMap<Character, STreeNode>();
		    }
	    }

	    public static long makeSuffixTree(String s){
			if (s == null || s.length() < 1){
				return 0;
			}
			long rst = 0;
			STreeNode root = new STreeNode(' ');
			Set<STreeNode> links = new HashSet<STreeNode>();
			links.add(root);
			for (int i = 0; i < s.length(); i++){
				char curr = s.charAt(i);
				Set<STreeNode> newLinks = new HashSet<STreeNode>();
				newLinks.add(root);
				for (STreeNode link: links){
					if (link.value2child.containsKey(curr)){
						newLinks.add(link.value2child.get(curr));
					}else{
						STreeNode node = new STreeNode(curr);
						rst += 1;
						link.value2child.put(curr, node);
						newLinks.add(node);
					}
				}
				links = new HashSet<STreeNode>(newLinks);
			}
			return rst;
		}

	    public static long substringCalculator(String st) {
	        if (st == null || st.length() < 1){
	            return 0;
	        }
	        long rst = makeSuffixTree(st);
	        return rst;
	    }
	    
	    public static void main(String[] args){
	    	String s = "";
	    	System.out.println(substringCalculator(s));
	    }

}
