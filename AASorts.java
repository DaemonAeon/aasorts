/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aasorts;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author CARLOS EDUARDO
 */
public class AASorts {

    /**
     * @param args the command line arguments
     */
    private static int N;

    public static void main(String[] args) {
        int[] myarr;
        for (int i = 10; i <= 1000000; i *= 10) {
            myarr = createArray(i);
            System.out.println("\n\n" + i + " veces\n**********");

            System.out.println("Bubble Sort:");
            runAlgorithm(1, myarr.length, myarr);

            System.out.println("----------\nSelection Sort:");
            runAlgorithm(2, myarr.length, myarr);

            System.out.println("----------\nInsertion Sort:");
            runAlgorithm(3, myarr.length, myarr);

            System.out.println("----------\nHeapsort:");
            runAlgorithm(4, myarr.length, myarr);

            System.out.println("----------\nMergesort:");
            runAlgorithm(5, myarr.length, myarr);

            System.out.println("----------\nRadix Sort:");
            runAlgorithm(6, myarr.length, myarr);

            System.out.println("----------\nQuicksort:");
            runAlgorithm(7, myarr.length, myarr);
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void runAlgorithm(int algorithm, int size, int[] array) {
        long cont;

        switch (algorithm) {
            case 1: {//bubble
                for (int i = 0; i < 10; i++) {
                    shuffleArray(array);
                    cont = System.nanoTime();
                    bubbleSort(array);
                    System.out.println((double) (System.nanoTime() - cont) / 1000000000);
                }
                break;
            }
            case 2: {//selection
                for (int i = 0; i < 10; i++) {
                    shuffleArray(array);
                    cont = System.nanoTime();
                    selectionSort(array);
                    System.out.println((double) (System.nanoTime() - cont) / 1000000000);
                }
                break;
            }
            case 3: {//insertion
                for (int i = 0; i < 10; i++) {
                    shuffleArray(array);
                    cont = System.nanoTime();
                    insertionSort(array);
                    System.out.println((double) (System.nanoTime() - cont) / 1000000000);
                }
                break;
            }
            case 4: {//heap
                for (int i = 0; i < 10; i++) {
                    shuffleArray(array);
                    cont = System.nanoTime();
                    heapSort(array);
                    System.out.println((double) (System.nanoTime() - cont) / 1000000000);
                }
                break;
            }
            case 5: {//merge
                for (int i = 0; i < 10; i++) {
                    shuffleArray(array);
                    cont = System.nanoTime();
                    mergeSort(array);
                    System.out.println((double) (System.nanoTime() - cont) / 1000000000);
                }
                break;
            }
            case 6: {//radix
                for (int i = 0; i < 10; i++) {
                    shuffleArray(array);
                    cont = System.nanoTime();
                    radixSort(array);
                    System.out.println((double) (System.nanoTime() - cont) / 1000000000);
                }
                break;
            }
            case 7: {//quick
                for (int i = 0; i < 10; i++) {
                    shuffleArray(array);
                    cont = System.nanoTime();
                    quickSort(array, 0, array.length - 1);
                    System.out.println((double) (System.nanoTime() - cont) / 1000000000);
                }
                break;
            }
            default: {
                System.out.println("ERROR");
                break;
            }
        }
    }

    public static int[] createArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(size + 1);
        }
        return array;
    }

    public static void shuffleArray(int[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    //http://stackoverflow.com/questions/16088994/sorting-an-array-of-int-using-bubblesort
    public static void bubbleSort(int[] numArray) {
        int n = numArray.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (numArray[j - 1] > numArray[j]) {
                    temp = numArray[j - 1];
                    numArray[j - 1] = numArray[j];
                    numArray[j] = temp;
                }

            }
        }
    }

    //http://stackoverflow.com/questions/8362640/java-selection-sort-algorithm
    public static void selectionSort(int[] input) {
        int minimumValue = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; ++i) {
            for (int j = i; j < input.length; ++j) {
                if (input[j] <= minimumValue) {
                    minimumValue = input[j];
                    input[j] = input[i];
                    input[i] = minimumValue;
                }
            }
            minimumValue = Integer.MAX_VALUE;
        }
    }

    //http://www.journaldev.com/585/insertion-sort-in-java
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int valueToSort = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > valueToSort) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = valueToSort;
        }
    }

    //http://www.sanfoundry.com/java-program-implement-heap-sort/
    public static void heapSort(int arr[]) {
        heapify(arr);
        for (int i = N; i > 0; i--) {
            swap(arr, 0, i);
            N = N - 1;
            maxheap(arr, 0);
        }
    }

    public static void heapify(int arr[]) {
        N = arr.length - 1;
        for (int i = N / 2; i >= 0; i--) {
            maxheap(arr, i);
        }
    }

    public static void maxheap(int arr[], int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i]) {
            max = left;
        }
        if (right <= N && arr[right] > arr[max]) {
            max = right;
        }

        if (max != i) {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }

    public static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //http://stackoverflow.com/questions/13727030/mergesort-in-java
    public static void mergeSort(int[] in) {
        if (in.length < 2) {
            return; //do not need to sort
        }
        int mid = in.length / 2;
        int left[] = new int[mid];
        int right[] = new int[in.length - mid];
        for (int i = 0; i < mid; i++) { //copy left
            left[i] = in[i];
        }
        for (int i = 0; i < in.length - mid; i++) { //copy right
            right[i] = in[mid + i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, in);
    }

    private static void merge(int[] a, int[] b, int[] all) {
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) { //merge back
            if (a[i] < b[j]) {
                all[k] = a[i];
                i++;
            } else {
                all[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < a.length) { //left remaining
            all[k++] = a[i++];
        }
        while (j < b.length) { //right remaining
            all[k++] = b[j++];
        }
    }

    //https://rosettacode.org/wiki/Sorting_algorithms/Radix_sort
    public static void radixSort(int[] old) {
        for (int shift = Integer.SIZE - 1; shift > -1; shift--) {
            int[] tmp = new int[old.length];
            int j = 0;
            for (int i = 0; i < old.length; i++) {
                boolean move = old[i] << shift >= 0;
                if (shift == 0 ? !move : move) {
                    tmp[j] = old[i];
                    j++;
                } else {
                    old[i - j] = old[i];
                }
            }
            for (int i = j; i < tmp.length; i++) {
                tmp[i] = old[i - j];
            }
            old = tmp;
        }
    }

    //http://www.programcreek.com/2012/11/quicksort-array-in-java/
    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }

}
