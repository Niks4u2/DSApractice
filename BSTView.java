import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class TNode
{
	int data;
	int height;
	TNode right;
	TNode left;
	
	TNode(int data)
	{
		this.data = data;
	}
}


public class BSTView 
{
	
	static TNode root;
	
	public void insert(int value) 
	{
			root = insert(root, value);
	}
	
	public TNode insert(TNode root, int value) 
	{
		if(root == null) 
		{
			root = new TNode(value);
			return root;
		}
		if(value < root.data) 
		{
			root.left = insert(root.left, value);
		}
		else 
		{
			root.right = insert(root.right, value);
		}
		return root;
	}
	
	public void inOrder(TNode root) 
	{
		if(root == null) 
		{
			return;
		}
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	
	
	public void topView(TNode root)
	{
		if(root == null) //base case
			return;
		
		Queue<TNode> queue = new LinkedList<TNode>();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		queue.offer(root);
		
		while(!queue.isEmpty())
		{
			TNode temp = queue.poll();
			int hd = temp.height;
			
			if(map.get(hd) == null)
				map.put(hd, temp.data);
			
			if(temp.left != null)
			{
				temp.left.height = hd - 1;
				queue.offer(temp.left);
			}
			if(temp.right != null)
			{
				temp.right.height = hd + 1;
				queue.offer(temp.right);
			}
		}
		System.out.println(map.values());
	}
	
	
	public static void main(String[] args) 
	{
		BSTView bst = new BSTView();
		
		bst.insert(1);
		bst.insert(2);
		bst.insert(5);
		bst.insert(3);
		bst.insert(6);
		bst.insert(4);
		
		
		bst.topView(root);
		
		bst.inOrder(root);

	}
}
