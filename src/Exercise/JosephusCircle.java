package Exercise;

/**
 * 有n个囚犯站成一个圆圈，准备处决。首先从一个人开始，
 * 越过k-2个人（因为第一个人已经被越过），并杀掉第k个人。
 * 接着，再越过k-1个人，并杀掉第k个人。这个过程沿着圆圈一直进行，
 * 直到最终只剩下一个人留下，这个人就可以继续活着。
 * @author cuiyang36
 *
 */
public class JosephusCircle {
	
	public static ListNode createCycle(int length){
		if (length < 1){
			return null;
		}
		ListNode head = new ListNode(0);
		ListNode tail = head;
		for (int i = 1; i < length; i++){
			tail.next = new ListNode(i);
			//System.out.println(tail.next.val + " created");
			tail = tail.next;
		}
		tail.next = head;
		//System.out.println(tail.val);
		//System.out.println(tail.next.val);
		return tail;
	}
	
	public static ListNode killToOne(int length, int k){
		ListNode tail;
		tail = createCycle(length);
		if (k <= 0 || tail == null){
			return null;
		}
		k -= 1;
		ListNode curr = tail;
		while (length > 1){
			int num = k % length;
			while (num > 0){
				curr = curr.next;
				num -= 1;
			}
			System.out.println("kill: " + curr.next.val);
			curr.next = curr.next.next;
			length -= 1;
		}
		return curr;
	}
	
	public static void main(String[] args){
		ListNode rst = killToOne(1000, 10);
		System.out.println(rst.val + " left!");
	}

}
