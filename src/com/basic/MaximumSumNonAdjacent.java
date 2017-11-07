package com.basic;

public class MaximumSumNonAdjacent {

	public static void main(String[] args) {

		int arr[] = null;
		
		arr = new int[]{2, 3, 5};
		System.out.println("Max Sum Non Adjacent: "+findMaxSumNonAdjacent(arr));
		
		arr = new int[]{11, 20, 7};
		System.out.println("Max Sum NonAdjacent: "+findMaxSumNonAdjacent(arr));
		
		arr = new int[]{5, 5, 10, 100, 10, 5};
		System.out.println("Max SumNonAdjacent: "+findMaxSumNonAdjacent(arr));
		
		arr = new int[]{4, 2};
		System.out.println("Max Sum NonAdjacent: "+findMaxSumNonAdjacent(arr));
		
		arr = new int[]{4, 2, -9, -20,  -5, 10, -2,  2};
		System.out.println("Max Sum ContiguousSubArray: "+findMaxSumContiguousSubArray(arr));
		
		arr = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println("Max Sum ContiguousSubArray: "+findMaxSumContiguousSubArray(arr));
		
	}

	/*
	 * Function to return max sum such that no two elements are adjacent
	 */
	static int findMaxSumNonAdjacent(int arr[]) {
		int incl = arr[0];
		int excl = 0;
		int exclNew = 0;
		int n = arr.length;

		for (int i = 1; i < n; i++) {
			exclNew = Math.max(incl, excl);
			incl = excl + arr[i];
			excl = exclNew;
		}
		return Math.max(incl, excl);
	}
	
	
	/*
	 * Function to return max sum such that no two elements are adjacent
	 */
	static int findMaxSumContiguousSubArray(int arr[]) {
		int max = 0;
		int maxTillNow = 0;
		for (int num : arr) {
			maxTillNow = maxTillNow + num;
			if(maxTillNow<0) maxTillNow =0;
			
			if(max < maxTillNow) max = maxTillNow;
		}
		return max;
	}

}
