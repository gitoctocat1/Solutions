import java.util.Stack;


public class MinStack {
    
	/**
	 * Complexity O(1) for push, pop and get min
	 */
	
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x<= minStack.peek()){
            minStack.push(x);
        }
        
    }

    public void pop() {
        if( stack.pop().equals(minStack.peek()))
         minStack.pop();
    }

    public int top() {
        return stack.peek();
        
    }

    public int getMin() {
        return minStack.peek();
    }
}
