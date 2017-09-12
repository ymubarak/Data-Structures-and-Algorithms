package search;

public class Binary {

	public int search(int[] a, int target, int first, int last) {
		int location = -1; // not found

		if (first <= last) {
			int mid = (first + last) / 2;

			if (target == a[mid])
				location = mid;
			else if (target < a[mid])
				location = search(a, target, first, mid - 1);
			else
				location = search(a, target, mid + 1, last);
		}
		return location;
	}
}
