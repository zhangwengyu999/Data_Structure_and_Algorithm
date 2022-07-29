public class SelectionSort {
    public static void selectionSort(int[] inArr) {
        int n = inArr.length;
        for (int i = 0; i < n; i++) {
            int minEle = i; // Default smallest element is the first element
            for (int j = i + 1; j < n; j++) { // Find the smallest element iteratively
                if (inArr[j] < inArr[minEle]) {
                    minEle = j;
                }
            }
            // Swap the smallest element with the front element
            if (minEle != i) {
                int temp = inArr[i];
                inArr[i] = inArr[minEle];
                inArr[minEle] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {29, 24, 20, 37, 14};
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
