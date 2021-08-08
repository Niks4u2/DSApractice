public class QueueList {

	Node front;
	Node rear;

	public void enqueue(int n) {
		
		Node node = new Node();

		node.data = n;
		node.next = null;

		if (front == null && rear == null) {
			front = node;
			rear = node;
		} else if (rear == front) {
			node.next = front;
			rear = node;
			front.next = rear;
		} else {
			node.next = rear;
			rear = node;
		}

	}
	
	public int front() {
		if(front == null) {
			System.out.println("No data");
		}else {
			return front.data;
		}
		return front.data;
	}
	
	public int rear() {
		if(rear == null) {
			System.out.println("No data");
		}else {
			return rear.data;
		}
		return rear.data;
	}
	
	public void dequeue() {
		front = front.next;
	}

}
