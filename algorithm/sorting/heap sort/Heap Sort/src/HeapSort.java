public class HeapSort {
    public static void heapSort(int[] inArr) {
        int n = inArr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(inArr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = inArr[0];
            inArr[0] = inArr[i];
            inArr[i] = temp;
            heapify(inArr, i, 0);
        }
    }

    private static void heapify(int[] inArr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && inArr[l] > inArr[largest]) {
            largest = l;
        }
        if (r < n && inArr[r] > inArr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = inArr[i];
            inArr[i] = inArr[largest];
            inArr[largest] = temp;
            heapify(inArr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] a = {29, 24, 20, 37, 14};
        heapSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
