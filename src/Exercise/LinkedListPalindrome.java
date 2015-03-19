package Exercise;

import java.util.Stack;

public class LinkedListPalindrome {
	
	public static boolean undestruct(ListNode node){
		if (node == null){
			return true;
		}
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> stack1 = new Stack<Integer>();
		while (node != null){
			stack.push(node.val);
			node = node.next;
		}
		int size = stack.size();
		for (int i = 0; i < size / 2; i++){
			stack1.push(stack.pop());
		}
		if (size % 2 == 1){
			stack.pop();
		}
		while (!stack.isEmpty()){
			if (stack.pop() != stack1.pop()){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		boolean rst = undestruct(node1);
		System.out.println(rst);
	}
}
