import java.util.Map;
import java.util.TreeMap;

public class RunBT 
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		BinaryTree bt = new BinaryTree();
		
		bt.add(9);
		bt.add(5);
		bt.add(2);
		bt.add(11);
		bt.add(3);
		bt.add(16);
		bt.add(26);
		bt.add(86);
		bt.add(66);
		bt.add(76);
		bt.add(96);
		bt.add(1);
		
		
		bt.inOrder(bt.root);
		
		System.out.println();
		
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		map.put(1, 5);
		map.put(2, 10);
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet())
			System.out.println(entry.getValue()+" ");
		
	}
}
