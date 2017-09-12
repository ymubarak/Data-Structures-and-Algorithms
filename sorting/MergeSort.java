package sort;

public class MergeSort {

	static int[] temp;

	static void initializeTemp(int size) {
		temp = new int[size];
	}

	public static void mergeSort(int[] ar, int low, int high) {

		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(ar, low, mid);
			mergeSort(ar, mid + 1, high);
			merge(ar, low, mid, high);
		}
	}

	private static void merge(int[] ar, int low, int mid, int high) {

		int l = low;
		int h = mid + 1;
		int i = low;
		while (l <= mid && h <= high) {
			if (ar[l] < ar[h]) {
				temp[i] = ar[l];
				l++;
			} else {
				temp[i] = ar[h];
				h++;
			}
			i++;
		}
		if (l > mid) {
			for (int j = h; j <= high; j++) {
				temp[i] = ar[j];
				i++;
			}
		} else {
			for (int j = l; j <= mid; j++) {
				temp[i] = ar[j];
				i++;
			}
		}
		for (int k = low; k < i; k++) {
			ar[k] = temp[k];
		}
	}

}
