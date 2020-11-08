package com.hanelalo.linked;

/**
 * 双向链表
 *
 * @param <T>
 */
public class MyDoubleLinkedList<T> {

  private Node<T> head;
  private Node<T> tail;

  public void add(T value) {
    if (head == null) {
      head = new Node<>(value);
      tail = head;
      return;
    }
    Node<T> newNode = new Node<>(value);
    tail.next = newNode;
    newNode.prev = tail;
    tail = newNode;
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
    child.prev = null;
    return child.value;
  }

  static class Node<N> {

    protected N value;
    protected Node<N> next;
    protected Node<N> prev;

    public Node(N value) {
      this.value = value;
    }
  }

}
