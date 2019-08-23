package com.learn.sort;

public class QuickSort implements SortUtils {
  @Override
  public void sort(int[] arr) {
    int len = arr.length;
    if (len > 1) {
      quickSort(arr, 0, len - 1);
    }
  }

  public int getMaxOf(int[] arr, int k) {
    int len = arr.length;
    if (len > 1) {
      return get(arr, 0, len - 1, k);
    }
    return -1;
  }

  private int get(int[] arr, int start, int end, int k) {
    int p = partition(arr, start, end);
    if (p + 1 == k) {
      return arr[p];
    } else if (p + 1 < k) {
      return get(arr, p + 1, end, k);
    } else {
      return get(arr, start, p - 1, k);
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
