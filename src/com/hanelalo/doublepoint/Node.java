package com.hanelalo.doublepoint;

class Node {
  final int value;

  Node next;

  Node(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "Node{" +
        "value=" + value +
        '}';
  }
}
