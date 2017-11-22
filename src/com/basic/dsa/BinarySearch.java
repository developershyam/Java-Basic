package com.basic.dsa;

public class BinarySearch {

	static int loopCount=0;
	public static int binarySearch(int[] inputArr, int key) {

		loopCount=0;
		int start = 0;
		int end = inputArr.length - 1;
		while (start <= end) {
			loopCount++;
			int mid = (start + end) / 2;
			if (key == inputArr[mid]) {
				return mid;
			}
			if (key < inputArr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
	
	// If x is present in arr[0..n-1], then returns
    // index of it, else returns -1.
    static int interpolationSearch(int[] inputArr,  int x)
    {
    	loopCount=0;
        // Find indexes of two corners
        int lo = 0, hi = (inputArr.length - 1);
      
        // Since array is sorted, an element present
        // in array must be in range defined by corner
        while (lo <= hi && x >= inputArr[lo] && x <= inputArr[hi])
        {
        	loopCount++;
            // Probing the position with keeping
            // uniform distribution in mind.
            int pos = lo + (((hi-lo) /
                  (inputArr[hi]-inputArr[lo]))*(x - inputArr[lo]));
      
            // Condition of target found
            if (inputArr[pos] == x)
                return pos;
      
            // If x is larger, x is in upper part
            if (inputArr[pos] < x)
                lo = pos + 1;
      
            // If x is smaller, x is in lower part
            else
                hi = pos - 1;
        }
        return -1;
    }

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("Key 7's position binarySearch: " + binarySearch(arr, 7)+"   ,  loopCount: "+loopCount);
		System.out.println("Key 7's position interpolationSearch: " + interpolationSearch(arr, 7)+"   ,  loopCount: "+loopCount);
		
		System.out.println();
		int[] arr1 = { 2, 4, 6, 8, 10, 12, 14, 16 };
		System.out.println("Key 14's position binarySearch: " + binarySearch(arr1, 14)+"   ,  loopCount: "+loopCount);
		System.out.println("Key 14's position interpolationSearch: " + interpolationSearch(arr1, 14)+"   ,  loopCount: "+loopCount);
		
		System.out.println();
		int[] arr2 = { 6, 34, 78, 123, 432, 900 };
		System.out.println("Key 432's position binarySearch: " + binarySearch(arr2, 432)+"   ,  loopCount: "+loopCount);
		System.out.println("Key 432's position interpolationSearch: " + interpolationSearch(arr2, 432)+"   ,  loopCount: "+loopCount);
	}

}
