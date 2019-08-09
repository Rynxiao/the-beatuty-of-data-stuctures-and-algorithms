package com.learn.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrowserHistoryTest {
  public static final String BASIC_URL = "https://rynxiao.com/post-";
  private BrowserHistory history;

  @BeforeEach
  void setUp() {
    history = new BrowserHistory();
    history.push(BASIC_URL + "1");
    history.push(BASIC_URL + "2");
    history.push(BASIC_URL + "3");
  }

  @Test
  void should_get_right_url_given_history_list_when_pop_history() {
    history.pop();
    assertEquals(history.url, BASIC_URL + "2");
  }

  @Test
  void should_get_right_url_given_history_list_when_replace_history() {
    history.replace(BASIC_URL + "4");
    assertEquals(history.url, BASIC_URL + "4");
  }

  @Test
  void should_get_right_url_given_history_list_when_go_back() {
    history.goBack();
    assertEquals(history.url, BASIC_URL + "2");
  }

  @Test
  void should_get_right_url_given_history_list_when_go_back_multiple_times() {
    history.go(-2);
    assertEquals(history.url, BASIC_URL + "1");
  }

  @Test
  void should_get_right_url_given_history_list_when_go_back_and_then_push() {
    history.go(-1);
    assertEquals(history.url, BASIC_URL + "2");

    history.push(BASIC_URL + "5");
    history.goBack();
    assertEquals(history.url, BASIC_URL + "2");
  }
}
