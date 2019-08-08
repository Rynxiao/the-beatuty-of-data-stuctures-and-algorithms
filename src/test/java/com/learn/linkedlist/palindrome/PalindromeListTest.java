package com.learn.linkedlist.palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeListTest {

  @Test
  void should_be_palindrome_linked_list() {
    PalindromeList palindromeList = new PalindromeList();
    palindromeList.add("1");
    palindromeList.add("2");
    palindromeList.add("3");
    palindromeList.add("2");
    palindromeList.add("1");

    assertTrue(palindromeList.isPalindrome());
  }

  @Test
  void should_be_not_palindrome_linked_list() {
    PalindromeList palindromeList = new PalindromeList();
    palindromeList.add("1");
    palindromeList.add("2");
    palindromeList.add("3");
    palindromeList.add("2");
    palindromeList.add("5");

    assertFalse(palindromeList.isPalindrome());
  }
}
