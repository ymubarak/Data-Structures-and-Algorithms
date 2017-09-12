package sort;

public class SortOnInsertion {

	public static void main(String[] args) {
		int[] a = { 0, 5, 9, 4, -1, 11, 2, 16 };
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			insert(b, a[i]);
		}

		for (int k : b)
			System.out.print(k + " ");
		
	}

	static int nItems;

	public static void insert(int[] QueArray, int item) {
		if (nItems == 0)
			QueArray[nItems++] = item;
		else {
			int j;
			for (j = nItems - 1; j >= 0; j--) {
				if (item < QueArray[j]) // > for descending
					QueArray[j + 1] = QueArray[j];
				else
					break;
			}
			QueArray[j + 1] = item; // insert item
			nItems++;
		}
	}
}
