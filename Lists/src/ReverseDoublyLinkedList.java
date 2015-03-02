
 //Definition for singly-linked list.
   class DoublyLinkedListNode {
      int val;
      DoublyLinkedListNode next;
      DoublyLinkedListNode prev ;
      DoublyLinkedListNode(int x) {
          val = x;
          next = null;
          prev = null;
      }
  }
 

public class ReverseDoublyLinkedList {

	
	void reverse(DoublyLinkedListNode head)
	{
		DoublyLinkedListNode temp = null;  
		DoublyLinkedListNode current = head;
	      
	     /* swap next and prev for all nodes of 
	       doubly linked list */
	     while (current !=  null)
	     {
	       temp = current.prev;
	       current.prev = current.next;
	       current.next = temp;              
	       current = current.prev;
	     }      
	      
	     /* Before changing head, check for the cases like empty 
	        list and list with only one node */
	     if(temp != null )
	       head = temp.prev;
	}     
}
