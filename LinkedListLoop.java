package oatwo;

public class LinkedListLoop {
	/*
	 * Solution is to find whether there is a cycle in Linked list.
	 * Return boolean value, true means there exist cycle, otherwise return false.
	 * Use two pointer nodes to go through linked list in different pace. If they are meeting,
	 * there exists a cycle, return true. Otherwise return false.
	 * Time complexity is O(n), space complex is O(1).
	 * 
	 * @Param {ListNode} head - the head node of linked list.
	 */
	public static boolean Solution(ListNode head) {
		
		// Handle illegal input
		if (head == null || head.next == null) return false;
		
		// Initialize two pointer nodes
		ListNode fast = head;
		ListNode slow = head;
		
		// Two nodes go through the linked list. 
		// Fast node moves 2 pace while slow node move 1 pace.
		// When they are meeting, return true, means there exists a cycle.
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) return true;
		}
		
		return false;
	}
	
	/*
	 * detectCycle is to find the start node of cycle in linked list
	 * Return the start cycle node.
	 * Use two pointer nodes to go through linked list in different pace. 
	 * After they meet, set one node to be head node, and go through linked list in same pace.
	 * When they meet second time, the meeting node is the start node.
	 * Time complexity is O(n), space complex is O(1).
	 * 
	 * @Param {ListNode} head - the head node of linked list
	 */
	public static ListNode detectCycle(ListNode head) {
		
		// Handle illegal input
		if (head == null || head.next == null) return null;
		
		// Initialized two pointer nodes
		ListNode fast = head;
		ListNode slow = head;
		
		// Go through the linked list in different pace.
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) break;
		}
		
		// To check whether fast node reached the end, 
		// if it is, then return null, means there is no cycle.
		if (fast == null || fast.next == null) return null;
		
		// Set slow node to head node, and go through linked list in same pace.
		slow = head;
		while (slow != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
}
