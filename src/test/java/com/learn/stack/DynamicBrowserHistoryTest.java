package com.learn.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DynamicBrowserHistoryTest {

  @Test
  void should_auto_expanse_capacity_given_full_stack_when_push_data() {
    DynamicSequenceStack<Integer> dynamicBrowserHistory = new DynamicSequenceStack<>();
    dynamicBrowserHistory.push(1);
    dynamicBrowserHistory.push(2);
    dynamicBrowserHistory.push(3);
    dynamicBrowserHistory.push(4);
    dynamicBrowserHistory.push(5);
    dynamicBrowserHistory.push(6);
    assertArrayEquals(dynamicBrowserHistory.toArray(), new Integer[] {1, 2, 3, 4, 5, 6});
  }
}
