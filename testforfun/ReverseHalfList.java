package testforfun;

public class ReverseHalfList {
	
	public static ListNode reverseHalfList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		ListNode pre = slow.next;
		ListNode cur = pre.next;
		while (cur != null) {
			pre.next = cur.next;
			cur.next = slow.next;
			slow.next = cur;
			cur = pre.next;
		}
		
//		ListNode pre = null;
//		ListNode cur = slow.next;
//		while (cur != null) {
//			ListNode next = cur.next;
//			cur.next = pre;
//			pre = cur;
//			cur = next;
//		}
		//slow.next = pre;
		return head;
	}
	
	 
	
	
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.add(2);
		head.add(3);
		head.add(4);
		head.add(5);
		head.add(6);
		reverseHalfList(head);
		//reverseList(head);
		head.printList(head);
		System.out.println();
	}
}
