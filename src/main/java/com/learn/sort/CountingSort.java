package com.learn.sort;

public class CountingSort implements SortUtils {
  private int findMaxOf(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  @Override
  public void sort(int[] arr) {
    int len = arr.length;
    if (len > 1) {
      int n = findMaxOf(arr) + 1;

      // 计算每个元素的个数，放入 countingArr 中
      int[] countingArr = new int[n];
      for (int i = 0; i < len; i++) {
        countingArr[arr[i]]++;
      }

      // 依次累加
      for (int j = 1; j < n; j++) {
        countingArr[j] = countingArr[j - 1] + countingArr[j];
      }

      // 临时数组 tempArr，存储排序之后的结果
      int[] tempArr = new int[len];
      for (int k = len - 1; k >= 0; k--) {
        int index = countingArr[arr[k]] - 1;
        tempArr[index] = arr[k];
        countingArr[arr[k]]--;
      }

      // 将结果拷贝给 arr 数组
      for (int m = 0; m < len; m++) {
        arr[m] = tempArr[m];
      }
    }
  }
}
