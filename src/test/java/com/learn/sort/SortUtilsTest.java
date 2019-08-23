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
}
