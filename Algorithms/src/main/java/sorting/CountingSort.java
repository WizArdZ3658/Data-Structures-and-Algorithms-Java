package sorting;

import sorting.interfaces.SortingClass;

/*



 */

public class CountingSort implements SortingClass {

    @Override
    public void sort(int[] arr) {
        int maxElement = Integer.MIN_VALUE;
        for (int element : arr) {
            maxElement = Math.max(maxElement, element);
        }

        int[] counter = new int[maxElement+1];
        for (int element : arr) {
            counter[element]++;
        }

        for (int i = 1; i <= maxElement; i++) {
            counter[i] += counter[i-1];
        }

        int[] result = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
            result[counter[arr[i]]-1] = arr[i];
            counter[arr[i]]--;
        }

        System.arraycopy(result, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {11, 3,1,2,5,9,7,5,4};
        CountingSort countingSort = new CountingSort();
        countingSort.sort(arr);
        countingSort.printArray(arr);
    }
}
