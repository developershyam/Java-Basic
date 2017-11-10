package com.basic;

import java.util.Arrays;

public class ArrayBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 4, 5, 2, 7, 11, 7, 88, 99, 7, 29 };
		System.out.println("Max: " + getMax(arr));
		System.out.println("Min: " + getMin(arr));
		System.out.println("int arr class name: " + arr.getClass().getName());
		System.out.println("float arr class name: " + new float[1].getClass().getName());
		System.out.println("Integer arr class name: " + new Integer[0].getClass().getName());
		System.out.println("Float arr class name: " + new Float[1].getClass().getName());
		System.out.println("String arr class name: " + new String[1].getClass().getName());

		System.out.println("copy==>  old: " + arr + ", new: " + getSysCopy(arr));
		System.out.println("Add:");
		print(add(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));

		topTwo(new int[] { 20, 34, 21, 87, 92, Integer.MAX_VALUE });
		topTwo(new int[] { 0, Integer.MIN_VALUE, -2 });
		
		System.out.println("Nth largest: "+findKthLargest(new int[]{1, 2, 3, 4, 5}, 3));
		
		System.out.println("Unique: "+Arrays.toString(removeDuplicates(new int[]{1,2,1,2,3})));

	}
	
	public static int[] removeDuplicates(int[] arr){
	    int end = arr.length;

	    for (int i = 0; i < end; i++) {
	        for (int j = i + 1; j < end; j++) {
	            if (arr[i] == arr[j]) {                  
	                /*int shiftLeft = j;
	                for (int k = j+1; k < end; k++, shiftLeft++) {
	                    arr[shiftLeft] = arr[k];
	                }*/
	                arr[j] = arr[end-1];
	                end--;
	                j--;
	            }
	        }
	    }

	    int[] whitelist = new int[end];
	    /*for(int i = 0; i < end; i++){
	        whitelist[i] = arr[i];
	    }*/
	    System.arraycopy(arr, 0, whitelist, 0, end);
	    return whitelist;
	}

	public static int findKthLargest(int[] nums, int k) {
		if (k < 1 || nums == null) {
			return 0;
		}

		return getKth(nums.length - k + 1, nums, 0, nums.length - 1);
	}

	public static int getKth(int k, int[] nums, int start, int end) {

		int pivot = nums[end];

		int left = start;
		int right = end;

		while (true) {

			while (nums[left] < pivot && left < right) {
				left++;
			}

			while (nums[right] >= pivot && right > left) {
				right--;
			}

			if (left == right) {
				break;
			}

			swap(nums, left, right);
		}

		swap(nums, left, end);

		if (k == left + 1) {
			return pivot;
		} else if (k < left + 1) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		}
	}

	public static void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}

	public static void topTwo(int[] numbers) {
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		for (int number : numbers) {
			if (number > max1) {
				max2 = max1;
				max1 = number;
			} else if (number > max2) {
				max2 = number;
			}
		}
		System.out.println("Given integer array : " + Arrays.toString(numbers));
		System.out.println("First maximum number is : " + max1);
		System.out.println("Second maximum number is : " + max2);
	}

	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + ", ");
			}
			System.out.println();
		}
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}

	public static int[][] add(int[][] arr1, int[][] arr2) {

		int[][] res = new int[arr1.length][];
		for (int i = 0; i < arr1.length; i++) {
			int column = arr1[i].length;
			res[i] = new int[column];
			for (int j = 0; j < column; j++) {
				res[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return res;

	}

	public static int[] getSysCopy(int[] arr) {

		int[] dest = new int[arr.length];

		System.arraycopy(arr, 0, dest, 0, arr.length);
		return dest;
	}

	public static int getMin(int[] arr) {

		if (arr == null || arr.length == 0) {
			return -1;
		} else if (arr.length < 2) {
			return arr[0];
		} else {
			int min = arr[0];
			for (int i = 0; i < arr.length; i++) {
				if (min > arr[i]) {
					min = arr[i];
				}
			}
			return min;
		}

	}

	public static int getMax(int[] arr) {

		if (arr == null || arr.length == 0) {
			return -1;
		} else if (arr.length < 2) {
			return arr[0];
		} else {
			int max = arr[0];
			for (int i = 0; i < arr.length; i++) {
				if (max < arr[i]) {
					max = arr[i];
				}
			}
			return max;
		}
	}

}
