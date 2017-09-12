package sort;

public class QuickSort {

	public static void quickSort(int[] a, int low, int high) {

		if (low < high) {
			int wall = low;
			int l = low;
			int pivot = a[high];
			while (l < high) {
				if (a[l] < pivot && l < high) {
					if (a[l] != a[wall])
						swap(a, l, wall);
					wall++;
				}
				l++;
			}
			swap(a, high, wall);
			quickSort(a, low, wall - 1);
			quickSort(a, wall + 1, high);
		}
	}

	private static void swap(int[] a, int ToBeMoved, int front) {

		int temp = a[front];
		a[front] = a[ToBeMoved];
		a[ToBeMoved] = temp;
	}
}
