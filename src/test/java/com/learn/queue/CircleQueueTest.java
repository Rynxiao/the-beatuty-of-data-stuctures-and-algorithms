package com.learn.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CircleQueueTest {
  private CircleQueue circleQueue;
  private CircleQueue fullCircleQueue;

  @BeforeEach
  void setUp() {
    circleQueue = new CircleQueue(5);
    fullCircleQueue = new CircleQueue(2);
    fullCircleQueue.enqueue("1");
    fullCircleQueue.enqueue("2");
  }

  @Test
  void should_enqueue_successfully_given_empty_queue_when_enqueue() {
    assertTrue(circleQueue.enqueue("one"));
  }

  @Test
  void should_enqueue_failed_given_full_queue_when_enqueue() {
    assertFalse(fullCircleQueue.enqueue("3"));
  }

  @Test
  void should_dequeue_successfully_given_full_queue_when_dequeue() {
    assertEquals(fullCircleQueue.dequeue(), "1");
  }

  @Test
  void should_dequeue_failed_given_empty_queue_when_dequeue() {
    assertNull(circleQueue.dequeue());
  }

  @Test
  void should_enqueue_successfully_given_full_queue_when_dequeue_twice_and_enqueue() {
    fullCircleQueue.dequeue();
    fullCircleQueue.dequeue();
    assertTrue(fullCircleQueue.enqueue("4"));
  }
}
