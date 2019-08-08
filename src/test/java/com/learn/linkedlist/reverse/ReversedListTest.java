package com.learn.linkedlist.reverse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReversedListTest {

  @Test
  void should_get_reverse_list_given_a_list() {
    ReversedList reversedList = new ReversedList();
    reversedList.add("one");
    reversedList.add("two");
    reversedList.add("three");
    reversedList.add("four");
    assertArrayEquals(reversedList.toArray(), new String[]{"one", "two", "three", "four"});

    reversedList.reverse();
    assertArrayEquals(reversedList.toArray(), new String[]{"four", "three", "two", "one"});
  }
}
