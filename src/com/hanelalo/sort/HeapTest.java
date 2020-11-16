package com.hanelalo.sort;

public class HeapTest {

  public static void main(String[] args) {
    MaxHeap maxHeap = new MaxHeap(10);
    for (int i = 0; i < 8; i++) {
      int r = (int) (Math.random() * 100000) % 100;
      System.out.println("insert " + r);
      maxHeap.insert(r);
    }
    maxHeap.out();
    for (int i = 0; i < 8; i++) {
      maxHeap.removeMax();
    }
    maxHeap.out();
  }
}
