import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class test {
	
    public int findCenter(int[][] edges) {
        int[] count = new int[edges.length];
        int k = 0;
        for(int i = 0; i < edges.length; i++) {
		    for(int j = 0; j < edges.length; j++) {
				k += edges[i][j];
			}
         count[i] = k;
            k = 0;
    }
        Arrays.sort(count);
        return count[count.length - 1];
}
    
    static boolean isAnagram(String a, String b) 
    {
        // Complete the function
        a = a.toLowerCase();
        b = b.toLowerCase();
                
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Map<Character, Integer> map1 = new HashMap<Character, Integer>();


        for(int i = 0; i < a.length(); i++)
        {
        	if(map.get(a.charAt(i)) == null)
        	{
        		map.put(a.charAt(i), 1);
        	}
        	else
        	{
        		map.put(a.charAt(i), map.get(a.charAt(i))+1);
        	}
        }
        
        for(int j = 0; j < b.length(); j++)
        {
        	if(map1.get(b.charAt(j)) == null)
        	{
        		map1.put(b.charAt(j), 1);
        	}
        	else
        	{
        		map1.put(b.charAt(j), map1.get(b.charAt(j))+1);
        	}
        }
        
        return map.equals(map1);
    }

	public static void main(String[] args) 
	{
		/*
		System.out.println((char)(97));
		char c = 'b';
		String str = "";
		str.toLowerCase();
		str += c;
		System.out.println(str);
		
		int index = 5 + 'a';
		char ch = (char) (index);
		System.out.println(ch);
		*/
		
		System.out.println(isAnagram("Helllo","hello"));
	}

}
