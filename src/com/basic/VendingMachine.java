package com.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class VendingMachine {

	static Map<Integer, Integer> vendindMachineItems = new HashMap<>();
	static Map<Integer, Integer> vendindMachineCollection = new HashMap<>();
	static List<Integer> coinsAllowed = Arrays.asList(new Integer[] { 1, 2, 5, 10 });

	public static void refill() {
		// fill product with 3 items each
		for (Iterator iterator = coinsAllowed.iterator(); iterator.hasNext();) {
			Integer coin = (Integer) iterator.next();
			int itemQuant = 3;
			vendindMachineItems.put(coin, itemQuant);
		}
	}

	public static void withdraw(int coinDenomination) {

		if (vendindMachineItems.containsKey(coinDenomination)) {

			Integer itemRmaining = vendindMachineItems.get(coinDenomination);
			if (itemRmaining > 0) {
				itemRmaining--;
				updateCoinCollection(coinDenomination);
				vendindMachineItems.put(coinDenomination, itemRmaining);
				System.out.println("One Item withdrawn of coin: " + coinDenomination);
			} else {
				System.out.println("Item tray empty for coin: " + coinDenomination + ", please collect your coin ");
			}

		} else {
			System.out.println("Coin not supported: " + coinDenomination);
		}

	}

	public static void showCointsCollection() {

		System.out.println("$$$$$$$$$$$$$$$$$$$$ Coin Collections $$$$$$$$$$$$$$$$$$$$");
		Set<Entry<Integer, Integer>> entries = vendindMachineCollection.entrySet();
		int total = 0;
		if (entries != null && entries.size() > 0) {

			for (Iterator iterator = entries.iterator(); iterator.hasNext();) {
				Entry<Integer, Integer> entry = (Entry<Integer, Integer>) iterator.next();

				total += entry.getKey() * entry.getValue();
				System.out.println("Coin: " + entry.getKey() + ", coin count: " + entry.getValue());
			}
		}
		System.out.println("Total Amount: " + total);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}

	public static void showItemCollection() {

		System.out.println("#################### Item Collections ####################");
		Set<Entry<Integer, Integer>> entries = vendindMachineItems.entrySet();
		int total = 0;
		if (entries != null && entries.size() > 0) {

			for (Iterator iterator = entries.iterator(); iterator.hasNext();) {
				Entry<Integer, Integer> entry = (Entry<Integer, Integer>) iterator.next();
				total += entry.getValue();
				System.out.println("Coin: " + entry.getKey() + ", item count: " + entry.getValue());
			}
		}
		System.out.println("Total Items: " + total);
		System.out.println("############################################################");
	}

	public static void updateCoinCollection(int coinDenomination) {

		Integer coinCount = vendindMachineCollection.get(coinDenomination);
		if (coinCount != null && coinCount > 0) {
			coinCount++;
			vendindMachineCollection.put(coinDenomination, coinCount);
		} else {
			vendindMachineCollection.put(coinDenomination, 1);
		}
	}

	public static void main(String[] args) {

		refill();

		withdraw(2);
		withdraw(2);
		withdraw(2);
		withdraw(2);
		withdraw(5);
		withdraw(3);

		showCointsCollection();
		showItemCollection();

	}

}
