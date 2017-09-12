package sort;

public class BubbleSort {

	public static void bubbleSort(int[] a) {

		boolean swapped = true;
		for (int i = 0; i < a.length && swapped; i++) {
			swapped = false;
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, (j + 1), j);
					swapped = true;
				}
			}
		}
	}

	private static void swap(int[] a, int source, int distination) {

		int temp = a[distination];
		a[distination] = a[source];
		a[source] = temp;
	}
}
