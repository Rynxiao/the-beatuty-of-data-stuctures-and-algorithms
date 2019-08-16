package com.learn.sort;

public class BubbleSort implements SortUtils {

  @Override
  public void sort(int[] arr) {
    int len = arr.length;
    if (len > 1) {
      for (int i = 0; i < len; i++) {
        // 有无交换的标识
        boolean flag = false;
        for (int j = 0; j < len - i - 1; j++) {
          if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
            // 说明在i之后的所有数据都没有交换
            // 那么也就不需要比较后面的了
            flag = true;
          }
        }

        if (!flag) {
          break;
        }
      }
    }
  }
}
