package Exercise;

public class Flatten2DLinkedList {
	/**
	 * append node to the next node of the dynamic tail
	 * @param head
	 */
	public static void flatten2DLinkedListMethod1(ListNode2D head){
		if (head == null){
			return;
		}
		ListNode2D tail = head;
		while (tail.next != null){
			tail = tail.next;
		}
		ListNode2D curr = head;
		while (curr != null){
			// append child
			if (curr.child != null){
				tail = appendMethod1(curr.child, tail);
			}
			curr = curr.next;
		}
		return;
	}
	
	private static ListNode2D appendMethod1(ListNode2D child, ListNode2D tail){
		// append child to the next node of the tail
		tail.next = child;
		child.prev = tail;
		// update the tail to the new tail of the child
		while (tail.next != null){
			tail = tail.next;
		}
		// update tail, tail is refered to another project
		return tail;
	}

	
	public static void unflatten2DLinkedListMethod1(ListNode2D head){
		if (head == null){
			return;
		}
		separateMethod1(head);
	}
	
	private static void separateMethod1(ListNode2D head){
		while (head != null){
			if (head.child != null){
				//System.out.println(head.child.val);
				if (head.child.prev != null){
					head.child.prev.next = null;
					head.child.prev = null;
				}	
				separateMethod1(head.child);
			}
			head = head.next;
		}
	}
	
	
	/**
	 * insert node's child into this node's next
	 * @param head
	 */
	public static void flatten2DLinkedListMethod2(ListNode2D head){
		if (head == null){
			return;
		}
		appendMethod2(head);
	}
	
	/**
	 * return the tail of the current LinkedList
	 * @param head
	 * @return
	 */
	private static ListNode2D appendMethod2(ListNode2D head){
		ListNode2D curr = head;
		ListNode2D prev = head;
		while (curr != null){
			ListNode2D next = curr.next;
			if (curr.child != null){
				curr.next = curr.child;
				curr.child.prev = curr;
				ListNode2D tail = appendMethod2(curr.child);
				if (next != null){
					tail.next = next;
					next.prev = tail;
				}else{
					// a little tricky here
					next = tail;
				}
			}
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	
	public static void main(String[] args){
		ListNode2D one = new ListNode2D(1);
		ListNode2D two = new ListNode2D(2);
		ListNode2D three = new ListNode2D(3);
		ListNode2D four = new ListNode2D(4);
		ListNode2D five = new ListNode2D(5);
		ListNode2D six = new ListNode2D(6);
		ListNode2D seven = new ListNode2D(7);
		ListNode2D eight = new ListNode2D(8);
		ListNode2D nine = new ListNode2D(9);
		ListNode2D ten = new ListNode2D(10);
		ListNode2D eleven = new ListNode2D(11);
		ListNode2D twelve = new ListNode2D(12);
		ListNode2D thirteen = new ListNode2D(13);
		one.next = two;
		two.prev = one;
		two.next = three;
		three.prev = two;
		three.next = four;
		four.prev = three;
		five.next = six;
		six.prev = five;
		six.next = seven;
		seven.prev = six;
		eight.next = nine;
		nine.prev = eight;
		twelve.next = thirteen;
		thirteen.prev = twelve;
		one.child = five;
		four.child = eight;
		eight.child = twelve;
		six.child = ten;
		seven.child = eleven;
		flatten2DLinkedListMethod1(one);
		//ListNode2D head2 = flatten2DLinkedListMethod2(one);
		System.out.println("Flatten Method 1");
		ListNode2D head1 = one;
		while (head1 != null){
			System.out.print(head1.val + " ");
			head1 = head1.next;
		}
		System.out.println("\nUnflatten Method 1");
		unflatten2DLinkedListMethod1(one);
		ListNode2D head1_1 = one;
		while (head1_1 != null){
			System.out.print(head1_1.val + " ");
			head1_1 = head1_1.next;
		}
//		System.out.println("Flatten Method 2");
//		while (head2 != null){
//			System.out.print(head2.val + " ");
//			head2 = head2.next;
//		}
	}
}
