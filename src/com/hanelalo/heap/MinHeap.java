package com.hanelalo.heap;

import java.util.Arrays;

/**
 * 小顶堆
 */
public class MinHeap {

  // 从来存储堆中的数据，从下标 1 开始存储数据
  private final int[] a;
  // 堆可以存储的最大数据个数
  private final int n;
  // 已经存储数据个数
  private int count;

  public MinHeap(int capacity) {
    a = new int[capacity + 1];
    n = capacity;
    count = 0;
  }

  public int getMin() {
    if (count == 0) {
      return 0;
    }
    return a[1];
  }

  public void insert(int value) {
    if (count >= n) {
      return;
    }
    count++;
    a[count] = value;
    int i = count;
    while (a[i / 2] > a[i] && i / 2 > 0) {
      swap(i, i / 2);
      i = i / 2;
    }
  }

  public int removeMin() {
    int result = a[1];
    swap(1, count);
    count--;
    int i = 1;
    while (true) {
      int minPos = i;
      if (i * 2 <= count && a[i * 2] < a[i]) {
        minPos = i * 2;
      }
      if ((i * 2 + 1) <= count && a[minPos] > a[i * 2 + 1]) {
        minPos = i * 2 + 1;
      }
      if (minPos == i) {
        break;
      }
      swap(i, minPos);
      i = minPos;
    }
    return result;
  }

  public int getSize() {
    return count;
  }

  private void swap(int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }


  public void out() {
    System.out.println(Arrays.toString(a));
  }

  public boolean isFull() {
    return count == n;
  }
}
