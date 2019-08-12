package com.learn.queue;

public class ArrayQueue {
  private String[] items;
  private int n = 0;
  private int head = 0;
  private int tail = 0;

  public ArrayQueue(int capacity) {
    items = new String[capacity];
    n = capacity;
  }

  public synchronized boolean enqueue(String item) {
    if (tail == n) {
      // tail ==n && head==0，表示整个队列都占满了
      if (head == 0) {
        return false;
      }

      for (int i = head; i < tail; i++) {
        items[i - head] = items[i];
      }
      tail -= head;
      head = 0;
    }
    items[tail] = item;
    tail++;
    return true;
  }

  public synchronized String dequeue() {
    if (head == tail) {
      return null;
    }
    String ret = items[head];
    head++;
    return ret;
  }

  public boolean isEmpty() {
    return head == tail;
  }

  public boolean isFull() {
    return head == 0 && tail == n;
  }

  public int left() {
    return tail - head;
  }
}
