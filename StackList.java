class Node {
	
	int data;
	Node next;

}

public class StackList{
	
	Node top;
	Node temp;
	
	public void push(int n) {
		
		Node node = new Node();
		node.data = n;
		node.next = null;
		
		if(top == null) {
			top = node;
		}else {
			temp = top;
			top = node;
			node.next = temp;
		}

	}
	
	public boolean isEmpty() {
		if(top == null) {
			return true;
		}
		return false;
	}
	
	public void pop() {
		if(top == null) {
			System.out.println("Stack is Empty");
		}else {
			top = top.next;
		}
	}
	
	public int peek() {
		return top.data;
	}

}
