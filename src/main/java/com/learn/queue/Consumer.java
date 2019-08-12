package com.learn.queue;

public class Consumer implements Runnable {
  private ArrayQueue arrayQueue;

  public Consumer(ArrayQueue arrayQueue) {
    this.arrayQueue = arrayQueue;
  }

  public String consume() {
    if (arrayQueue.isEmpty()) {
      return null;
    }
    String c = arrayQueue.dequeue();
    System.out.println("消费者消费: " + c);
    return c;
  }

  @Override
  public void run() {
    try {
      while (true) {
        Thread.sleep(1200);
        consume();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
