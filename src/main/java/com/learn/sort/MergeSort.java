package com.learn.sort;

public class MergeSort implements SortUtils {
  @Override
  public void sort(int[] arr) {
    int len = arr.length;
    if (len > 1) {
      mergeSort(arr, 0, len - 1);
    }
  }

  private void mergeSort(int[] arr, int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      mergeSort(arr, start, mid);
      mergeSort(arr, mid + 1, end);
      merge(arr, start, mid, end);
    }
  }

  private void merge(int[] arr, int start, int mid, int end) {
    int i = start;
    int j = mid + 1;
    int k = 0;
    int[] temp = new int[end - start + 1];
    while (i <= mid && j <= end) {
      if (arr[i] <= arr[j]) {
        temp[k++] = arr[i++];
      } else {
        temp[k++] = arr[j++];
      }
    }

    int p = i;
    int q = mid;

    if (j <= end) {
      p = j;
      q = end;
    }

    while (p <= q) {
      temp[k++] = arr[p++];
    }

    for (int ii = 0; ii < temp.length; ii++) {
      arr[start + ii] = temp[ii];
    }
  }
}
