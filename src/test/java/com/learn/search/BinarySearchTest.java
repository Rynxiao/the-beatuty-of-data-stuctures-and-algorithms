package com.learn.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {
  private int[] list;
  private BinarySearch binarySearch;

  @BeforeEach
  void setUp() {
    list = new int[] {12, 23, 34, 36, 78, 89, 90, 95, 98, 101, 121};
    binarySearch = new BinarySearch();
  }

  @Test
  void should_search_index_successfully_given_a_sorted_list() {
    assertEquals(binarySearch.search(list, 11, 36), 3);
  }

  @Test
  void should_search_index_failed_given_a_sorted_list_and_a_unexpected_number() {
    assertEquals(binarySearch.search(list, 11, 77), -1);
  }

  @Test
  void should_search_index_successfully_given_a_sorted_list_when_use_internally_method() {
    assertEquals(binarySearch.search2(list, 11, 36), 3);
  }

  @Test
  void should_search_index_failed_given_a_sorted_list_and_a_unexpected_number_use_internally_method() {
    assertEquals(binarySearch.search2(list, 11, 77), -1);
  }
}
