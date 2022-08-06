public class MergeSort {

    public static int[] mergeSort(int[] inArr) {
        int n = inArr.length;
        if (n <= 1) {
            return inArr;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = inArr[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = inArr[i];
        }
        int[] sortedLeft = mergeSort(left);
        int[] sortedRight = mergeSort(right);
        return merge(sortedLeft, sortedRight);
    }

    public static int[] merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int[] arr = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {29, 24, 20, 37, 14, 10, 9, 30};
        int[] sortedArr = mergeSort(arr);
        for (int i = 0; i < sortedArr.length; i++) {
            System.out.print(sortedArr[i] + " ");
        }
    }

}
