package com.learn.linkedlist.basic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UnidirectionalLinkedListTest {
  private UnidirectionalLinkedList<String> emptyList;
  private UnidirectionalLinkedList<String> emptyList2;
  private UnidirectionalLinkedList<String> emptyList3;

  @BeforeEach
  void setUp() {
    emptyList = new UnidirectionalLinkedList<>();
    emptyList2 = new UnidirectionalLinkedList<>();
    emptyList3 = new UnidirectionalLinkedList<>();
  }

  @Test
  void should_return_0_given_empty_list_when_get_size() {
    assertEquals(emptyList.size(), 0);
  }

  @Test
  void should_empty_given_empty_list_when_run_is_empty() {
    assertTrue(emptyList.isEmpty());
  }

  @Test
  void should_return_false_given_empty_list_when_contains_something() {
    assertFalse(emptyList.contains("1"));
  }

  @Test
  void should_return_true_given_list_when_contains_null_or_other_value() {
    emptyList2.add(null);
    emptyList2.add("one");
    assertTrue(emptyList2.contains(null));
    assertTrue(emptyList2.contains("one"));
    assertFalse(emptyList2.contains("two"));
  }

  @Test
  void should_add_successfully_given_list_when_insert() {
    emptyList2.add("one");
    assertEquals(emptyList2.size(), 1);
  }

  @Test
  void should_get_value_given_list() {
    emptyList2.add("one");
    emptyList2.add("two");
    emptyList2.add("three");
    emptyList2.add("four");
    assertEquals(emptyList2.size(), 4);
    assertEquals(emptyList2.get(0), "one");
    assertEquals(emptyList2.get(3), "four");
  }

  @Test
  void should_throw_exception_given_list_when_out_of_bounds() {
    emptyList2.add("one");
    assertThrows(IndexOutOfBoundsException.class, () -> emptyList2.get(1));
  }

  @Test
  void should_remove_successfully() {
    emptyList2.add(null);
    emptyList2.add("one");
    emptyList2.add("two");

    assertEquals(emptyList2.size(), 3);
    assertTrue(emptyList2.remove("two"));
    assertEquals(emptyList2.get(1), "one");
    assertEquals(emptyList2.size(), 2);
    assertFalse(emptyList2.remove("three"));
  }

  @Test
  void should_clear_successfully() {
    emptyList2.add("one");
    emptyList2.add("two");
    emptyList2.clear();

    assertEquals(emptyList2.size(), 0);
  }

  @Test
  void should_to_array_given_list() {
    emptyList2.add("one");
    emptyList2.add("two");
    assertArrayEquals(emptyList2.toArray(), new String[] {"one", "two"});
  }

  @Test
  void should_return_index_given_list_and_value() {
    emptyList2.add("one");
    emptyList2.add("two");
    assertEquals(emptyList2.indexOf("one"), 0);
    assertEquals(emptyList2.indexOf("two"), 1);
  }

  @Test
  void should_remove_first_element_successfully_given_list() {
    emptyList2.add("one");
    emptyList2.add("two");
    assertEquals(emptyList2.size(), 2);
    assertTrue(emptyList2.removeFirst());
    assertEquals(emptyList2.size(), 1);
    assertEquals(emptyList2.get(0), "two");
  }

  @Test
  void should_remove_element_successfully_given_list_and_index() {
    emptyList2.add("one");
    emptyList2.add("two");
    assertEquals(emptyList2.size(), 2);
    assertTrue(emptyList2.removeAt(1));
    assertEquals(emptyList2.size(), 1);
    assertEquals(emptyList2.get(0), "one");
  }

  @Test
  void should_remove_last_element_successfully_given_list() {
    emptyList2.add("one");
    emptyList2.add("two");
    assertEquals(emptyList2.size(), 2);
    assertTrue(emptyList2.removeLast());
    assertEquals(emptyList2.size(), 1);
    assertEquals(emptyList2.get(0), "one");
  }

  @Test
  void should_add_first_element_successfully_given_list() {
    emptyList2.add("one");
    emptyList2.add("two");
    assertEquals(emptyList2.size(), 2);
    assertTrue(emptyList2.addFirst("three"));
    assertEquals(emptyList2.size(), 3);
    assertEquals(emptyList2.get(0), "three");
  }

  @Test
  void should_get_middle_value_given_empty_list() {
    assertNull(emptyList2.getMiddle());
  }

  @Test
  void should_get_middle_value_given_one_element_list() {
    emptyList2.add("one");

    assertEquals(emptyList2.getMiddle(), "one");
  }

  @Test
  void should_get_middle_value_given_list() {
    emptyList2.add("one");
    emptyList2.add("two");
    emptyList2.add("three");
    emptyList2.add("four");
    emptyList2.add("five");

    assertEquals(emptyList2.getMiddle(), "three");
  }

  @Test
  void should_get_middle_value_given_odd_list() {
    emptyList2.add("one");
    emptyList2.add("two");
    emptyList2.add("three");
    emptyList2.add("four");
    emptyList2.add("five");
    emptyList2.add("six");
    emptyList2.add("seven");
    emptyList2.add("eight");

    assertEquals(emptyList2.getMiddle(), "four");
  }

  @Test
  void should_has_no_circle_given_a_list_without_circle() {
    emptyList2.add("one");
    emptyList2.add("two");
    emptyList2.add("three");
    emptyList2.add("four");
    assertFalse(emptyList2.hasCircle());
  }

  @Test
  void should_has_no_circle_given_a_list_with_circle() {
    emptyList2.add("one");
    emptyList2.add("two");
    emptyList2.add("three");
    emptyList2.add("four");
    emptyList2.addCircle();
    assertTrue(emptyList2.hasCircle());
  }

  @Test
  void should_sort_merge_successfully_given_empty_list_and_a_list_with_value() {
    emptyList3.add("1");
    emptyList3.add("2");
    emptyList2.merge(emptyList3);
    assertArrayEquals(emptyList2.toArray(), new String[] {"1", "2"});
  }

  @Test
  void should_sort_merge_successfully_given_merge_empty_list_and_a_origin_list_with_value() {
    emptyList2.add("1");
    emptyList2.add("2");
    emptyList2.merge(emptyList3);
    assertArrayEquals(emptyList2.toArray(), new String[] {"1", "2"});
  }

  @Test
  void should_sort_merge_successfully_given_empty_list_with_value_and_a_origin_list_with_value() {
    emptyList2.add("1");
    emptyList2.add("2");
    emptyList2.add("5");
    emptyList2.add("6");
    emptyList2.add("9");
    emptyList3.add("3");
    emptyList3.add("4");
    emptyList3.add("7");
    emptyList3.add("8");
    emptyList2.merge(emptyList3);
    assertArrayEquals(
        emptyList2.toArray(), new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"});
  }

  @Test
  void should_sort_merge_successfully_given_a_empty_list_with_value_and_a_origin_list_with_value() {
    emptyList2.add("3");
    emptyList2.add("4");
    emptyList2.add("7");
    emptyList2.add("8");
    emptyList3.add("1");
    emptyList3.add("2");
    emptyList3.add("5");
    emptyList3.add("6");
    emptyList3.add("9");
    emptyList2.merge(emptyList3);
    assertArrayEquals(
        emptyList2.toArray(), new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"});
  }
}
