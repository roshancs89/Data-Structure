package org.ds.uc.algs200x.week1;
import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }
 
  //convention that gcd * lcm = num1 * num2
  // will be used here
  private static int gcd(int a ,int b){
   if(b == 0)
    	return a;
   
   return gcd(b, a%b);
  }
 
  private static long lcm(int a, int b){
   int gcd = gcd(a,b);
   
   long mulRes =(long) a * b;
   
   return  mulRes /  gcd;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
