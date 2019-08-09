package com.learn.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequenceStackTest {
  private SequenceStack<String> emptySequenceStack;
  private SequenceStack<String> fullSequenceStack;

  @BeforeEach
  void setUp() {
    emptySequenceStack = new SequenceStack<>(5);
    fullSequenceStack = new SequenceStack<>(5);
    fullSequenceStack.push("1");
    fullSequenceStack.push("2");
    fullSequenceStack.push("3");
    fullSequenceStack.push("4");
    fullSequenceStack.push("5");
  }

  @Test
  void should_push_successfully_given_empty_stack_when_push_data() {
    assertArrayEquals(fullSequenceStack.toArray(), new String[]{"1", "2", "3", "4", "5"});
    assertEquals(fullSequenceStack.size(), 5);
  }

  @Test
  void should_push_failed_given_full_stack_when_push_data() {
    assertFalse(fullSequenceStack.push("6"));
  }

  @Test
  void should_pop_successfully_given_full_stack_when_pop_data() {
    assertEquals(fullSequenceStack.pop(), "5");
  }

  @Test
  void should_get_null_given_empty_stack_when_pop_data() {
    assertNull(emptySequenceStack.pop());
  }
}
