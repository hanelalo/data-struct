package com.hanelalo.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 通过堆排序求取中位数 维护一个大顶堆，一个小顶堆，小顶堆中的数比大顶堆中的数大 假设有 n 个数，n 是偶数时，两个堆都有 n/2 个元素，中位数是两个堆的堆顶元素， n 是奇数时，大顶堆有
 * (n/2)+1 个数，小顶堆有 n/2 个数，中位数位大顶堆的堆顶元素
 */
public class Median {

  public static void main(String[] args) {
    MaxHeap maxHeap = new MaxHeap(10);
    MinHeap minHeap = new MinHeap(10);
    Set<Integer> nums = new HashSet<>();
    for (int i = 0; i < 20; ) {
      int r = (int) (Math.random() * 100000) % 100;
      if (nums.contains(r)) {
        continue;
      }
      nums.add(r);
      i++;
    }
    Iterator<Integer> iterator = nums.stream().iterator();
    while (iterator.hasNext()) {
      int i = iterator.next();
      if (maxHeap.isEmpty()) {
        maxHeap.insert(i);
      } else if (maxHeap.getMax() < i) {
        minHeap.insert(i);
      } else {
        maxHeap.insert(i);
      }
      adjust(maxHeap, minHeap);
    }

    Integer[] array = nums.toArray(new Integer[]{});
    Arrays.sort(array);
    System.out.println(Arrays.toString(array));
    maxHeap.out();
    minHeap.out();
  }

  private static void adjust(MaxHeap maxHeap, MinHeap minHeap) {
    while (minHeap.getSize() > maxHeap.getSize()) {
      maxHeap.insert(minHeap.removeMin());
    }
    while (maxHeap.getSize() - minHeap.getSize() > 1) {
      minHeap.insert(maxHeap.removeMax());
    }
  }
}
