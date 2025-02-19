package sorting;

import sorting.interfaces.SortingClass;

public class InsertionSort implements SortingClass {

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i-1]) {
                int key = arr[i];
                int j = i-1;
                while(j>=0 && arr[j] > key) {
                    arr[j+1] = arr[j];
                    j--;
                }
                arr[j+1] = key;
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
