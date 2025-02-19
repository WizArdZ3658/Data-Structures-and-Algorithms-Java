package sorting;

import sorting.interfaces.SortingClass;

public class BubbleSort implements SortingClass {

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = n-1; i >= 1; i--) {
            boolean swapped = false;
            for (int j = 1; j <= i; j++) {
                if (arr[j-1] > arr[j]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,5,9,7,5,4};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        bubbleSort.printArray(arr);
    }
}
