package com.learn.stack;

public class DynamicSequenceStack<T> {
  public static final int BASIC_SIZE = 5;
  private T[] items; // 数组
  private int count; // 栈中元素的个数
  private int n; // 栈的大小

  public DynamicSequenceStack() {
    //noinspection unchecked
    this.items = (T[]) new Object[BASIC_SIZE];
    this.n = BASIC_SIZE;
    this.count = 0;
  }

  public int size() {
    return count;
  }

  public T[] toArray() {
    //noinspection unchecked
    T[] list = (T[]) new Object[count];
    System.arraycopy(items, 0, list, 0, count);
    return list;
  }

  private void expanseCapacity() {
    T[] temp = this.items;
    int tempSize = n;

    n = 2 * n;
    //noinspection unchecked
    items = (T[]) new Object[this.n];
    if (tempSize >= 0) System.arraycopy(temp, 0, items, 0, tempSize);
  }

  public boolean push(T item) {
    if (count == n) {
      expanseCapacity();
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

  public void clear() {
    count = 0;
  }

  public T top() {
    return items[count - 1];
  }
}
