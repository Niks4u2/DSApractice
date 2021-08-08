import java.util.*;

class BSTreeNode 
{
	int data;
	BSTreeNode left;
	BSTreeNode right;
	BSTreeNode(int data)
	{
		this.data = data;
	}
}
public class BST 
{
	BSTreeNode root;
	int val;
	
	public void insert(int value) 
	{
			root = insert(root, value);
	}
	
	public BSTreeNode insert(BSTreeNode root, int value) 
	{
		if(root == null) 
		{
			root = new BSTreeNode(value);
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
	
	public void inOrder(BSTreeNode root) 
	{
		if(root == null) 
		{
			return;
		}
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	
	public int max(BSTreeNode root) 
	{
		if(root.right == null) 
		{
			return root.data;
		}
		else 
		{
		  val = max(root.right);			
		}
		return val;
	}
	
	public BSTreeNode find(BSTreeNode root, int value) 
	{
		if(root == null || root.data == value) //base case
		{
			return root;
		}
		if(value < root.data)
			return find(root.left, value);
		else
			return find(root.right, value);			
	}
	
	public int findHeight(BSTreeNode root)
	{
		if(root == null)
			return -1;
		int left = findHeight(root.left);
		int right = findHeight(root.right);
		return (left > right ? left : right) + 1;
	}
	
	public void levelOrder(BSTreeNode root)
	{
		if(root == null)
			return;
		
		Queue<BSTreeNode> queue = new LinkedList<BSTreeNode>();
		
		queue.offer(root);
		
		while(!queue.isEmpty())
		{
			BSTreeNode temp = queue.poll();
			System.out.print(temp.data+" ");
			if(temp.left != null)
			 queue.offer(temp.left);
			if(temp.right != null)
				queue.offer(temp.right);
		}
	}
}
