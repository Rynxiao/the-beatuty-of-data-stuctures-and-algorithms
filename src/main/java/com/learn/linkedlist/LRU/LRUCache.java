package com.learn.linkedlist.LRU;

import java.util.HashMap;

class Node {
  int key;
  int value;
  Node prev;
  Node next;
}

public class LRUCache {
  private Node head;
  private Node tail;
  private HashMap<Integer, Node> map = null;
  private int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>();
  }

  public int getNode(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }

    Node founded = map.get(key);

    removeNode(founded);
    addToTop(founded);

    return founded.value;
  }

  public void putNode(int key, int value) {
    if (map.containsKey(key)) {
      Node founded = map.get(key);
      founded.value = value;
      removeNode(founded);
      addToTop(founded);
    } else {
      Node newNode = new Node();
      newNode.key = key;
      newNode.value = value;
      newNode.prev = null;
      newNode.next = null;

      if (map.size() >= capacity) {
        map.remove(tail.key);
        removeNode(tail);
      }

      addToTop(newNode);
      map.put(key, newNode);
    }
  }

  private void addToTop(Node node) {
    node.next = head;
    node.prev = null;

    if (head != null) {
      head.prev = node;
    }

    head = node;

    if (tail == null) {
      tail = head;
    }
  }

  private void removeNode(Node node) {
    Node prev;
    Node next;

    if (node == head) {
      next = head.next;
      next.prev = null;
      head.next = null;
      head = next;
      return;
    }

    if (node == tail) {
      prev = tail.prev;
      prev.next = null;
      tail.prev = null;
      tail = prev;
      return;
    }

    prev = node.prev;
    next = node.next;
    prev.next = next;
    next.prev = prev;
    node.prev = null;
    node.next = null;
  }
}
