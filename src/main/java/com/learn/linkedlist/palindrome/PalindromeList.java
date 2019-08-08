package com.learn.linkedlist.palindrome;

import com.learn.linkedlist.basic.Node;
import com.learn.linkedlist.basic.UnidirectionalLinkedList;

import java.util.Objects;

public class PalindromeList extends UnidirectionalLinkedList {
  public boolean isPalindrome() {
    Node head = super.getHead();

    if (head == null || head.next == null) {
      return true;
    }

    // find the center of list
    Node fast = head;
    Node slow = head;

    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    Node subListHead = slow.next;
    slow.next = null;

    // reverse second list
    Node node1 = subListHead;
    Node node2 = subListHead.next;

    while (node1 != null && node2 != null) {
      Node temp = node2.next;
      node2.next = node1;

      node1 = node2;
      node2 = temp;
    }

    subListHead.next = null;

    // compare
    Node listHead1 = node2 == null ? node1 : node2;
    Node listHead2 = head;

    while (listHead1 != null) {
      if (!Objects.equals(listHead1.value, listHead2.value)) {
        return false;
      }
      listHead1 = listHead1.next;
      listHead2 = listHead2.next;
    }

    return true;
  }
}
