public class CountingSort {
    public static void countingSort(int[] inArr) {
        int n = inArr.length;
        int max = inArr[0];
        for (int i = 1; i < n; i++) {
            if (inArr[i] > max) {
                max = inArr[i];
            }
        }
        int[] countArr = new int[max + 1];
        for (int i = 0; i < n; i++) {
            countArr[inArr[i]]++;
        }
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }
        int[] sortedArr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sortedArr[countArr[inArr[i]] - 1] = inArr[i];
            countArr[inArr[i]]--;
        }
        for (int i = 0; i < n; i++) {
            inArr[i] = sortedArr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,8,7,1,2,7,3,9,8,2,1,4};
        countingSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
