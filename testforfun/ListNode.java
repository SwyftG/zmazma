package testforfun;


public class ListNode {
	int val;
	ListNode next;
	public ListNode(int x) { 
		val = x;
		this.next = null;
	}
	
	  public void add(int x) {
          ListNode end = new ListNode(x);
          ListNode cur = this;
          while (cur.next != null) {
               cur = cur.next;
          }
          cur.next = end;
     }
	  
	  public void printList(ListNode head) {
			while (head != null) {
				System.out.print(head.val + " ");
				head = head.next;
			}
		} 

}
