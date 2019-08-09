package com.learn.linkedlist.basic;

import java.util.Iterator;
import java.util.Objects;
import java.util.Random;

public class UnidirectionalLinkedList<T> implements Iterable<T> {

  private Node<T> head;
  private Node<T> last;
  private int size = 0;

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  // ===============================================
  // === export only for test palindrome/reverse ===
  // ===============================================
  protected Node getHead() {
    return head;
  }

  protected void setNode(Node<T> head, Node<T> last) {
    this.head = head;
    this.last = last;
  }
  // ===============================================
  // === export only for test palindrome/reverse ===
  // ===============================================

  public boolean contains(T o) {
    boolean found = false;
    Node cur = head;

    while (cur != null) {
      if (Objects.equals(o, cur.value)) {
        found = true;
        break;
      }
      cur = cur.next;
    }

    return found;
  }

  public Iterator<T> iterator() {
    return new Iterator<T>() {
      int index;

      @Override
      public boolean hasNext() {
        return index < size;
      }

      @Override
      public T next() {
        T value = get(index);
        index++;
        return value;
      }
    };
  }

  public T[] toArray() {
    Object[] objects = new Object[size];
    int index = 0;
    for (Node<T> cur = head; cur != null; cur = cur.next) {
      objects[index++] = cur.value;
    }
    return (T[]) objects;
  }

  public boolean add(T o) {
    Node<T> newNode = new Node<>(o);
    Node<T> l = last;
    last = newNode;

    if (l == null) {
      head = newNode;
    } else {
      l.next = newNode;
    }

    size++;
    return true;
  }

  public boolean remove(Object o) {
    boolean isRemoved = false;
    Node cur = head;
    Node prev = null;
    Node next = null;

    while (cur != null) {
      if (Objects.equals(o, cur.value)) {
        if (cur == head) {
          head = next;
        } else {
          cur.value = null;
          cur.next = null;

          prev.next = next;
        }
        isRemoved = true;
        break;
      }
      prev = cur;
      cur = cur.next;
      next = cur != null ? cur.next : null;
    }
    size--;

    return isRemoved;
  }

  public void clear() {
    Node cur = head;
    while (cur != null) {
      Node x = cur.next;

      if (x != null) {
        x.next = null;
        x.value = null;
      }

      cur = x;
    }

    head = null;
    size = 0;
  }

  public T get(int index) throws IndexOutOfBoundsException {
    checkIndexBounds(index);

    int findIndex = 0;
    Node<T> cur = head;
    while (index > findIndex) {
      cur = cur.next;
      findIndex++;
    }
    return cur.value;
  }

  private Node<T> getNode(int index) throws IndexOutOfBoundsException {
    checkIndexBounds(index);

    int findIndex = 0;
    Node<T> cur = head;
    while (index > findIndex) {
      cur = cur.next;
      findIndex++;
    }
    return cur;
  }

  private void checkIndexBounds(int index) {
    if (index > size - 1) {
      throw new IndexOutOfBoundsException("index out of bounds exception");
    }
  }

  public int indexOf(Object o) {
    int index = 0;
    for (Node<T> cur = head; cur != null; cur = cur.next) {
      if (Objects.equals(o, cur.value)) {
        break;
      }
      index++;
    }
    return index;
  }

  public boolean removeFirst() {
    Node<T> next = head.next;
    head.next = null;
    head.value = null;
    head = next;
    size--;
    return true;
  }

  public boolean removeAt(int index) {
    boolean isRemoved = false;
    Node<T> cur = head;
    Node<T> prev = null;
    Node<T> next = null;
    int idx = 0;

    if (index == 0) {
      removeFirst();
      isRemoved = true;
    } else {
      for (; cur != null; ) {
        if (idx == index) {
          cur.value = null;
          cur.next = null;

          prev.next = next;
          isRemoved = true;
          break;
        }
        prev = cur;
        cur = cur.next;
        next = cur != null ? cur.next : null;
        idx++;
      }
      size--;
    }

    return isRemoved;
  }

  public boolean removeLast() {
    return removeAt(size - 1);
  }

  public boolean addFirst(T o) {
    Node<T> newNode = new Node<>(o);
    newNode.next = head;
    head = newNode;
    size++;
    return true;
  }

  public T getMiddle() {
    Node fast = head;
    Node slow = head;

    if (head == null) {
      return null;
    }

    if (head.next == null) {
      return head.value;
    }

    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    return (T) slow.value;
  }

  public boolean hasCircle() {
    Node fast = head;
    Node slow = head;

    if (head == null || head.next == null) {
      return false;
    }

    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        return true;
      }
    }

    return false;
  }

  public void addCircle() {
    Random random = new Random();
    last.next = getNode(random.nextInt(size));
  }

  public boolean addAll(UnidirectionalLinkedList<T> list) {
    for (T item : list) {
      add(item);
    }
    return true;
  }

  public void merge(UnidirectionalLinkedList<T> list) {
    Node<T> dummyHead = new Node<T>();
    T[] ts = list.toArray();
    int tSize = list.size();

    int curCursor = 0;
    int tCursor = 0;

    if (head == null) {
      addAll(list);
      return;
    }

    if (tSize == 0) {
      return;
    }

    Node<T> cur = head;
    Node<T> newNode;
    Node<T> cursorHead = dummyHead;
    while (curCursor < size && tCursor < tSize) {
      int curValue = Integer.parseInt(cur.value.toString());
      int tValue = Integer.parseInt(ts[tCursor].toString());
      if (curValue < tValue) {
        newNode = new Node<T>(cur.value);
        cur = cur.next;
        curCursor++;
      } else {
        newNode = new Node<T>(ts[tCursor]);
        tCursor++;
      }

      cursorHead.next = newNode;
      cursorHead = newNode;
    }

    if (curCursor == size) {
      for (int i = tCursor; i < tSize; i++) {
        Node<T> leftNewNode = new Node<T>(ts[i]);
        cursorHead.next = leftNewNode;
        cursorHead = leftNewNode;
      }
    }

    if (tCursor == tSize) {
      cursorHead.next = getNode(curCursor);
    }

    head = dummyHead.next;
    size = size + tSize;
  }
}
