package javapure;

import java.util.ArrayList;
import java.util.List;

public class Sorting {

	public static List<Integer> quicksort(List<Integer> input) {
		if (input.size() <= 1) {
			return input;
		}
		int middle = (int) Math.ceil((double) input.size() / 2);
		int pivot = input.get(middle);

		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i) <= pivot) {
				if (i == middle) {
					continue;
				}
				left.add(input.get(i));
			} else {
				right.add(input.get(i));
			}
		}
		return concatenate(quicksort(left), pivot, quicksort(right));
	}

	private static List<Integer> concatenate(List<Integer> left, int pivot, List<Integer> right) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < left.size(); i++) {
			list.add(left.get(i));
		}
		list.add(pivot);
		for (int i = 0; i < right.size(); i++) {
			list.add(right.get(i));
		}
		return list;
	}

}
