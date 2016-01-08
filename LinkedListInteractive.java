package oatwo;



public class LinkedListInteractive {
	/*
	 * Solution is to get interactive of linked list.
	 * Return a list node which has interactived.
	 * Use two pointers listnode to get the middle position of linked list,
	 * divide original linked list into two lists, then merge two lists.
	 * Time complexity is O(n), space complexity is O(1).
	 * 
	 * @Param {ListNode} head - head node of linked list.
	 */
	public static ListNode Solution(ListNode head) {
		// Handle corner case.
		if (head == null || head.next == null) return head;
		
		// Get the lengh of linked list..
		int len = getLen(head);
		ListNode l2 = head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		ListNode l1 = dummy;
		
		// Get middle position of linked list and divided it into two parts.
		for (int i = 0; i < len / 2; i++) {
			l2 = l2.next;
			l1 = l1.next;
		}
		l1.next = null;
		l1 = dummy.next;
		int flag = 1;
		
		// Merge two lists in interactiving way.
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
	
	/*
	 * getLen is to get the length of linked list.
	 * Return an interge which is length.
	 */
	public static int getLen(ListNode head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
}
