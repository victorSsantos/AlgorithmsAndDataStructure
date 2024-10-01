package com.leetcode.algorithms;

import java.util.Arrays;

public class Sort {

    //<editor-fold desc="QuickSort">
    public void quickSort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int init, int end){
        if(init < end){
            int pivot = partition(arr, init, end);
            quickSort(arr, init, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private int partition(int[] arr, int init, int end){
        int pivot = arr[end], i = init;

        for( var j = init ; j <= end ; j++){
            if(arr[j] < pivot){
                int aux = arr[j];
                arr[j] = arr[i];
                arr[i++] = aux;
            }
        }

        int aux = arr[i];
        arr[i] = arr[end];
        arr[end] = aux;

        return i;
    }
    //</editor-fold>

    //<editor-fold desc="MergeSort">
    public int[] mergeSort(int[] arr){
        int middle = arr.length/2;
        int[] arr1 = Arrays.copyOfRange(arr, 0, middle);
        int[] arr2 = Arrays.copyOfRange(arr, middle, arr.length);

        arr1 = arr1.length >= 2 ? mergeSort(arr1) : arr1;
        arr2 = arr2.length >= 2 ? mergeSort(arr2) : arr2;

        return mergeSort(arr1,arr2);
    }

    private int[] mergeSort(int[] arr1, int[]arr2){
        int[] mergedArr = new int[arr1.length + arr2.length];
        int indexArr1 = 0, indexArr2 = 0;

        for(var i = 0 ; i <= mergedArr.length - 1 ; i++ ){

            if(indexArr1 > arr1.length - 1) mergedArr[i] = arr2[indexArr2++];
            else if (indexArr2 > arr2.length - 1) mergedArr[i] = arr1[indexArr1++];
            else if (arr1[indexArr1] < arr2[indexArr2]) mergedArr[i] = arr1[indexArr1++];
            else mergedArr[i] = arr2[indexArr2++];
        }
        return mergedArr;
    }
    //</editor-fold>

    //<editor-fold desc="BubbleSort">
    public void bubbleSort(int[] arr){
        int n = arr.length - 1;

        for(var j = 0 ; j <= n ; j++) {
            for(var i = 0 ; i < n ; i++) {
                if(arr[i] > arr[i+1]){
                    int aux = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = aux;
                }
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="HeapSort">
    public void heapSort(int[] arr){
        int size = arr.length;

        for(var i = (size/2) - 1 ; i >= 0 ; i--) maxHeapfy(arr, i, size);

        for(var j = arr.length - 1; j >= 1; j--){
            swap(arr, 0, j);
            maxHeapfy(arr, 0, --size);
        }
    }

    private void maxHeapfy(int[] arr, int index, int size){
        var left = (2 * index) + 1;
        var right = (2 * index) + 2;
        var largest = index;

        if(left < size && arr[left] > arr[largest]) largest = left;
        if(right < size && arr[right] > arr[largest]) largest = right;

        if(largest != index){
            swap(arr, index, largest);
            maxHeapfy(arr, largest, size);
        }
    }

    private static void swap(int[] arr, int a, int b){
        var temp = arr[b];
        arr[b] = arr[a];
        arr[a]= temp;
    }
    //</editor-fold>
}


