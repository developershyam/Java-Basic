package com.basic;

//we search for the lowest element and arrange it to the proper location. 
//We swap the current element with the next lowest number.
public class SelectionSort {

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index]) {
					index = j;// searching for lowest index
				}
			}
			int smallerNumber = arr[index];
			arr[index] = arr[i];
			arr[i] = smallerNumber;
		}
	}

	public static void main(String a[]) {
		int[] arr1 = { 3, 60, 35, 2, 45 };
		System.out.println("Before Selection Sort");
		for (int i : arr1) {
			System.out.print(i + " ");
		}
		System.out.println();

		
		long start = System.nanoTime();
		selectionSort(arr1);// sorting array using selection sort
		long end = System.nanoTime();

		System.out.println("After Selection Sort");
		for (int i : arr1) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println("Time taken(nano sec): "+(end-start));
	}
}

//output
//Array Before Bubble Sort
//3 60 35 2 45
//Array After Bubble Sort
//2 3 35 45 60  
