package testforfun;

public class LinkedListLoop {
	public static boolean findLoop(ListNode head) {
		if (head == null || head.next == null) return false;
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) return true;
		}
		return false;
	}
	
	
	public static ListNode detectLoop(ListNode head) {
		if (head == null || head.next == null) return null;
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)  break;
		}
		if (fast == null || fast.next == null) return null;
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode start = new ListNode(3);
		head.add(2);
		head.next.next = start;
		start.add(4);
		start.add(5);
		ListNode end = new ListNode(6);
		start.next.next.next = end;
		end.next = start;
		ListNode node = detectLoop(head);
		System.out.println(findLoop(head) + "  " + node.val);
	}
}
