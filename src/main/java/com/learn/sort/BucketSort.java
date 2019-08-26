package com.learn.sort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort implements SortUtils {
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
      int max = findMaxOf(arr);
      int base = 10;
      int n = max / base + 1;
      ArrayList[] buckets = new ArrayList[n];
      for (int i = 0; i < len; i++) {
        int bucketNo = Math.floorDiv(arr[i], base);
        if (buckets[bucketNo] != null) {
          buckets[bucketNo].add(arr[i]);
        } else {
          ArrayList<Integer> bucket = new ArrayList<>();

          bucket.add(arr[i]);
          buckets[bucketNo] = bucket;
        }
      }

      // 每个桶单独排序
      for (int j = 0; j < buckets.length; j++) {
        Collections.sort(buckets[j]);
      }

      // 合并桶数据
      int q = 0;
      for (int p = 0; p < buckets.length; p++) {
        for (int z = 0; z < buckets[p].size(); z++) {
          arr[q++] = (int) buckets[p].get(z);
        }
      }
    }
  }
}
