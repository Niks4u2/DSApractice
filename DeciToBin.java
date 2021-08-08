public class DeciToBin 
{
	public static void decimalToBin(int n)
	{
		String res = "";
		while(n > 0)
		{
			int rem = n % 2;
			if(rem == 0)
			{
				res += "0";
			}
			else
			{
				res += "1";
			}
			n = n / 2;
		}
		char[] ch = res.toCharArray();
		for(int i = 1; i <= ch.length; i++)
		{
			System.out.print(ch[ch.length - i]);
		}
	}
	
	public static void binaryToDeci(String bin)
	{
		int res = 0;
		char[] arr = bin.toCharArray();
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] == '1')
			{
				res += Math.pow(2, arr.length - i - 1);
			}
		}
		System.out.println(res);
	}
	
	
	public static void main(String[] args) 
	{
		//decimalToBin(70);
		binaryToDeci("11111111");
	}
}
