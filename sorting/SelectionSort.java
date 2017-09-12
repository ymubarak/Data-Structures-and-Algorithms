package sort;

public class SelectionSort {

	public static void selectionSort(int[] a) {
		int minIndex;
		for (int i = 0; i < a.length - 1; i++) {
			minIndex = getMin(a, i);
			swap(a, i, minIndex);
		}
	}

	private static int getMin(int[] a, int i) {
		int minIndex = i;
		for (int j = i + 1; j < a.length; j++) {
			if (a[j] < a[minIndex])
				minIndex = j;
		}
		return minIndex;
	}

	private static void swap(int[] a, int source, int distination) {

		int temp = a[distination];
		a[distination] = a[source];
		a[source] = temp;
	}
}
