
public class RunBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BST bst = new BST();
		
		bst.insert(10);
		bst.insert(5);
		bst.insert(4);
		bst.insert(9);
		bst.insert(2);
		bst.insert(7);
		
				
		bst.inOrder(bst.root);
		
		System.out.println();
		
		//System.out.println(bst.max(bst.root));
		System.out.println(bst.findHeight(bst.root));
		
		if(bst.find(bst.root, 10) != null)
			System.out.println("Key Found");
		else
			System.out.println("Key Not Found");
		
		
		bst.levelOrder(bst.root);
	}

}
