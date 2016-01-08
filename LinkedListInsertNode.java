package oatwo;

import oatwo.ListNode;

/**
 * @author Gao
 *
 */
/**
 * @author Gao
 *
 */
public class LinkedListInsertNode {	// cnode wu gou zao qi.
	/*
	 * Solution is to insert a node in a cycle linked list.
	 * Return the new inserted node.
	 * Time complexity is O(n), space complexity is O(1).
	 * 
	 * @Param {ListNode} head - a node in a cycle linked list
	 */
	public static ListNode Solution(ListNode head, int target) {
		ListNode targetNode = new ListNode(target);
		
		// Handle base case.
		if (head == null || head.next == null) {
			head.next = targetNode;
			return targetNode;
		}
		
		// Use two pointer nodes to find the node with smallest value in cycle linked list.
		ListNode max = head;
		ListNode min = head.next;
		while (min.val >= max.val) {
			min = min.next;
			max = max.next;
		}
		
		// Case: if the targetNode is node with smallest value in cycle linked list.
		if (min.val > target) {
			max.next = targetNode;
			targetNode.next = min;
			return targetNode;
		}
		
		while (min.next.val < target) {
			min = min.next;
			if (min == max) break;
		}
		ListNode tmp = min.next;
		min.next = targetNode;
		targetNode.next = tmp;
		return targetNode;
	}
	
	
	public static ListNode Solution2(ListNode head, int target) {
		ListNode targetNode = new ListNode(target);
		if (head == null) {
			head.next = targetNode;
			return targetNode;
		}
		
		ListNode cur = head;
		
		do{
			if (target < cur.next.val && target >= cur.val) break;
			if (cur.val > cur.next.val && (target < cur.next.val || target > cur.val)) break;
			cur = cur.next;
		} while (cur != head);
		
		targetNode.next = cur.next;
		cur.next = targetNode;
		return targetNode;
	}
	
	
	
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.add(2);
		head.add(2);
		head.add(2);
		head.add(2);
		ListNode end =new ListNode(3);
		head.next.next.next.next.next = end;
		end.next = head;
		Solution2(head, 2);
		for (int i = 0; i < 7; i++) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	

}
