package com.basic;
//A palindrome string is a v that is same after reverse.
public class PalindromeString {
	public static void main(String args[]) {
		String str ="NAMAN";
		char[] arr = new char[str.length()];
		for(int i = str.length()-1, j=0; i>=0; i--, j++){
			
			arr[j] = str.charAt(i);
		}
		String temp = new String(arr);
		System.out.println(temp);
		if (temp.equals(str))
			System.out.println("palindrome string ");
		else
			System.out.println("not palindrome string");
	}
}

//Get the number to check for palindrome
//Hold the number in temporary variable
//Reverse the number
//Compare the temporary number with reversed number
//If both numbers are same, print "palindrome number"
//Else print "not palindrome number"
