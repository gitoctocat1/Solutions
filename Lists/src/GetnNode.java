public class GetnNode {

	
	public static void main(String[] args) {
		ListNode headB = new ListNode(9);
		headB.next = new ListNode(8);
		headB.next.next = new ListNode(7);
		headB.next.next.next = new ListNode(5);
		headB.next.next.next.next = new ListNode(6);
		
		GetnNode n = new GetnNode();
		ListNode a = n.nthNodeFromEnd(headB, 2);
		System.out.println(a.val);
		
		while(a!=null){
			System.out.println(a.val);
			a = a.next;
		}
	}
	
	/**
	 * Complexity O(n)
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode nthNodeFromEnd(ListNode head, int n) {
		ListNode ptr1 = head;
		ListNode ptr2 = head;

		int count = 0;

		while (count <= n) {
			if (ptr2 == null) {
				// Not enough nodes , n greater than size of linked list
				return null;
			} else {
				ptr2 = ptr2.next;
				count++;
			}
		}

		// Now we iterate till ptr2 becomes NULL
		while (ptr2 != null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}

		ptr1.next = ptr1.next.next;
		
		// returning the required node
		return head;
	}

}
