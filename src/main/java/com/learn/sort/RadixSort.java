package com.learn.sort;

public class RadixSort implements SortUtils {
  private int findMaxOf(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  private int getRemainder(int n, int i) {
    return Math.floorDiv(n, (int) Math.pow(10, i)) % 10;
  }

  private void countingSort(int[] arr, int i) {
    int[] c = new int[10];
    int len = arr.length;
    for (int j = 0; j < len; j++) {
      int remainder = getRemainder(arr[j], i);
      c[remainder]++;
    }

    for (int k = 1; k < c.length; k++) {
      c[k] = c[k - 1] + c[k];
    }

    int[] tempArr = new int[len];
    for (int m = len - 1; m >= 0; m--) {
      int r2 = getRemainder(arr[m], i);
      tempArr[c[r2] - 1] = arr[m];
      c[r2]--;
    }

    for (int n = 0; n < len; n++) {
      arr[n] = tempArr[n];
    }
  }

  @Override
  public void sort(int[] arr) {
    int len = arr.length;
    if (len > 1) {
      int maxLengthOfNumber = String.valueOf(findMaxOf(arr)).length();
      for (int i = 0; i < maxLengthOfNumber; i++) {
        countingSort(arr, i);
      }
    }
  }
}
