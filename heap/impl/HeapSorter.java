package impl;

import java.util.Comparator;
import java.lang.Math;

/**
 * HeapSorter.java
 *
 * Class to implement the heapsort algorithm.
 *
 * @author Thomas VanDrunen CSCI 345, Wheaton College Originally for CSCI 245,
 *         Spring 2007 Revised June 2, 2016
 */

public class HeapSorter extends Heap<Integer> {

	/**
	 * Constructor. Take an array an sets it up as a (max-) heap.
	 * 
	 * @param internal
	 *            The array to be used for the internal representation.
	 */
	private HeapSorter(int[] array) {
		internal = new Integer[array.length];
		for (int i = 0; i < array.length; i++)
			internal[i] = array[i];
		heapSize = array.length;

		// create a new comparator object
		compy = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2)
					return 1;
				else if (o1 < o2)
					return -1;
				else
					return 0;
			}
		};

		int height = (int) (Math.log(heapSize) / Math.log(2));
		for (int i = 0; i < height; i++) {
			int pos = heapSize - 1;

			while (pos >= 0) {
				sinkKeyAt(pos);
				pos--;
			}
		}

	}

	/**
	 * Sort this array, in place.
	 * 
	 * @param array
	 *            The array to sort.
	 */
	public static void sort(int[] array) {

		HeapSorter heap = new HeapSorter(array);
		for (int i = 0; i < heap.heapSize; i++)
			System.out.print("|" + heap.internal[i] + "|");

		
		while (heap.heapSize-1 >= 0) {
			heap.swap(0, heap.heapSize-1);
			heap.heapSize--;
			heap.sinkKeyAt(0);
		}

		// copy elements from internal (now sorted) back to array
		for (int i = 0; i < array.length; i++)
			array[i] = heap.internal[i];

	}

}
