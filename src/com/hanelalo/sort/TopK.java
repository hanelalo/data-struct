package com.hanelalo.sort;

/**
 * Top 20 of 1000 TopK 问题 维护一个小顶堆，比堆顶大，删除堆顶元素，加入新元素，比堆顶小，不做处理
 */
public class TopK {

  public static void main(String[] args) {
    MinHeap minHeap = new MinHeap(20);
    for (int i = 0; i < 1000; i++) {
      int r = (int) (Math.random() * 1000000) % 1000;
      if (minHeap.isFull() && minHeap.getMin() < r) {
        minHeap.removeMin();
      }
      minHeap.insert(r);
    }
    minHeap.out();
  }
}
