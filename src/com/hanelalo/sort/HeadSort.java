package com.hanelalo.sort;

/** 堆排序 大顶堆 堆是一个完全二叉树，每个节点的的值比其左右子节点都大 */
public class HeadSort {

  // 从来存储堆中的数据，从下标 1 开始存储数据
  private final int[] a;
  // 堆可以存储的最大数据个数
  private final int n;
  // 已经存储数据个数
  private int count;

  public HeadSort(int capacity) {
    a = new int[capacity + 1];
    n = capacity;
    count = 0;
  }

  public void insert(int value) {
    if (count >= n) {
      return;
    }
    a[++count] = value;
    int i = count;
    while (a[i / 2] < value) {
      a[i] = a[i / 2];
      a[i / 2] = value;
      i /= 2;
    }
  }

  public void removeMax() {
    a[1] = a[count--];
    int i = 1;
    while (true) {
      if (i * 2 <= count && a[i * 2] > a[i]) {
        swap(i, i * 2);
        i = i * 2;
      } else if ((i * 2 + 1) <= count && a[i * 2 + 1] > a[i]) {
        swap(i, i * 2 + 1);
        i = i * 2 + 1;
      } else {
        break;
      }
    }
  }

  private void swap(int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
