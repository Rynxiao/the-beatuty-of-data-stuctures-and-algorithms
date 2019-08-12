package com.learn.queue;

public class ConsumerAndProducer {
  public static void main(String[] args) {
    ArrayQueue arrayQueue = new ArrayQueue(5);
    Producer producer = new Producer(arrayQueue);
    Consumer consumer = new Consumer(arrayQueue);
    Consumer consumer2 = new Consumer(arrayQueue);
    Thread producerThread = new Thread(producer);
    Thread consumerThread = new Thread(consumer);
    Thread consumerThread2 = new Thread(consumer2);
    producerThread.start();
    consumerThread.start();
    consumerThread2.start();
  }
}
