public class InsertionSort {
    public static void insertionSort(int[] inArr) {
        int n = inArr.length;
        for (int i = 1; i < n; i++) {
            int key = inArr[i]; // The element to be inserted (C)
            int j = i - 1; // The element to be compared in the sorted part (S)
            // Find the position to insert the element (C)
            while (j >= 0 && inArr[j] > key) {
                inArr[j + 1] = inArr[j];
                j--;
            }
            inArr[j + 1] = key; // Insert the element (C)
        }
    }

    public static void main(String[] args) {
        int[] arr = {29, 24, 20, 37, 14};
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
