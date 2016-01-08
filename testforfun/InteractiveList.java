package testforfun;

public class InteractiveList {
	public static ListNode Solution(ListNode head) {
		if (head == null || head.next == null) return head;
		int len = getLen(head);
		ListNode l2 = head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		ListNode l1 = dummy;
		for (int i = 0; i < len / 2; i++) {
			l2 = l2.next;
			l1 = l1.next;
		}
		l1.next = null;
		l1 = dummy.next;
		int flag = 1;
		while (l1 != null && l2 != null) {
			if (flag == 1) {
				flag = 2;
				head.next = l1;
				l1 = l1.next;
			} else {
				flag = 1;
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;
		}
		if (l2 != null) head.next = l2;
		return dummy.next;
	}
	
	public static int getLen(ListNode head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
	
	
	
	
	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		head1.add(2);
		head1.add(3);
		head1.add(4);
		head1.add(5);
		head1.add(6);
		
		ListNode mm = Solution(head1);
		//reverseList(head);
		mm.printList(mm);
		System.out.println();
	}
}
