package com.basic;

public class InsertionSort {

	public static void insertionSort(int array[]) {
		int n = array.length;
		for (int j = 1; j < n; j++) {
			int key = array[j];
			int i = j - 1;
			while ((i > -1) && (array[i] > key)) {
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = key;
		}
	}

	public static void main(String a[]) {
		int[] arr1 = { 3, 60, 35, 2, 45 };
		System.out.println("Before Insertion Sort");
		for (int i : arr1) {
			System.out.print(i + " ");
		}
		System.out.println();

		long start = System.nanoTime();
		insertionSort(arr1);// sorting array using insertion sort
		long end = System.nanoTime();

		System.out.println("After Insertion Sort");
		for (int i : arr1) {
			System.out.print(i + " ");
		}

		System.out.println();
		System.out.println("Time taken(nano sec): " + (end - start));
	}
}
