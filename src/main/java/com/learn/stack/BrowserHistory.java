package com.learn.stack;

public class BrowserHistory {
  private DynamicSequenceStack<String> forwardStack;
  private DynamicSequenceStack<String> backStack;
  public String url;

  public BrowserHistory() {
    this.forwardStack = new DynamicSequenceStack<>();
    this.backStack = new DynamicSequenceStack<>();
  }

  private boolean canForward() {
    return backStack.size() > 0;
  }

  private boolean canBack() {
    return forwardStack.size() > 1;
  }

  public void forward() {
    if (canForward()) {
      String top = backStack.pop();
      forwardStack.push(top);
      url = top;
    }
  }

  public void goBack() {
    if (canBack()) {
      String top = forwardStack.pop();
      backStack.push(top);
      url = forwardStack.top();
    }
  }

  public void go(int n) {
    for (int i = 0; i < Math.abs(n); i++) {
      if (n > 0) {
        forward();
      } else {
        goBack();
      }
    }
  }

  public void push(String url) {
    if (backStack.size() > 0) backStack.clear();
    forwardStack.push(url);
    this.url = url;
  }

  public void replace(String url) {
    forwardStack.pop();
    forwardStack.push(url);
    this.url = url;
  }

  public void pop() {
    forwardStack.pop();
    this.url = forwardStack.top();
  }
}
