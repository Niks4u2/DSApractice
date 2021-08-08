import java.util.*;

public class StringMatching {
	
	public static void naiveSearch(String pat, String text) 
	{
		int n = text.length();
		int m = pat.length();
		//Best case- O(n*m), Worst case- O([n-m+1]*n)
		
		for(int i = 0; i < n-m+1; i++)
		{
			int j = 0;
			for(j = 0; j < m; j++)
			{
				if(text.charAt(i+j) != pat.charAt(j))
					break;
			}
			if(j==m)
			{
				System.out.println("Matching Found at index:"+i);
			}
		}
	}
	
	public static void boyerMoore(String pat, String text)//
	{
		// Declaring variables
		int n = text.length();
		int m = pat.length();
		int k = 0, j = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		//Creating bad match table
        for(int i = 0; i < pat.length(); i++)
        {
        	map.put(pat.charAt(i), Math.max(1, m-i-1));
        }
        
        while(true)
        {
			for(k = m - 1; k >= 0; --k)//checking the pattern from right to left
			{
				if(pat.charAt(k) != text.charAt(k+j))//if pattern not found
				{
					if(map.containsKey(pat.charAt(k)))
						j += map.get(pat.charAt(k));//shifting value of j taking data from bad match table
					else
						j += m;
					break;
				}
			}
			if(k==-1)//condition when the for loop completes i.e. pattern is found
			{
				System.out.println("Matching Found at index:"+j);
				break;
			}
			if(j >= n - m)//exit condition if pattern not found
			{
				System.out.println("Pattern Not Found");
				break;
			}
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boyerMoore("aba", "abddaa");
		
	}

}
