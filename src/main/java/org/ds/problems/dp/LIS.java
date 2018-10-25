package org.ds.problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.management.AttributeNotFoundException;

/**
 * This is one of problems of Dynamic Programming model
 * where largest possible sequence in ascending order
 * have to be found out.
 * 
 * Sample 
 * 
 * Input : arr[] = {50, 3, 10, 7, 40, 80}
 * Output : Length of LIS = 4
 * The longest increasing subsequence is {3, 7, 40, 80}

 *  Reference: https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 *  
 * @author Roshan
 *
 */
public class LIS {
	
	public static void main(String args[]) {
		LIS lis = new LIS();
		Integer[] listVal = new Integer[]{3, 10, 2, 1, 20};
		List<Integer> seqList = Arrays.asList(listVal);
		try {
			System.out.println(lis.getLongestSequence(seqList));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * This Method calculates the longest sequence of ascending
	 * values in the list. This uses bottom up approach 
	 * of Dynamic Programming
	 * 
	 * @param seqList List having sequence of integers
	 * 
	 * @return value of longest sequence.
	 * 
	 * @throws AttributeNotFoundException if List is null
	 */
	public int getLongestSequence(List<Integer> seqList) 
			throws AttributeNotFoundException {
		if(seqList == null)
			throw new AttributeNotFoundException("List cannot be empty");
		
		int len = seqList.size();
		
		int[] LIS = new int[len+1];
		
		//initialize LIS to have size as 1 for all the variable
		for(int i = 0; i < len; i++) {
			LIS[i] = 1;
		}
		
		//Iterate through list for different sequences
		//and get the results.
		
		for(int i = 1; i < len;i++) {
			for(int j = 0; j < i;j++) {
				if(seqList.get(i) > seqList.get(j) &&
						LIS[i] < LIS[j] + 1) { // Dynamically using previously calculated value
					LIS[i] = LIS[j] + 1;
					
				}
				
			}
		}
		
		
		int max = 0;
		for(int i = 0; i < len; i++) {
			if(LIS[i] > max)
				max = LIS[i];
			
		}
		
		return max;
	}
	

}
