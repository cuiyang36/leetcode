package Exercise;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeII {
	public List<TreeNodeII> neighbors;
	public String val;

	public TreeNodeII(String val) {
		this.val = val;
		neighbors = new ArrayList<TreeNodeII>();
	}
}
