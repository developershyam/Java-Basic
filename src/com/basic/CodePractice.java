package com.basic;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CodePractice {

	public static void main(String[] args) {

		// System.out.println("\n replaceString: ");
		// replaceString();

		// System.out.println("\nFibonacciRecursion: ");
		// fibonacciRecursion(10);
		// System.out.println("\nFibonacci: ");
		// fibonacci(10);
		// System.out.println("\nFibonacciArray: ");
		// fibonacciArray(10);

		// System.out.println("\nFactorial: ");
		// factorial(5);
		// System.out.println("\nFactorialRecursion: "+factorialRecursion(5));

		// armstrong(i);

		// palindrom(141141); palindrom(142);
		// palindrom("abcba"); palindrom("abc");

		// swap();

		// charOcurrence("ABCA");
		// charOcurrenceSB("ABCA");

		// longUniqueSubString("aba2invoice");
		// longRepeatSubString("aba2invoiceaaa");

		// permuteString("", "ABCA");

		// one missing number
		// printMissingNumber(new int[]{ 2, 3, 4, 6}, 6);

		// two missing number
		// printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);

		// three missing number
		// printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);

		// four missing number
		// printMissingNumber(new int[]{1, 2, 3, 4, 9, 8}, 10);

		// Only one missing number in array
		// int[] iArray = new int[]{1, 2, 3, 5};
		// int missing = getMissingNumber(iArray, 5);
		// System.out.printf("Missing number in array %s is %d %n",
		// Arrays.toString(iArray), missing);

		calculateLoanPayment(1060000, 5);
	}

	public static void calculateLoanPayment(double loanamount, int years) {
		/*
		 * to calculate the monthly loan payment i.e. EMI
		 * 
		 * rate=annual interest rate/12*100; n=number of monthly installments;
		 * 1year=12 months. so, n=years*12;
		 * 
		 */

		double EMI;
		int n;
		float rate = 11;

		n = years * 12;
		rate = rate / 1200;
		EMI = ((rate * Math.pow((1 + rate), n)) / ((Math.pow((1 + rate), n)) - 1)) * loanamount;

		System.out.println("your monthly EMI is " + EMI + " for the amount" + loanamount + " you have borrowed");
	}

	/**
	 * A general method to find missing values from an integer array in Java.
	 * This method will work even if array has more than one missing element.
	 */
	private static void printMissingNumber(int[] numbers, int count) {
		int missingCount = count - numbers.length;
		BitSet bitSet = new BitSet(count);

		for (int number : numbers) {
			bitSet.set(number - 1);
			System.out.println(bitSet);
		}

		System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers),
				count);
		int lastMissingIndex = 0;

		for (int i = 0; i < missingCount; i++) {
			lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
			System.out.println(++lastMissingIndex);
		}

	}

	/**
	 * Java method to find missing number in array of size n containing numbers
	 * from 1 to n only. can be used to find missing elements on integer array
	 * of numbers from 1 to 100 or 1 - 1000
	 */
	private static int getMissingNumber(int[] numbers, int totalCount) {
		int expectedSum = totalCount * ((totalCount + 1) / 2);
		int actualSum = 0;
		for (int i : numbers) {
			actualSum += i;
		}

		return expectedSum - actualSum;
	}

	static int countPermotation = 0;

	public static void permuteString(String beginningString, String endingString) {
		if (endingString.length() <= 1)
			System.out.println((++countPermotation) + ". " + beginningString + endingString);
		else
			for (int i = 0; i < endingString.length(); i++) {
				try {
					String newString = endingString.substring(0, i) + endingString.substring(i + 1);

					permuteString(beginningString + endingString.charAt(i), newString);
				} catch (StringIndexOutOfBoundsException exception) {
					exception.printStackTrace();
				}
			}
	}

	public static String longRepeatSubString(String str) {

		String interimresult = "";
		String result = ""; // final result
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			interimresult += ch; // add the letter once
			for (int j = i + 1; j < str.length(); j++) {
				char ch1 = str.charAt(j);
				if (ch != ch1) {
					break;
				}
				interimresult += ch;
			}
			if (interimresult.length() > result.length())// store the result if
															// it is longer
				result = interimresult;
			interimresult = ""; // clear to continue with the next letter
		}
		System.out.println(result);
		return result;

	}

	public static String longUniqueSubString(String input) {

		String longestOverAll = "";
		String longestTillNow = "";

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (longestTillNow.indexOf(c) > -1) {
				longestTillNow = "";
			}
			longestTillNow += c;
			if (longestTillNow.length() > longestOverAll.length()) {
				longestOverAll = longestTillNow;
			}
		}
		System.out.println(longestOverAll);
		return longestOverAll;
	}

	public static void charOcurrence(String s) {

		String result = "";
		while (s.length() > 0) {
			int count = 0;
			char c = s.charAt(0);
			while (s.indexOf(c + "") != -1) {
				s = s.substring(0, s.indexOf(c + "")) + s.substring(s.indexOf(c + "") + 1);
				count++;
			}
			result += c + "-" + count;
			if (s.length() > 0)
				result += ", ";
		}
		System.out.println(result);
	}

	public static void charOcurrenceSB(String s) {

		StringBuilder sb = new StringBuilder(s);
		String result = "";
		while (sb.length() > 0) {
			int count = 0;
			char c = sb.charAt(0);
			while (sb.indexOf(c + "") != -1) {
				sb.deleteCharAt(sb.indexOf(c + ""));
				count++;
			}
			result += c + "-" + count;
			if (sb.length() > 0)
				result += ", ";
		}
		System.out.println(result);
	}

	public static void swap() {
		int a = 1, b = 2;
		System.out.println("a=" + a + ", b=" + b);

		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println("a=" + a + ", b=" + b);
	}

	public static void armstrong(int num) {

		int csum = 0, temp = num, mod = 0;
		while (temp > 0) {
			mod = temp % 10;
			temp = temp / 10;
			csum += mod * mod * mod;
		}
		if (num == csum) {
			System.out.println("Armstrong: " + num);
		} else {
			System.out.println("Not Armstrong: " + num);
		}

	}

	public static void palindrom(int num) {
		int csum = 0, temp = num, mod = 0;
		while (temp > 0) {
			mod = temp % 10;
			temp = temp / 10;
			csum = (csum * 10) + mod;
		}
		if (num == csum) {
			System.out.println("Palindrom: " + num);
		} else {
			System.out.println("Not Palindrom: " + num);
		}
	}

	public static void palindrom(String str) {

		String out = "";
		int count = str.length();
		for (int i = count - 1; i >= 0; i--) {

			out = out + str.charAt(i);
		}

		if (out.equals(str)) {
			System.out.println("Palindrom: " + out);
		} else {
			System.out.println("Not Palindrom: " + out);
		}

	}

	public static void factorial(int num) {

		int fact = 1;
		if (num <= 1) {
			System.out.println("fact: " + fact);
		}
		for (int i = num; i >= 1; i--) {
			fact = fact * i;
		}
		System.out.println("fact: " + fact);
	}

	public static int factorialRecursion(int num) {

		if (num <= 1) {
			return 1;
		}
		return num * factorialRecursion(num - 1);
	}

	static int a = 0, b = 1, c = 0;

	public static void fibonacciRecursion(int count) {

		if (count > 0) {

			System.out.print(c + " ");
			a = b;
			b = c;
			c = a + b;
			fibonacciRecursion(count - 1);
		}

	}

	public static void fibonacci(int count) {

		int a = 0, b = 1, c = 0;
		for (int i = 0; i < count; i++) {
			// System.out.println("\n==>"+i+" [ "+a+", "+b+", "+c+"]");
			System.out.print(c + " ");
			a = b;
			b = c;
			c = a + b;
		}

	}

	public static void fibonacciArray(int count) {

		int arr[] = new int[count];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 0;
		System.out.print(arr[0] + " " + arr[1] + " ");
		for (int i = 2; i < count; i++) {
			arr[i] = arr[i - 2] + arr[i - 1];
			System.out.print(arr[i] + " ");
		}

	}

	public static void replaceString() {

		String s = "abcdabcd";
		char c1 = 'c';
		char c2 = 'a';
		String s1 = "ab";
		String s2 = "cd";

		// s = s.replace(c1, c2); //abadabad

		// s = s.replace(s1, s2); //abcdabcd

		// s = s.replaceAll(s1, s2);//abcdabcd

		char sc[] = s.toCharArray();
		char sco[] = new char[sc.length];
		for (int i = 0; i < sc.length; i++) {
			if (s.charAt(i) == c1) {
				sco[i] = c2;
			} else {
				sco[i] = s.charAt(i);
			}
		}
		// abadabad

		System.out.println("s: " + s);

		System.out.println("sco: " + new String(sco));

	}

}
