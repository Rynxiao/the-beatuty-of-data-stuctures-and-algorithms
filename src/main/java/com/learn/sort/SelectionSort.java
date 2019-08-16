package com.learn.sort;

public class SelectionSort implements SortUtils {
  @Override
  public void sort(int[] arr) {
    int len = arr.length;
    if (len > 1) {
      for (int i = 0; i < len; i++) {
        int low = arr[i];
        int lowIndex = i;
        for (int j = i + 1; j < len; j++) {
          if (arr[j] < low) {
            low = arr[j];
            lowIndex = j;
          }
        }

        int temp = arr[i];
        arr[i] = low;
        arr[lowIndex] = temp;
      }
    }
  }
}
