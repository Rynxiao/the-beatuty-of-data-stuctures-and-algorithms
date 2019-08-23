package com.learn.sort;

public class QuickSort implements SortUtils {
  @Override
  public void sort(int[] arr) {
    int len = arr.length;
    if (len > 1) {
      quickSort(arr, 0, len - 1);
    }
  }

  private void quickSort(int[] arr, int start, int end) {
    if (start < end) {
      int q = partition(arr, start, end);
      quickSort(arr, start, q - 1);
      quickSort(arr, q + 1, end);
    }
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private int partition(int[] arr, int start, int end) {
    int pivot = arr[end];
    int i = start;
    for (int j = start; j < end; j++) {
      if (arr[j] < pivot) {
        swap(arr, i, j);
        i++;
      }
    }
    swap(arr, i, end);
    return i;
  }
}
