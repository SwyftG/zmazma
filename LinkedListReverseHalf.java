package oatwo;

import oatwo.ListNode;

public class LinkedListReverseHalf {
	/*
	 * Solution is to reverse second half of linked list.
	 * Return reversed linked head node.
	 * Use two pointer nodes find the middler position of linked list, 
	 * then reverse second half linkd list, and return head.
	 * Time complexity is O(n), space complexity is O(1).
	 * 
	 * @Param {ListNode} head - head node of linked list.
	 */
	public static ListNode Solution(ListNode head) {
		
		// Handle corner case.
		if (head == null || head.next == null) return head;
		
//		// Initialize two pointer nodes and find the middle position.
//		ListNode fast = head;
//		ListNode slow = head;
//		while (fast.next != null && fast.next.next != null) {
//			fast = fast.next.next;
//			slow = slow.next;
//		}
		
//		System.out.println(fast.val);
//		System.out.println(slow.val);
		
		
		int len = getLen(head);
		ListNode mid = head;
		for (int i = 0; i < len / 2 - 1; i++) {
			mid = mid.next;
		}
		
		// Initialized another two pointer nodes and reverse second half linked list.
		ListNode pre = mid.next;
		ListNode cur = pre.next;
		while (cur != null) {
			pre.next = cur.next;
			cur.next = mid.next;
			mid.next = cur;
			cur = pre.next;
		}
		
		return head;
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
		ListNode head = new ListNode(1);
		//head.add(2);
		//head.add(3);
		//head.add(4);
		//head.add(5);
		//head.add(6);
		Solution(head);
		//reverseList(head);
		head.printList(head);
		System.out.println();
	}
}
