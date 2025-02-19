package sorting;

import sorting.interfaces.SortingClass;

public class RadixSort implements SortingClass {

    @Override
    public void sort(int[] arr) {
        int maxElement = Integer.MIN_VALUE;
        for (int element : arr) {
            maxElement = Math.max(element, maxElement);
        }

        for (int i = 1; maxElement/i > 0; i*=10) {
            this.countSort(arr, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {11,12,3,1,2,5,9,7,5,4};
        SortingClass radixSort = new RadixSort();
        radixSort.sort(arr);
        radixSort.printArray(arr);
    }

    private void countSort(int[] arr, int exp)
    {
        int n = arr.length;
        int[] result = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            result[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.arraycopy(result, 0, arr, 0, n);
    }
}
