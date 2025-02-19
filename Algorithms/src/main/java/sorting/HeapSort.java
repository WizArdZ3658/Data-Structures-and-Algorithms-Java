package sorting;

import sorting.interfaces.SortingClass;

public class HeapSort implements SortingClass {

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = n-1; i >= 0; i--) {
            this.heapify(arr, i);
        }

        int heap_limit = n-1;
        for (int i = 0; i < n; i++)
        {
            int temp = arr[0];
            arr[0] = arr[heap_limit];
            this.rebuild_heap_from_top(arr, 0, heap_limit);
            arr[heap_limit] = temp;
            heap_limit--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 3, 1, 2, 5, -9, 7, 5, -4};
        SortingClass heapSort = new HeapSort();
        heapSort.sort(arr);
        heapSort.printArray(arr);
    }

    private void heapify(int[] arr, int i) {
        int n = arr.length;
        int leftIndex = 2*i + 1;
        int rightIndex = 2*i + 2;
        if (leftIndex >= n) {
            return;
        }

        if (arr[leftIndex] > arr[i]) {
            int temp = arr[i];
            arr[i] = arr[leftIndex];
            arr[leftIndex] = temp;
        }

        if (rightIndex < n && arr[rightIndex] > arr[i]) {
            int temp = arr[i];
            arr[i] = arr[rightIndex];
            arr[rightIndex] = temp;
        }

    }

    private void rebuild_heap_from_top(int[] arr, int i, int n)
    {
        int left_node_index = 2*i + 1;
        int right_node_index = 2*i + 2;

        if (right_node_index < n) {
            if (arr[right_node_index] > arr[left_node_index]) {
                if (arr[right_node_index] > arr[i])
                {
                    int temp = arr[right_node_index];
                    arr[right_node_index] = arr[i];
                    arr[i] = temp;
                    rebuild_heap_from_top(arr, right_node_index, n);
                }
            } else {
                if (arr[left_node_index] > arr[i]) {
                    int temp = arr[left_node_index];
                    arr[left_node_index] = arr[i];
                    arr[i] = temp;
                    rebuild_heap_from_top(arr, left_node_index, n);
                }
            }
        } else if (left_node_index < n) {
            if (arr[left_node_index] > arr[i])
            {
                int temp = arr[left_node_index];
                arr[left_node_index] = arr[i];
                arr[i] = temp;
                rebuild_heap_from_top(arr, left_node_index, n);
            }
        }
    }
}
