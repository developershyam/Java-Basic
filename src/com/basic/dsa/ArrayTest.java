package com.basic.dsa;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {

		ArrayTest at = new ArrayTest();
		
		int arrInt1[] = {1, 2, 3, 4, 5};
		int arrInt2[] = {1, 2, 3, 4};
		System.out.println(Arrays.toString(arrInt1));
		System.out.println(Arrays.toString(at.reverseArray(arrInt1)));
		System.out.println();
		System.out.println(Arrays.toString(arrInt2));
		System.out.println(Arrays.toString(at.reverseArray(arrInt2)));
	}

	private int[] reverseArray(int array[]) {
		// TODO Auto-generated method stub
		for (int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
		return array;
	}

}
