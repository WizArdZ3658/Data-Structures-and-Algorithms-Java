package sorting.interfaces;

public interface SortingClass {
    public void sort(int[] arr);

    public default void printArray(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length-1]);
        System.out.println();
    }
}
