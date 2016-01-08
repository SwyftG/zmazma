package testforfun;

public class InsertNodeInList {
	public static void Solution(ListNode head, int target) {
		ListNode targetNode = new ListNode(target);
		if (head == null || head.next == null) {
			head.next = targetNode;
			return;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast.val >= slow.val) {
			fast = fast.next;
			slow = slow.next;
		} 
		if (fast.val > target) {
			slow.next = targetNode;
			targetNode.next = fast;
			return;
		}
		while (fast.next.val < target) {
			fast = fast.next;
			if (fast == slow) break;
		}
		ListNode tmp = fast.next;
		fast.next = targetNode;
		targetNode.next = tmp;
		return;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.add(4);
		head.add(4);
		head.add(4);
		head.add(6);
		ListNode end =new ListNode(12);
		head.next.next.next.next.next = end;
		end.next = head;
		Solution(head, 3);
		for (int i = 0; i < 7; i++) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}
