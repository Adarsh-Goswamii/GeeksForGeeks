// Sort a stack

class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
	    Stack<Integer> stack= new Stack<>();
		while(!s.isEmpty())
		{
		    int curr= s.pop();
		    Stack<Integer> temp= new Stack<>();
		    
		    while(!stack.isEmpty() && stack.peek()>curr)
		        temp.push(stack.pop());
		        
		    stack.push(curr);
		    while(!temp.isEmpty())
		        stack.push(temp.pop());
		}
		return stack;
	}
}
