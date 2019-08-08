package com.learn.linkedlist.reverse;

import com.learn.linkedlist.basic.Node;
import com.learn.linkedlist.basic.UnidirectionalLinkedList;

public class ReversedList extends UnidirectionalLinkedList {
  public void reverse() {
    Node head = super.getHead();
    Node last;

    if (head != null) {
      Node node1 = head;
      Node node2 = node1.next;

      while (node1 != null & node2 != null) {
        Node temp = node2.next;
        node2.next = node1;

        node1 = node2;
        node2 = temp;
      }

      head.next = null;
      last = head;
      head = node2 == null ? node1 : node2;

      super.setNode(head, last);
    }
  }
}
