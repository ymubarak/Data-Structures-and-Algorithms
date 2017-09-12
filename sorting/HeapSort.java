package sort;

public class HeapSort {

	static Heap heap;

	public static void sort(int[] unsortedArray) {
		heap = new Heap(unsortedArray.length);
		heap.build_max_heap(unsortedArray);
		for (int i = unsortedArray.length - 1; i > 0; i--) {
			heap.swap(unsortedArray, 0, i);
			heap.heap_size--;
			heap.max_heapify(0);
		}
	}
}
