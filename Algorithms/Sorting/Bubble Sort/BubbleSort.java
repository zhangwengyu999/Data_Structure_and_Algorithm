public class BubbleSort {
    public static void bubbleSort(int[] inArr) {
        int n = inArr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (inArr[j] > inArr[j + 1]) {
                    int temp = inArr[j];
                    inArr[j] = inArr[j + 1];
                    inArr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {29, 24, 20, 37, 14};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
