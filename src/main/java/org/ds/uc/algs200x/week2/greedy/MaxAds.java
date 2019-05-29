package org.ds.uc.algs200x.week2.greedy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Greedy logic to get the maximum revenue from ads
 * @author Roshan
 * Input:
 * 31
 * 3
 * -5-2 4 1
 * Output:
 * 2323 = 3·4 + 1·1 + (−5)·(−2)
 */
public class MaxAds {
	
	static Comparator<Integer> byDescNum = new Comparator<Integer>() {

		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2.compareTo(o1);
		}
	};

	public static void main(String args[]) {
		
		//Scanner sc = new Scanner("/Users/Roshan/Downloads/3_3_dot_product20180216.in");
		Scanner sc = new Scanner(System.in);
		
		int totalAds = sc.nextInt();
		int counter = 0;
		List<Integer> profitPerClick = new ArrayList<Integer>();
		List<Integer> avgClickPerSlot = new ArrayList<Integer>();
		
		long start = System.currentTimeMillis();
		
		while(counter++ < totalAds && sc.hasNextInt()) {
			profitPerClick.add(sc.nextInt());
		}
		
		counter = 0;
		
		while(counter++ < totalAds && sc.hasNextInt()) {
			avgClickPerSlot.add(sc.nextInt());
		}
		
		Collections.sort(profitPerClick, byDescNum);
		Collections.sort(avgClickPerSlot, byDescNum);
		
		System.out.println(calculateMaxRevenue(profitPerClick, avgClickPerSlot));
		System.out.println("Total time taken "+ (System.currentTimeMillis() - start)+" ms");
	}
	
	private static BigInteger calculateMaxRevenue(List<Integer> profitPerClick, List<Integer> avgClickPerSlot) {
		
		BigInteger sum = new BigInteger("0");
		
		for(int i = 0; i < profitPerClick.size();i++) {
			BigInteger a = new BigInteger((String.valueOf(profitPerClick.get(i))));
			BigInteger b = new BigInteger((String.valueOf(avgClickPerSlot.get(i))));
			sum = sum.add(a.multiply(b));
		}
		
		return sum;
		
		
	}
}
