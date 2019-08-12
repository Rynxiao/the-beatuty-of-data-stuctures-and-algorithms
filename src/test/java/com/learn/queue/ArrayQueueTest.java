package com.learn.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayQueueTest {

  private ArrayQueue arrayQueue;
  private ArrayQueue fullArrayQueue;

  @BeforeEach
  void setUp() {
    arrayQueue = new ArrayQueue(5);
    fullArrayQueue = new ArrayQueue(2);
    fullArrayQueue.enqueue("1");
    fullArrayQueue.enqueue("2");
  }

  @Test
  void should_enqueue_successfully_given_empty_queue_when_enqueue() {
    assertTrue(arrayQueue.enqueue("one"));
  }

  @Test
  void should_enqueue_failed_given_full_queue_when_enqueue() {
    assertFalse(fullArrayQueue.enqueue("3"));
  }

  @Test
  void should_dequeue_successfully_given_full_queue_when_dequeue() {
    assertEquals(fullArrayQueue.dequeue(), "1");
  }

  @Test
  void should_dequeue_failed_given_empty_queue_when_dequeue() {
    assertNull(arrayQueue.dequeue());
  }
}
