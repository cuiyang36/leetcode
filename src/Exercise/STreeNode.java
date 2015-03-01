package Exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Suffix Tree Node
 * @author cuiyang36
 *
 */
public class STreeNode {

	public char val;
	public List<STreeNode>children;
	public STreeNode(char val){
		this.val = val;
		children = new ArrayList<STreeNode>();
	}
}
