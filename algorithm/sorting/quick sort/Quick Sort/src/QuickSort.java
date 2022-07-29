public class QuickSort {
    public static void quickSort(int[] inArr) {
        quickSort(inArr, 0, inArr.length - 1);
    }

    private static void quickSort(int[] inArr, int low, int high) {
        if (low < high) {
            int pivot = partition(inArr, low, high);
            quickSort(inArr, low, pivot - 1);
            quickSort(inArr, pivot + 1, high);
        }
    }

    private static int partition(int[] inArr, int low, int high) {
        int pivot = inArr[low];
        while (low < high) {
            while (low < high && inArr[high] >= pivot) {
                high--;
            }
            inArr[low] = inArr[high];
            while (low < high && inArr[low] <= pivot) {
                low++;
            }
            inArr[high] = inArr[low];
        }
        inArr[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {29, 24, 20, 37, 34, 10, 30, 9};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
