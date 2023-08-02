import java.util.*;

public class HeapSort {

    static int counter = 0;
    public static void main(String[] args) {
        int MAX_SIZE = 50000;
        int MIN_NUMBER = -1000;
        int MAX_NUMBER = 1000;
        counter = 0;
        int[] arr = new int[MAX_SIZE];
        Random random = new Random();
        for (int i = 0; i < MAX_SIZE; i++) {
            arr[i] = random.nextInt(MAX_NUMBER - MIN_NUMBER) + MIN_NUMBER;
        }
        heapSort(arr);
        // System.out.println(Arrays.toString(arr));
        System.out.println("Number of comparisons: " + counter);
    }
    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heap(arr, i, 0);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void heap(int[] arr, int n, int i) {
        counter++;
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heap(arr, n, largest);
        }
    }
}
