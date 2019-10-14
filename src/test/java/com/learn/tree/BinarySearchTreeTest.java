package com.learn.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
  private BinarySearchTree binarySearchTree;

  @BeforeEach
  void setUp() {
    binarySearchTree = new BinarySearchTree();
    binarySearchTree.insert(33);
    binarySearchTree.insert(16);
    binarySearchTree.insert(50);
    binarySearchTree.insert(13);
    binarySearchTree.insert(18);
    binarySearchTree.insert(34);
    binarySearchTree.insert(58);
    binarySearchTree.insert(15);
    binarySearchTree.insert(17);
    binarySearchTree.insert(25);
    binarySearchTree.insert(51);
    binarySearchTree.insert(66);
    binarySearchTree.insert(19);
    binarySearchTree.insert(27);
    binarySearchTree.insert(55);
  }

  @Test
  void should_find_data_given_a_binary_search_tree() {
    assertEquals(27, binarySearchTree.find(27).getData());
  }

  @Test
  void should_insert_data_successfully_given_a_binary_search_tree() {
    binarySearchTree.insert(99);
    assertNotNull(binarySearchTree.find(99));
    assertEquals(99, binarySearchTree.find(99).getData());
  }

  @Test
  void should_delete_data_successfully_given_a_binary_search_tree() {
    binarySearchTree.delete(18);
    assertNull(binarySearchTree.find(18));
  }

  @Test
  void should_find_max_data_given_a_binary_search_tree() {
    assertEquals(66, binarySearchTree.findMax().getData());
  }

  @Test
  void should_find_min_data_given_a_binary_search_tree() {
    assertEquals(13, binarySearchTree.findMin().getData());
  }

  @Test
  void should_find_the_deep_of_tree_given_a_binary_search_tree() {
    assertEquals(5, binarySearchTree.getDeep());
  }

  @Test
  void order() {
//    binarySearchTree.preOrderImplement();
//    binarySearchTree.inOrderImplement();
//    binarySearchTree.postOrderImplement();
    binarySearchTree.levelOrderImplement();
  }
}
