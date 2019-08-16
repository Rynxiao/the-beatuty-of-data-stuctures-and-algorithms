package com.learn.sort;

public class InsertionSort implements SortUtils {
  @Override
  public void sort(int[] arr) {
    int len = arr.length;
    if (len > 1) {
      for (int i = 1; i < len; i++) {
        int value = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > value) {
          // 移动位置
          arr[j + 1] = arr[j];
          j--;
        }
        arr[j + 1] = value;
      }
    }
  }
}
