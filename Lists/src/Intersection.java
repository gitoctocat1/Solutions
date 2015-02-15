import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;


public class Intersection {
	
	public static void main(String[] args) {
		
		ListNode headA = new ListNode(10);
		
		ListNode temp = new ListNode(3);
		headA.next = temp;
		//headA.next.next = new ListNode(4);
		//headA.next.next.next = new ListNode(5);
		
		ListNode headB = new ListNode(9);
		headB.next = new ListNode(8);
		headB.next.next = temp;
		//headB.next.next.next = new ListNode(4);
		//headB.next.next.next.next = new ListNode(5);
		
	
		System.out.println(getIntersectionNode(headA, headB).val);
	}
	
	/**
	 * Complexity O(n) 
	 * SImilar to finding LCA of two nodes with parent pointers
	 * @param headA
	 * @param headB
	 * @return
	 */
	 public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        
	        if(headA == null || headB==null){
	            return null;
	        }
	        
	        int length1 = getLength(headA);
	        int length2 = getLength(headB);
	        
	        int diff = Math.abs(length1- length2);
	        
	        for (int i = 0; i < diff ; i++){
	            
	            if(length1 > length2){
	                
	                headA = headA.next;
	                
	            } else {
	                headB = headB.next;
	            }
	        }
	        
	        while (headA != null && headB != null){
	            
	            if(headA == headB){
	                return headA;
	            }
	            headA = headA.next;
	            headB = headB.next;
	        }
	        
	        return null;
	        
	    }
	    
	 /**
	  * Get length of both lists
	  * @param head
	  * @return
	  */
	    public static int getLength(ListNode head){
	        
	        int count = 0;
	        
	        if(head == null){
	            return count;
	        }
	        
	        while (head != null){
	            head = head.next;
	            count ++;
	        }
	        
	        return count;
	    }

}
