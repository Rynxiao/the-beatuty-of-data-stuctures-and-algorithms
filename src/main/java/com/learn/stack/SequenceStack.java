package com.learn.stack;

// 栈既可以用数组来实现，也可以用链表来实现。用数组实现的栈，我们叫作顺序栈，
// 用链表实现的栈，我们叫作链式栈

public class SequenceStack<T> {
  private T[] items;   // 数组
  private int count;        // 栈中元素的个数
  private int n;            // 栈的大小

  public SequenceStack(int n) {
    //noinspection unchecked
    this.items = (T[]) new Object[n];
    this.n = n;
    this.count = 0;
  }

  public int size() {
    return count;
  }

  public T[] toArray() {
    return items;
  }

  public boolean push(T item) {
    if (count == n) {
      return false;
    }

    items[count] = item;
    count++;
    return true;
  }

  public T pop() {
    if (count == 0) {
      return null;
    }

    T item = items[count - 1];
    count--;
    return item;
  }
}
