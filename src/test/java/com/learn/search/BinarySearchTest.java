package com.learn.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {
  private int[] list;
  private int[] repeatList;
  private BinarySearch binarySearch;

  @BeforeEach
  void setUp() {
    list = new int[] {12, 23, 34, 36, 78, 89, 90, 95, 98, 101, 121};
    repeatList = new int[] {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
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

  @Test
  void should_get_first_index_successfully_given_a_sorted_list_and_a_number() {
    assertEquals(binarySearch.getFirst(repeatList, 10, 8), 5);
  }

  @Test
  void should_get_last_index_successfully_given_a_sorted_list_and_a_number() {
    assertEquals(binarySearch.getLast(repeatList, 10, 8), 7);
  }

  @Test
  void should_get_first_great_than_index_successfully_given_a_sorted_list_and_a_number() {
    assertEquals(binarySearch.getFirstGreatThan(repeatList, 10, 5), 3);
  }

  @Test
  void should_get_last_less_than_index_successfully_given_a_sorted_list_and_a_number() {
    assertEquals(binarySearch.getLastLessThan(repeatList, 10, 7), 4);
  }
}
