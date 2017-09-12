package sort;

public class ShellSort {

	public static void shellSort(int[] a) {
		int d = a.length;
		boolean flag = true;
		while (flag || d > 1) {
			flag = false;
			d = (d + 1) / 2;
			for (int i = 0; i < a.length - d; i++) {
				if (a[i] > a[i + d]) {
					swap(a, i, i + d);
					flag = true;
				}
			}
		}
//		int gap = a.length / 2;
//		while (gap > 0) {
//			for (int j = gap; j < a.length; j++) {
//				for (int i = j - gap; i >= 0; i = i - gap)
//					if (a[i] > a[i + gap])
//						swap(a, i, i + gap);
//					else
//						break;
//
//			}
//			gap = gap / 2;
//		}
	}

	private static void swap(int[] a, int source, int distination) {

		int temp = a[distination];
		a[distination] = a[source];
		a[source] = temp;
	}

}
