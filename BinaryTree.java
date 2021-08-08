class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
}


public class BinaryTree 
{
	TreeNode root;
	TreeNode previous;
	
	public void add(int n) 
	{
	TreeNode node = new TreeNode();
	
		node.data = n;
		node.left = null;
		node.right = null;
		
		if(root == null) 
		{
			root = node;
			previous = root;
		}
		else if(previous.left == null && n < previous.data ) 
		{
			previous.left = node;
			previous = node;
		}
		else if (previous.right == null && n > previous.data) 
		{
			previous.right = node;
			previous = node;
		}
	}
	
	public void preOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void inOrder(TreeNode root) 
	{
		if(root == null) 
		{
			return;
		}
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	
}
