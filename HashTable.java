class HashNode 
{
	Integer key;
	String value;
	HashNode next;
	
	HashNode(Integer key, String value) 
	{
		this.key = key;
		this.value = value;
	}
}

public class HashTable 
{		
	HashNode[] buckets;
	int numOfBucket;
	int size; //no. of key value pairs in HashTable
	
	HashTable(int capacity) 
	{
		this.numOfBucket = capacity;
		this.buckets = new HashNode[numOfBucket];
		this.size = 0;
	}
	
	public int getSize() 
	{
		return size;
	}
	
	public boolean isEmpty() 
	{
		return size == 0;
	}
	
	public int getBucketIndex(Integer key) 
	{
		return key % numOfBucket;
	}
	
	public void put(Integer key, String value) 
	{
		if(key == null || value == null) 
		{
			throw new IllegalArgumentException("Key or Value is null");
		}
		
		int index = getBucketIndex(key);
		HashNode head = buckets[index];
		
		while(head != null) 
		{
			if(head.key.equals(key)) 
			{
				head.value = value;
				return;
			}
			head = head.next;
		}
		
		size++;
		head = buckets[index];
		HashNode node = new HashNode(key, value);
		node.next = head;
		buckets[index] = node;
	}
	
	public String get(Integer key) 
	{
		int index = getBucketIndex(key);
		HashNode node = buckets[index];
		while(node.next != null) 
		{
			if(node.key == key) 
			{
				return node.value;
			}
			node = node.next;
		}
		return node.value;
	}
	
	HashNode previous = null;
	
	public String remove(Integer key) 
	{
		int index = getBucketIndex(key);
		HashNode node = buckets[index];
		
		if(node == null) 
		{
			return null;
		}
		
		while(node != null) 
		{
			if(node.key == key) 
			{
				break;
			}
			previous = node;
			node = node.next;
		}
		
		size--;
		if(previous != null) 
		{
			previous.next = node.next;
		}
		else 
		{
			buckets[index] = node.next;
		}
		return node.value;
	}

	public static void main(String[] args) 
	{		
		HashTable table = new HashTable(10);
		
		table.put(99, "Nik");
		table.put(5, "Rob");
		table.put(10, "Bob");
		table.put(9, "Cob");
		table.put(25, "Mob");
		table.put(25, "Sobb");
		
		System.out.println(table.get(25));
		System.out.println(table.remove(9));
		System.out.println(table.remove(9));
	}
}
