package com.basic;


public class ArrayBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int arr[] = {4, 5, 2, 7, 11, 7, 88, 99, 7, 29};
		System.out.println("Max: "+ getMax(arr));
		System.out.println("Min: "+ getMin(arr));
		System.out.println("int arr class name: " +arr.getClass().getName());
		System.out.println("float arr class name: " +new float[1].getClass().getName());
		System.out.println("Integer arr class name: " +new Integer[0].getClass().getName());
		System.out.println("Float arr class name: " +new Float[1].getClass().getName());
		System.out.println("String arr class name: " +new String[1].getClass().getName());
		
		System.out.println("copy==>  old: "+arr+", new: "+getSysCopy(arr));
		System.out.println("Add:");
		print(add(new int[][] {{1, 2, 3}, {4, 5, 6}}, new int[][] {{1, 2, 3}, {4, 5, 6}}));
		
	}
	
	public static void  print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+", ");
			}
			System.out.println();
		}
	}
	
	public static void  print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+", ");
		}
	}
	public static int[][] add(int[][] arr1, int[][] arr2) {
		
		int[][] res = new int[arr1.length][];
		for (int i = 0; i < arr1.length; i++) {
			int column = arr1[i].length;
			res[i] = new int[column];
			for (int j = 0; j < column; j++) {
				res[i][j] = arr1[i][j]+arr2[i][j];
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
		
		if(arr==null || arr.length==0) {
			return -1;
		}else if(arr.length<2) {
			return arr[0];
		}else {
			int min = arr[0];
			for (int i = 0; i < arr.length; i++) {
				if(min>arr[i]) {
					min=arr[i];
				}
			}
			return min;
		}
		
	} 
	
	public static int getMax(int[] arr) {
		
		if(arr==null || arr.length==0) {
			return -1;
		}else if(arr.length<2) {
			return arr[0];
		}else {
			int max = arr[0];
			for (int i = 0; i < arr.length; i++) {
				if(max<arr[i]) {
					max=arr[i];
				}
			}
			return max;
		}
	} 

}
