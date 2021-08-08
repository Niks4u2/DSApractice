import java.util.*;

public class PrimeFactorisation 
{
	public static void primeNumber(int n)
	{
		boolean isPrime = true;
		
		for(int i = 2; i <= (int)Math.sqrt(n); i++)
		{
			if(n % i == 0)
				isPrime = false;
		}
		if(isPrime)
			System.out.println("Prime");
		else
			System.out.println("Composite");
	}
	
	public static void sieveOfEratos(int n) // to find all prime #s from 0 -> n
	{
		List<Integer> primes = new ArrayList<Integer>();
		
		for(int i = 0; i <= n; i++)
			primes.add(i, 1);
		
		primes.set(0, 0);
		primes.set(1, 0);
		
		for(int j = 2; j <= (int)Math.sqrt(n); j++)
		{
			if(primes.get(j) == 1)
			{
				for(int k = 2; k*j <= n; k++)
					primes.set(j*k, 0);
			}
		}
		
		for(int l = 0; l < primes.size(); l++)
		{
			if(primes.get(l) == 1)
				System.out.print(l+" ");
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//primeNumber(97);
		//System.out.println((int)Math.sqrt(9));
		sieveOfEratos(100);
	}

}
