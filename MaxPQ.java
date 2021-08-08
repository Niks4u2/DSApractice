public class MaxPQ 
{
	Integer[] heap;
	int size;
	
	MaxPQ(int capacity) 
	{
		this.heap = new Integer[capacity + 1]; // index 0 is kept as empty
		this.size = 0;
	}
	
	boolean isEmpty() 
	{
		return size == 0;
	}
	
	public int size() 
	{
		return size;
	}
	
	public void insert(int x) 
	{
		if(size == heap.length -1) 
		{
			resize(2 * heap.length);
		}
		size++;
		heap[size] = x;
		swim(size);
	}
	
	public void swim(int k) 
	{
		while(k > 1 && heap[k/2] < heap[k]) 
		{
			int temp = heap[k];
			heap[k] = heap[k/2];
			heap[k/2] = temp;
			k = k/2;
		}
	}
	
	public void resize(int capacity) 
	{
		Integer[] newHeap = new Integer[capacity];
		for(int i = 1; i < heap.length; i++ ) 
		{
			newHeap[i] = heap[i];
		}
		heap = newHeap;
	}
	
	public void show() 
	{
		for(int i = 1; i < heap.length; i++) 
		{
			if(heap[i] != null)
				System.out.print(heap[i]+" ");
		}
	}
	
	public Integer getMax()
	{
		return heap[1];
	}
	
	public void deleteMax()
	{
		for(int i = 1; i < heap.length - 1; i++ ) 
		{
			if( heap[i] != null)
				heap[i] = heap[i+1];
		}
	}

	public static void main(String[] args) 
	{
		MaxPQ pq = new MaxPQ(11);
		System.out.println(pq.isEmpty());
		System.out.println(pq.size());
		
		pq.insert(4);
		pq.insert(5);
		pq.insert(9);
		pq.insert(2);
		pq.insert(8);
		pq.insert(55);
		pq.insert(15);
		pq.insert(11);
		pq.insert(19);
		pq.insert(13);
		pq.insert(21);

		System.out.println(pq.isEmpty());
		System.out.println(pq.size());
		System.out.println();
		//pq.show();
		
		System.out.println(pq.getMax());
		pq.show();
		System.out.println();
		//System.out.println(pq.getMin());
		pq.deleteMax();
		System.out.println(pq.getMax());
		pq.show();
	}

}
