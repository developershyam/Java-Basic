package com.basic.dsa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class LRU {

	static int pageFaults(String pages[], int capacity) {

		int n = pages.length;
		Map<String, Integer> indexes = new HashMap<String, Integer>();
		int pageFaults = 0;
		String lruVal = "";
		String currentFault = "NO";
		for (int i = 0; i < n; i++) {
			String newVal = pages[i];
			lruVal = "";
			// Check if the set can hold more pages
			if (indexes.size() < capacity) {

				if (!indexes.containsValue(newVal)) {
					// increment page fault
					pageFaults++;
					currentFault = "YES";
				}
				indexes.put(newVal, i);
			} else {
				// Check if current page is not already
				// present in the set
				if (!indexes.containsKey(newVal)) {
					// Find the least recently used pages
					// that is present in the set
					int lruIndex = i;
					Iterator<Entry<String, Integer>> itr = indexes.entrySet().iterator();
					while (itr.hasNext()) {
						Entry<String, Integer> entry = itr.next();
						if (entry.getValue() < lruIndex) {
							lruIndex = entry.getValue();
							lruVal = entry.getKey();
						}
					}

					// Remove the indexes page
					indexes.remove(lruVal);

					// insert the current page
					indexes.put(newVal, i);

					// Increment page faults
					pageFaults++;
					currentFault = "YES";
				} else {
					// Update the current page index
					indexes.put(pages[i], i);
				}

			}
			System.out.println("\nNew Value: " + newVal + ", LRUVal: " + lruVal + ", Current Page Fault: "
					+ currentFault + ", Total PageFault: " + pageFaults);
			indexes.keySet().forEach(key -> System.out.print(key + "->" + indexes.get(key) + ", "));
			System.out.println("\n-----------------");
		}
		return pageFaults;
	}

	// Driver method
	public static void main(String args[]) {
		// int pages[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2 };
		// int pages[] = { 1, 2, 3, 4, 1, 5 };

		String pages[] = { "a", "b", "c", "d", "a", "e" };
		int capacity = 4;
		pageFaults(pages, capacity);
	}
}
