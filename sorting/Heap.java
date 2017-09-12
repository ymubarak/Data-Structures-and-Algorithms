package sort;

public class Heap {

	public static final int LENGTH = 100;
	public int heap_size;
	private int[] heapArray;

	public Heap() {
		this(LENGTH);
	}

	public Heap(int size) {
		heapArray = new int[size];
		heap_size = 0;
	}

	public void max_heapify(int index) {
		if (isEmpty())
			throw new RuntimeException("Heap Is empty !");
		int l = left(index);
		int r = right(index);
		int largest;
		if (l < heap_size && heapArray[l] > heapArray[index])
			largest = l;
		else
			largest = index;
		if (r < heap_size && heapArray[r] > heapArray[largest])
			largest = r;
		if (largest != index) {
			swap(heapArray, index, largest);
			max_heapify(largest);
		}
	}

	public void build_max_heap(int[] array) {

		// array
		heapArray = array;
		heap_size = array.length;
		for (int i = heap_size / 2; i >= 0; i--) {
			max_heapify(i);
		}

	}

	public void max_heap_insert(int e) {
		if (heap_size == heapArray.length)
			throw new RuntimeException("Heap Is Full !");
		heapArray[heap_size++] = e;
		int index = heap_size - 1;
		while (heapArray[index] > heapArray[index / 2]) {
			swap(heapArray, index, index / 2);
			index = index / 2;
		}
	}

	public void heap_sort(int[] unsortedArray) {

		build_max_heap(unsortedArray);
		for (int i = unsortedArray.length - 1; i > 0; i--) {
			swap(heapArray, 0, i);
			heap_size--;
			max_heapify(0);
		}
	}

	public int heap_extract_max() {
		if (isEmpty())
			throw new RuntimeException("Heap is empty !");
		int max = heapArray[0];
		heap_size--;
		if (heap_size > 0) {
			heapArray[0] = heapArray[heap_size];
			max_heapify(0);
		}
		return max;

	}

	public int peek_max() {
		if (isEmpty())
			throw new RuntimeException("Heap is empty !");
		return heapArray[0];

	}

	public boolean isEmpty() {

		return heap_size == 0;
	}

	private int left(int index) {
		return 2 * index + 1;
	}

	private int right(int index) {
		return 2 * (index + 1);
	}

	public void swap(int[] a, int source, int distination) {

		int temp = a[distination];
		a[distination] = a[source];
		a[source] = temp;
	}

	public void print() {
		for (int i = 0; i < heap_size; i++) {
			System.out.print(heapArray[i] + " ");
		}
		System.out.println();
	}

}
