package com.hanelalo.linked;

/**
 * 链表
 */
public class MyLinkedList<T> {

  private Node<T> head;

  public void add(T t) {
    if (head == null) {
      head = new Node<>(t);
      return;
    }
    Node<T> parent = head;
    while (parent.next != null) {
      parent = parent.next;
    }
    parent.next = new Node<>(t);
  }

  public T pop() {
    if (head == null) {
      return null;
    }
    Node<T> parent = head;
    Node<T> child = head;
    while (child.next != null) {
      parent = child;
      child = child.next;
    }
    parent.next = null;
    return child.value;
  }

  static class Node<N> {

    protected N value;
    protected Node<N> next;

    public Node(N value) {
      this.value = value;
    }
  }

}
