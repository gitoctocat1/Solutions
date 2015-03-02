
public class ReverseLinkedList {
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		ReverseLinkedList list = new ReverseLinkedList();
		list.reverseLinkedList(head);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
		
	}

	
	public ListNode reverseLinkedList(ListNode head){
		ListNode curr = head, prev = null;
		
		if(head == null){
			return head;
		}
		
		while(curr != null){
			curr = curr.next;
			curr.next = prev;
			prev = curr;
			
		}
		return head;
	}
	
}
