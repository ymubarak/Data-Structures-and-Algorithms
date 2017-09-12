package search;

public class Ternary {

	public static void main(String[] args) {

		int[] a = { 9, 8, 7, 6, 5, 4, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		int r = ternarySearch(a, 0, a.length - 1);
		System.out.println(r);
	}

	public static int ternarySearch(int[] arr, int left, int right) {
		while (right - left > 3) {
			int leftThird = left + (right - left) / 3;
			int rightThird = left + 2 * ((right - left) / 3);

			if (arr[leftThird] < arr[rightThird])
				right = rightThird;
			else
				left = leftThird;
		}
		int ans = arr[left++];
		for (int i = left; i <= right; i++) {
			if (ans > arr[i])
				ans = arr[i];
		}
		return ans;
	}
}
