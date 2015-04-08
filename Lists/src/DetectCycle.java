
public class DetectCycle {
	
	  public boolean hasCycle(ListNode head) {
	        
	        ListNode slow = head;
	        ListNode fast = head;
	        
	        if( head ==null || head.next == null){
	            return false;
	        }
	        
	        while (slow!=null && fast!=null && fast.next!=null){
	            slow = slow.next;
	            fast=fast.next.next;
	            if(slow == fast){
	                return true;
	            }
	        }
	        
	        return false;
	        
	    }
	  
	  ListNode detectCycle(ListNode head) {
	        if (head == null){
	        	return null;
	        }
	        ListNode p=head;
	        ListNode q=head;
	        while (true){
	            if (p.next!= null){
	            	p=p.next;
	              }else{
	            	  return null;}
	            if (q.next!=null && q.next.next!=null){
	            	q=q.next.next;
	            }else{
	            	return null;
	            }
	            if (p==q){ //if find the loop, then looking for the loop start
	                q=head;
	                while (p!=q){
	                    p=p.next;
	                    q=q.next;
	                }
	                return p;
	            }
	        }
	    }

}
