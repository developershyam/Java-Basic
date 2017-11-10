package com.basic;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class StringLogic {

	public static void main(String[] args) {

		System.out.println("Char count string: " + characterCount("14431"));
		System.out.println(
				"Word count string: " + wordCount("I am shyam, shyam is java developer. java is my favourite"));

		System.out.println("Longest Non-Repeatating string: " + logestNonRepeatatingSequence("aba2novice"));

		String str = "ABCABD";
		
		System.out.println("Longest Repeatating string count: "
				+ logestRepeatatingSequence(str, str.length(), str.length()));
		
		
		lookup = new int[str.length()+1][str.length()+1];
		fillLookupLRSLength(str, str.length());
		System.out.println("Longest Repeatating string: "
				+ logestRepeatatingSequenceStr(str, str.length(), str.length()));
		
		Set<String> output = new LinkedHashSet<>();
		permute("ABC", 0, 2, output);
		System.out.println(output);
		
		 permute("ABC");
		
	}

	public static String logestNonRepeatatingSequence(String input) {
		String output = "", intermediate = "";
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (output.indexOf(ch) > -1) {
				intermediate = "";
			}
			intermediate += ch;
			if (output.length() < intermediate.length()) {
				output = intermediate;
			}
		}
		return output;
	}

	// lookup[i][j] stores the length of LRS of substring X[0..i-1], X[0..j-1]
	static int lookup[][];
	public static int logestRepeatatingSequence(String input, int m, int n) {

		// return if reached at end
		if (m == 0 || n == 0)
			return 0;

		// Charcter at indx m and n matches and diff indx
		if (input.charAt(m - 1) == input.charAt(n - 1) && m != n)
			return logestRepeatatingSequence(input, m - 1, n - 1) + 1;

		// else if do not match char
		return Math.max(logestRepeatatingSequence(input, m, n - 1), logestRepeatatingSequence(input, m - 1, n));

	}
	
	

	// Function to find LRS of substrings X[0..m-1], X[0..n-1]
	public static String logestRepeatatingSequenceStr(String X, int m, int n)
	{
		// if we have reached the end of either sequence
		// return empty string
		if (m == 0 || n == 0)
			return new String("");

		// if characters at index m and n matches and index is different
		if (X.charAt(m-1) == X.charAt(n-1) && m != n)
			return logestRepeatatingSequenceStr(X, m - 1, n - 1) + X.charAt(m-1);

		else
		// else if characters at index m and n don't match
		{
			if (lookup[m - 1][n] > lookup[m][n - 1])
				return logestRepeatatingSequenceStr(X, m - 1, n);
			else
				return logestRepeatatingSequenceStr(X, m, n - 1);
		}
	}

	// Function to fill lookup table by finding the length of LRS
	// of substring X[0..n-1]
	static void fillLookupLRSLength(String X, int n)
	{
		// first row and first column of the lookup table
		// are already 0 as lookup[][] is globally declared

		// fill the lookup table in bottom-up manner
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				// if characters at index i and j matches 
				// and the index is different
				if (X.charAt(i-1) == X.charAt(j-1) && i != j)
					lookup[i][j] = lookup[i - 1][j - 1] + 1;

				// else if characters at index i and j are different 
				else
					lookup[i][j] = Math.max(lookup[i - 1][j], lookup[i][j - 1]);
			}
		}

		// Uncomment below code to print the lookup table
	/*	for (int i = 0; i <= m; i++)
		{
			for (int j = 0; j <= n; j++)
				cout << lookup[i][j] << " ";
			cout << endl;
		}*/
	}
	
	public static String characterCount(String input) {

		String output = "", temp = input;
		while (temp.length() > 0) {
			char c = temp.charAt(0);
			temp = temp.substring(1);
			int count = 1;
			for (int i = 0; i < temp.length(); i++) {
				if (temp.charAt(i) == c) {
					count++;
					temp = temp.substring(0, i) + temp.substring(i + 1);
				}
			}
			output += c + "-" + count;
			if (temp.length() > 0)
				output += ", ";
		}
		return output;
	}

	public static String wordCount(String input) {

		String output = "";
		String words[] = input.split("\\W+");
		while (words.length > 0) {
			String word = words[0];
			words = arrayRemove(words, 0);
			int count = 1;
			for (int i = 0; i < words.length; i++) {
				if (words[i].equals(word)) {
					count++;
					words = arrayRemove(words, i);
				}
			}
			output += word + "-" + count;
			if (words.length > 0)
				output += ", ";
		}
		return output;
	}

	public static String[] arrayRemove(String input[], int indx) {

		String output[] = new String[input.length - 1];
		for (int i = 0; i < input.length; i++) {
			if (i < indx) {
				output[i] = input[i];
			} else if (i > indx) {
				output[i - 1] = input[i];
			}
		}
		return output;
	}
	
	 /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    static private void permute(String str, int startIndx, int endIndx, Set<String> output)
    {
    	System.out.println("---------Medtod Start----"+str+", startIndx: "+startIndx+", endIndx: "+endIndx);
        if (startIndx == endIndx)
        	output.add(str);
        else
        {
            for (int i = startIndx; i <= endIndx; i++)
            {
                str = swap(str, startIndx, i);
                permute(str, startIndx+1, endIndx, output );
                //str = swap(str, startIndx, i);
            }
        }
        System.out.println("###########Medtod End----"+str+", startIndx: "+startIndx+", endIndx: "+endIndx);
    }
    
    static private void permute(String str)
    {
    	Set<String> output = new TreeSet<>();
    	output.add(str);
    	int startIndx = 0, endIndx = str.length()-1;
    	while(startIndx<=endIndx){
    		System.out.println("String ----- "+str+", startIndx: "+startIndx+", endIndx: "+endIndx);
    		for (int i = startIndx+1; i <= endIndx; i++)
            {
                String str2 = swap(str,startIndx, i);
                System.out.println(str2);
                output.add(str2);
            }
    		System.out.println("--------");
    		for (int i = startIndx-1; i >=0; i--)
            {
    			String str2 = swap(str,startIndx, i);
                System.out.println(str2);
                output.add(str2);
            }
    		startIndx++;
    	}
    	System.out.println(output);
        
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
 
    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    static public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
