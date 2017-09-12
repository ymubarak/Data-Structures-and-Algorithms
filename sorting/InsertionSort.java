package sort;

public class InsertionSort {

	public static void insertionSort(int[] a) {

		for (int i = 1; i < a.length; i++) {
			int pos = i;
			int inserted = a[pos];
			while (pos > 0 && inserted < a[pos - 1]) {
				a[pos] = a[pos - 1];
				pos--;
			}
			a[pos] = inserted;
		}
	}
}
