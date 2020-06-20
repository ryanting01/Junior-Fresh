import java.util.Arrays;
import java.util.Scanner;

public class SieveOfEratosthenes {
	
	public static int [] createSequence (int N, int [] sequence) {
		
		sequence = new int[N - 1];
		
		int i = 0;
		int count = 2;
		
		while(i < N - 1)
		{
			sequence[i] = count;
			i++;
			count++;
		}
		
		
		return sequence;
	}
	
	public static boolean [] crossOutHigherMultiples (int n, int [] sequence, boolean [] crossedOut) {
		
		int i = 0;
		
		while(i < crossedOut.length - 1)
		{
		
			if(sequence[i] % n == 0)
			{
				crossedOut[i] = false;
			}
			i++;
		}
		
		return crossedOut;
		
	}
	
	public static int [] sieve (int n, int [] sequence) {
		
		boolean [] crossedOut = new boolean[sequence.length];
		
		int i = 0;
		
		while(i < crossedOut.length - 1)
		{
			crossedOut[i] = true;
			i++;
		}
		
		i = 0;
	
		crossedOut = crossOutHigherMultiples (n, sequence, crossedOut);
		
		while(i < sequence.length)
		{
			if(crossedOut[i] == false && sequence[i] != 0 && sequence[i] != n)
			{
				sequence[i] = 0;
			}
			i++;
		}
				
		return sequence;
	}
	
	public static String sequenceToString (int [] sequence) {
		
		String result = "";
		
		int i = 0;
		
		while(i < sequence.length)
		{
		
			if(sequence[i] > 0)
			{
				result += sequence[i];
				
				if(i != sequence.length - 1)
				{
					result += ", ";
				}
			}
			if(sequence[i] == 0)
			{
				result += "[" + (i + 2) + "]";
				
				if(i != sequence.length - 1)
				{
					result += ", ";
				}
			}
		i++;
		}
		
		
		return result;
	}
	
	public static String nonCrossedOutSubseqToString (int [] sequence)
	{

		String primes1 = "";
		
		int i = 0;
		
		while(i < sequence.length)
		{
			if(sequence[i] > 0)
			{
				primes1 += sequence[i];
				
				if(i != sequence.length)
				{
					primes1 += ", ";
				}
			}
		i++;
		}
		
		char[] primesArray = primes1.toCharArray(); 
		
		primesArray[primesArray.length - 2] = 32;
		
		String primes = new String(primesArray); 
		
		
		return primes;
	}
	

	public static void main(String[] args) {
		
		int n = 2;
		
		String result = null;
		
		String primes = null;
		
		System.out.println("To what numbers would you want to find the primes of?");
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();

		
		
		
		
		int [] sequence = null;
		sequence = createSequence(N, sequence);
		
		while(n < N)
		{
			sequence = sieve(n, sequence);
			
			result = sequenceToString(sequence);
			
			n++;
		}
		
		
		System.out.println(result);
		
		primes = nonCrossedOutSubseqToString(sequence);
		
		System.out.println("Primes: " + primes);
		
		
		
	}


}

/* SELF ASSESSMENT  
1.  createSequence:
Did I use the correct method definition?
Mark out of 5:5
Comment:I did it correctly
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5:5
Comment:Yes, i created the correct array and initialized it correctly
Did I return the correct item?
Mark out of 5:5
Comment:Yes, i returned the correct item
2.  crossOutMultiples
Did I use the correct method definition?
Mark out of 5:5
Comment:I did it correctly
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2:1
Comment:I used a valid index into the array
Did I loop through the array using the correct multiple?
Mark out of 5:5
Comment:Yes, i looped it using the correct multiple
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3:3
Comment:Yes, I crossed the correct items
3.  sieve   
Did I have the correct function definition?
Mark out of 5:5
Comment:I did it correctly
Did I make calls to other methods?
Mark out of 5:5
Comment:      Yes, i called other methods
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2:0
Comment:No, i did not
4.  sequenceTostring  
Did I have the correct function definition?
Mark out of 5:5
Comment:I did it correctly
Did I ensure the parameter to be used is not null?
Mark out of 3:3
Comment: Yes it is not null
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10:10
Comment:    Yes, i looped through the array while updating the string
5.  nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5:5
Comment:       I did it correctly 
Did I ensure the parameter to be used is not null?  
Mark out of 3:3
Comment:I did it correctly
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5:5
Comment:    Yes, i looped through the array while updating the string
6.  main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5:5
Comments: Yes, i did
Did I make calls to other methods (at least one)?
Mark out of 5:5
Comment:  Yes, i called multiple methods
Did I print the output as shown in the question?  
Mark out of 5:5
Comment:  Yes, my output was correct
7.  Overall
Is my code indented correctly?
Mark out of 4:4
Comments:Yes
Do my variable names make sense?
Mark out of 4:4
Comments:Yes
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4:4
Comments:Yes it does
   Total Mark out of 100 (Add all the previous marks):  97
*/





