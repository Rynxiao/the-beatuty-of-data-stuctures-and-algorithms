package com.learn.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsumerAndProducerTest {
  private ArrayQueue arrayQueue;
  private Producer producer;
  private Consumer consumer;

  @BeforeEach
  void setUp() {
    arrayQueue = new ArrayQueue(5);
    producer = new Producer(arrayQueue);
    consumer = new Consumer(arrayQueue);
  }

  @Test
  void should_produce_and_consume_successfully() {
    Thread producerThread = new Thread(producer);
    Thread consumerThread = new Thread(consumer);
    producerThread.start();
    consumerThread.start();
  }
}
