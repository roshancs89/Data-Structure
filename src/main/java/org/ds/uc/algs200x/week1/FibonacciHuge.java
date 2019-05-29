package org.ds.uc.algs200x.week1;
import java.util.*;

public class FibonacciHuge {
   
    
    private static long gcd(long n, long m){
	
    	
    	if(n <= 1)
    		return n;
    	
    	long[] f = new long[(int) n];
    	int counter = 2;
    	
    	f[0] = 0l;
    	f[1] = 1l;
    	
    	while(true) {
    		f[counter] = (f[counter-1]+f[counter-2])%m;
    		
    		if(f[counter] == f[0])
    			break;
    		
    		counter++;
    		
    		
    	}
    	
    	
    	long val = n % counter;
    	
    	return f[(int) val];
	
	
	}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(gcd(n, m));
    }
}

