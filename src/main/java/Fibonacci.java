import java.util.Scanner;

public class Fibonacci {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(calc_fib(n));
	}
	
	/**
	 * Calculates the last digit of fibonacci number
	 * @param n number for which fibonacci series result have to be submitted.
	 * @return last digit of fibonacci series value at n.
	 */
	private static int calc_fib(int n) {
		
		int[] fib = new int[n+1];
		
		if(n == 0)
			return 0;
		
		fib[0]= 0;
		fib[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			fib[i] = (fib[i-1]+fib[i-2])%10;
		}
		
		return  fib[n];
		
		
	}

}
