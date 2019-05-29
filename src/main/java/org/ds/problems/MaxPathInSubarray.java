package org.ds.problems;

/**
 * https://practice.geeksforgeeks.org/problems/max-sum-path-in-two-arrays/1/?track=interview-arrays
 * 
 * @author Roshan
 *
 */
public class MaxPathInSubarray {

	public static void main(String args[]) {
		MaxPathInSubarray path = new MaxPathInSubarray();
		//int[] arr1 = {1, 2, 4};
		//int[] arr2 = {1,2,7};
		int[] arr1 = {2, 3,7,10,12};
		int[] arr2 = {1,5,7, 8};
		System.out.println(path.maxPathSum(arr1, arr2));
	}


	int maxPathSum(int ar1[], int ar2[]) {
		int index1 = 0;
		int index2 = 0;
		int arr1Length = ar1.length;
		int arr2Length = ar2.length;
		
		if(arr1Length == 0)
			return printSumOfArray(ar2, 0, arr2Length-1);
		
		if(arr2Length == 0)
			return printSumOfArray(ar1, 0, arr1Length-1);
		
		int sum = 0;
		
		if(ar1[0] < ar2[0]) {
			sum += ar1[0];
			index1++;
		}else if(ar1[0] == ar2[0]){
			index1++;
			index2++;
			sum += ar1[0];
		}else {
			sum+=ar2[0];
			index2++;
		}
		
		while(index1 < arr1Length) {
			
			if(index2 == arr2Length) {
				sum += printSumOfArray(ar1, index1, arr1Length-1);
				break;
			}
			
			if(ar1[index1] > ar2[index2]) {
				sum += ar1[index1];
				index2++;
			}else if(ar1[index1] == ar2[index2]){
				sum += ar1[index1];
				index1++;
				index2++;
			}else {
				sum += ar2[index2++];
				index1++;
			}

		}
		
		if(index2 < arr2Length-1)
			sum += printSumOfArray(ar2, index2, arr2Length-1);
		
		return sum;
	}
	
	int printSumOfArray(int[] arr, int startIndex, int endIndex) {
		int length = arr.length;
		int sum=0;
		
		if(startIndex > length-1)
			return 0;
		
		if(endIndex > length-1)
			endIndex = length-1;
		
		for(int i = startIndex; i <= endIndex; i++) {
			sum += arr[i];
		}
		
		return sum;
	}
	
}
