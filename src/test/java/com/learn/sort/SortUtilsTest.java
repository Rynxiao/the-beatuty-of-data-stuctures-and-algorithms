package com.learn.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SortUtilsTest {
  private SortUtils sortUtils;
  private int[] arr;
  private int[] sortedArr;

  @BeforeEach
  void setUp() {
    arr = new int[] {5, 6, 1, 3, 2, 4, 7, 9, 8};
    sortedArr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
  }

  @Test
  void should_sort_successfully_given_arr_when_use_bubble_sort_way() {
    sortUtils = new BubbleSort();
    sortUtils.sort(arr);
    assertArrayEquals(arr, sortedArr);
  }

  @Test
  void should_sort_successfully_given_arr_when_use_insertion_sort_way() {
    sortUtils = new InsertionSort();
    sortUtils.sort(arr);
    assertArrayEquals(arr, sortedArr);
  }

  @Test
  void should_sort_successfully_given_arr_when_use_selection_sort_way() {
    sortUtils = new SelectionSort();
    sortUtils.sort(arr);
    assertArrayEquals(arr, sortedArr);
  }

  @Test
  void should_sort_successfully_given_arr_when_use_merge_sort_way() {
    sortUtils = new MergeSort();
    sortUtils.sort(arr);
    assertArrayEquals(arr, sortedArr);
  }

  @Test
  void should_sort_successfully_given_arr_when_use_quick_sort_way() {
    sortUtils = new QuickSort();
    sortUtils.sort(arr);
    assertArrayEquals(arr, sortedArr);
  }

  @Test
  void should_get_successfully_given_arr_when_use_quick_sort_way() {
    QuickSort quickSort = new QuickSort();
    assertEquals(quickSort.getMaxOf(arr, 3), 3);
  }

  @Test
  void should_get_successfully_given_arr_when_use_bucket_sort_way() {
    int[] arr = new int[] {22, 5, 11, 41, 45, 26, 29, 10, 7, 8, 30, 27, 42, 43, 40};
    BucketSort bucketSort = new BucketSort();
    bucketSort.sort(arr);
    assertArrayEquals(arr, new int[] {5, 7, 8, 10, 11, 22, 26, 27, 29, 30, 40, 41, 42, 43, 45});
  }

  @Test
  void should_get_successfully_given_arr_when_use_counting_sort_way() {
    int[] arr = new int[] {22, 5, 11, 41, 45, 26, 29, 10, 7, 8, 30, 27, 42, 43, 40};
    CountingSort countingSort = new CountingSort();
    countingSort.sort(arr);
    assertArrayEquals(arr, new int[] {5, 7, 8, 10, 11, 22, 26, 27, 29, 30, 40, 41, 42, 43, 45});
  }

  @Test
  void should_get_successfully_given_arr_when_use_radix_sort_way() {
    int[] arr = new int[] {22, 5, 11, 41, 45, 26, 29, 10, 7, 8, 30, 27, 42, 43, 40, 232};
    RadixSort radixSort = new RadixSort();
    radixSort.sort(arr);
    assertArrayEquals(arr, new int[] {5, 7, 8, 10, 11, 22, 26, 27, 29, 30, 40, 41, 42, 43, 45, 232});
  }
}
