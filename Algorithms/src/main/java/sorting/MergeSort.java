package sorting;

import sorting.interfaces.SortingClass;

public class MergeSort implements SortingClass {

    public int[] recur(int left, int right, int[] arr) {
        if (left == right) {
            return new int[]{arr[left]};
        }
        int mid = left + (right-left)/2;
        int[] result = new int[right-left+1];

        int[] leftArr = this.recur(left, mid, arr);
        int[] rightArr = this.recur(mid+1, right, arr);

        int pointer = 0;
        int leftPointer = 0;
        int rightPointer = 0;
        while (leftPointer < leftArr.length && rightPointer < rightArr.length) {
            if (leftArr[leftPointer] <= rightArr[rightPointer]) {
                result[pointer] = leftArr[leftPointer];
                leftPointer++;
            } else {
                result[pointer] = rightArr[rightPointer];
                rightPointer++;
            }
            pointer++;
        }

        while(leftPointer < leftArr.length) {
            result[pointer] = leftArr[leftPointer];
            leftPointer++;
            pointer++;
        }

        while(rightPointer < rightArr.length) {
            result[pointer] = rightArr[rightPointer];
            rightPointer++;
            pointer++;
        }

        return result;
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        int[] result = this.recur(0, n-1, arr);
        System.arraycopy(result, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {13, 3, 1, 2, 5, -9, 7, 5, -4};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        mergeSort.printArray(arr);
    }
}
