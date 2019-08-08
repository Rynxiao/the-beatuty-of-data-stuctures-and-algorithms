package com.learn.linkedlist.basic;

public class Node<T> {
  public T value;
  public Node<T> next;

  Node() {
    this.value = null;
    this.next = null;
  }

  Node(T value) {
    this.value = value;
  }
}
