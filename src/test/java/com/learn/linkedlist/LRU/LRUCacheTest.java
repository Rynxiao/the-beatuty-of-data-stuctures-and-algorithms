package com.learn.linkedlist.LRU;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {
  private LRUCache lruCache;

  @BeforeEach
  void setUp() {
    lruCache = new LRUCache(5);
  }

  @Test
  void getNode() {
    lruCache.putNode(1, 1);
    lruCache.putNode(10, 15);
    lruCache.putNode(15, 10);
    lruCache.putNode(10, 16);
    lruCache.putNode(12, 15);
    lruCache.putNode(18, 10);
    lruCache.putNode(13, 16);
    lruCache.putNode(12, 26);
    lruCache.putNode(17, 26);

    assertEquals(lruCache.getNode(1), -1);
    assertEquals(lruCache.getNode(10), 16);
    assertEquals(lruCache.getNode(15), -1);
    assertEquals(lruCache.getNode(12), 26);

  }

  @Test
  void putNode() {}
}
