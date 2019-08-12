package com.learn.queue;

import java.util.Random;

public class Producer implements Runnable {
  private ArrayQueue arrayQueue;

  public Producer(ArrayQueue arrayQueue) {
    this.arrayQueue = arrayQueue;
  }

  public boolean produce() {
    if (arrayQueue.isFull()) {
      return false;
    }
    int random = new Random().nextInt(100);
    arrayQueue.enqueue(String.valueOf(random));
    System.out.println("生产者生产: " + random + ", 目前剩余" + arrayQueue.left() + "个产品");
    return true;
  }

  @Override
  public void run() {
    try {
      while (true) {
        produce();
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
