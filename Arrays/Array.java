import java.util.*;

class ArrayOperations {

    // Insertion
    void insert(int arr[], int data, int pos, int size) {
        if (pos < 0 || pos > size) {
            System.out.println("Invalid position");
        }
        else {
            for (int i = size - 1; i >= pos; i--) {
                arr[i + 1] = arr[i];
            }

            arr[pos] = data;
        }
    }

    // Delete by position
    void deletepos(int arr[], int pos, int size) {
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid position");
        }
        else {
            for (int i = pos; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }

            arr[size - 1] = 0;
        }
    }

    // Delete by data
    int deletedata(int arr[], int data, int size) {
        int pos = linearSearch(arr, data, size);

        if (pos == -1) {
            System.out.println("Data not found");
            return size;
        }
        else {
            deletepos(arr, pos, size);
            return size - 1;
        }
    }

    // Linear Search
    int linearSearch(int arr[], int data, int size) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == data) {
                return i;
            }
        }

        return -1;
    }

    // Binary Search
    // Array must be sorted
    int binarySearch(int arr[], int data, int size) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == data) {
                return mid;
            }
            else if (arr[mid] < data) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    // Bubble Sort
    void bubbleSort(int arr[], int size) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort
    void selectionSort(int arr[], int size) {
        for (int i = 0; i < size - 1; i++) {
            int min = i;

            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    // Insertion Sort
    void insertionSort(int arr[], int size) {
        for (int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Merge Sort
    void mergeSort(int arr[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    // Merge two sorted halves
    void merge(int arr[], int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int left[] = new int[n1];
        int right[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }

        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = low;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    // Quick Sort
    // Pivot = Last element
    void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition using last element as pivot
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Reverse
    void reverse(int arr[], int size) {
        int s = 0;
        int e = size - 1;

        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;

            s++;
            e--;
        }
    }

    // Display
    void display(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}


public class Array {

    public static void main(String[] args) {

        ArrayOperations arr = new ArrayOperations();

        int a[] = new int[20];

        a[0] = 1;
        a[1] = 2;
        a[2] = 3;

        int curr = 3;

        System.out.println("Original Array:");
        arr.display(a, curr);


        // INSERTION

        arr.insert(a, 4, 1, curr);
        curr++;

        System.out.println("\nAfter insertion:");
        arr.display(a, curr);


        // DELETION BY POSITION

        arr.deletepos(a, 2, curr);
        curr--;

        System.out.println("\nAfter deleting position 2:");
        arr.display(a, curr);


        // INSERT MORE ELEMENTS

        arr.insert(a, 10, curr, curr);
        curr++;

        arr.insert(a, 5, curr, curr);
        curr++;

        System.out.println("\nAfter inserting more elements:");
        arr.display(a, curr);


        // LINEAR SEARCH

        int result = arr.linearSearch(a, 5, curr);

        if (result == -1) {
            System.out.println("Linear Search: Data not found");
        }
        else {
            System.out.println("Linear Search: Data found at index " + result);
        }


        // DELETE BY DATA

        curr = arr.deletedata(a, 10, curr);

        System.out.println("\nAfter deleting data 10:");
        arr.display(a, curr);


        // BUBBLE SORT

        arr.bubbleSort(a, curr);

        System.out.println("\nAfter Bubble Sort:");
        arr.display(a, curr);


        // BINARY SEARCH

        result = arr.binarySearch(a, 5, curr);

        if (result == -1) {
            System.out.println("Binary Search: Data not found");
        }
        else {
            System.out.println("Binary Search: Data found at index " + result);
        }


        // SELECTION SORT

        arr.selectionSort(a, curr);

        System.out.println("\nAfter Selection Sort:");
        arr.display(a, curr);


        // INSERTION SORT

        arr.insertionSort(a, curr);

        System.out.println("\nAfter Insertion Sort:");
        arr.display(a, curr);


        // MERGE SORT

        arr.mergeSort(a, 0, curr - 1);

        System.out.println("\nAfter Merge Sort:");
        arr.display(a, curr);


        // QUICK SORT

        arr.quickSort(a, 0, curr - 1);

        System.out.println("\nAfter Quick Sort:");
        arr.display(a, curr);


        // REVERSE

        arr.reverse(a, curr);

        System.out.println("\nAfter Reversing:");
        arr.display(a, curr);

    }
}
