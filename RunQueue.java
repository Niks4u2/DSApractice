
public class RunQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QueueList queue = new QueueList();
		
		System.out.println("En");
		
		queue.enqueue(8);
		queue.enqueue(7);
		queue.enqueue(4);
		queue.enqueue(3);
		
		queue.dequeue();
		
		System.out.println(queue.front());
		
		System.out.println(queue.rear());

	}

}
