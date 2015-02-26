package Exercise;

import java.util.Stack;

public class BSTInsert_findMsmallest {
    public final int data;
    public BSTInsert_findMsmallest left = null;
    public BSTInsert_findMsmallest right = null;

    public BSTInsert_findMsmallest(int data, BSTInsert_findMsmallest left, BSTInsert_findMsmallest right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BSTInsert_findMsmallest(int data) {
        this(data, null, null);
    }

    public String toString() {
        if (this.left == null && this.right == null) return "" + this.data;
        else {
            String lstr = (this.left == null) ? "_" : this.left.toString();
            String rstr = (this.right == null) ? "_" : this.right.toString();
            return "(" + lstr + " " + this.data + " " + rstr + ")";
        }
    }

    public static void main(String[] args) {
        BSTInsert_findMsmallest testBst = new BSTInsert_findMsmallest(8,
                              new BSTInsert_findMsmallest(3,
                                      new BSTInsert_findMsmallest(1),
                                      new BSTInsert_findMsmallest(6,
                                              new BSTInsert_findMsmallest(4),
                                              new BSTInsert_findMsmallest(7))),
                              new BSTInsert_findMsmallest(10,
                                      null,
                                      new BSTInsert_findMsmallest(14,
                                              new BSTInsert_findMsmallest(13),
                                              null)));
        System.out.println(testBst);
        // Prints: ((1 3 (4 6 7)) 8 (_ 10 (13 14 _)))

        testBst.insert(9);
        System.out.println(testBst);
        //Should print: ((1 3 (4 6 7)) 8 (9 10 (13 14 _)))

        testBst.insert(6);
        System.out.println(testBst);
        //Should print: ((1 3 (4 6 7)) 8 (9 10 (13 14 _)))

        testBst.insert(0);
        System.out.println(testBst);
        //Should print: (((0 1 _) 3 (4 6 7)) 8 (9 10 (13 14 _)))
        System.out.println("test");
        for (int i = 0; i <= 11; i++){
        	System.out.print(testBst.nthSmallest(i) + " ");
        }
    }

    /**
     * Inserts a new leaf node containing x as its data into this
     * tree, maintaining the invariant that all nodes to the left
     * are less than x, and all nodes to the right are greater than
     * x.
     *
     * Note: If the BST already contains x, do nothing
     */
    public void insert(int x) {
        BSTInsert_findMsmallest curr = this;
        BSTInsert_findMsmallest parent = this;
        boolean isLeft = true;
        while (curr != null){
        	if (curr.data > x){
        		isLeft = true;
        		parent = curr;
        		curr = curr.left;
        	}else if (curr.data < x){
        		isLeft = false;
        		parent = curr;
        		curr = curr.right;
        	}else{
        		return;
        	}
        }
        if (isLeft == false){
        	parent.right = new BSTInsert_findMsmallest(x);
        }else{
        	parent.left = new BSTInsert_findMsmallest(x);
        }
    }

    /**
     * Returns the value of the nth smallest node in this
     * binary search tree.
     */
    public int nthSmallest(int n) {
        int index = -1;
        int rst = -1;
        BSTInsert_findMsmallest root = this;
        Stack<BSTInsert_findMsmallest> stack =  new Stack<BSTInsert_findMsmallest>();
        while (index < n && (!stack.isEmpty() || root != null)){
        	if (root != null){
        		stack.push(root);
        		root = root.left;
        	}else{
        		root = stack.pop();
        		rst = root.data;
        		index += 1;
        		root = root.right;
        	}
        }
        if (index < n){
        	rst = -1;
        }
        return rst;
    }
}