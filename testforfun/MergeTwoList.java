package testforfun;

public class MergeTwoList {
	public static ListNode mergeTwo(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) return null;
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				node.next = l1;
				l1 = l1.next;
			} else {
				node.next = l2;
				l2 = l2.next;
			}
			node = node.next;
		}
		if (l1 != null) node.next = l1;
		if (l2 != null) node.next = l2;
		return dummy.next;
	}
	
	
	
	
	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		head1.add(3);
		head1.add(5);
		head1.add(7);
		ListNode head2 = new ListNode(2);
		//head2.add(4);
		//head2.add(6);
		head2.add(8);
		
		ListNode mm = mergeTwo(head1, head2);
		//reverseList(head);
		mm.printList(mm);
		System.out.println();
	}
}
