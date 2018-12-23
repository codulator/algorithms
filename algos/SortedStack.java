class SortedStack {
	public Stack<Integer> sort(Stack<Integer> s)
	{
		Stack<Integer> tmpStack = new Stack();
		while(!s.isEmpty()) {
		    Integer tmp = s.pop();
		    while(!tmpStack.isEmpty() && tmpStack.peek() < tmp) {
		        s.push(tmpStack.pop());
		    }
		    tmpStack.push(tmp);
		}
		
		while(!tmpStack.isEmpty()) {
		    s.push(tmpStack.pop());
		}
		return s;
	}
}
