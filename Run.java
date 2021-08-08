public class Run {
	public static void main(String[] args) {
		        
		StackList stack = new StackList();
		
		System.out.println(stack.isEmpty());
		
		stack.pop();
		
		stack.push(5);
		stack.push(8);
		stack.push(6);
		stack.push(9);
		
		stack.pop();
		stack.pop();
		
		System.out.println(stack.isEmpty());
		
		System.out.println(stack.peek());

	}

}
