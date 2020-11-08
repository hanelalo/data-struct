package com.hanelalo.sort;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountingSort {

  public static void main(String[] args) {
    int[] arr = {2, 5, 3, 0, 2, 3, 0, 3};
    countingSort(arr);
  }

  private static void countingSort(int[] arr) {
    if (arr.length <= 1) {
      return;
    }
    // 获取最大值
    int max = getMax(arr);
    // 初始化计数器数组
    int[] counter = initCounter(max);
    count(arr, counter);
    System.out.println(Arrays.toString(sort(arr, counter)));
  }

  private static int[] sort(int[] arr, int[] counter) {
    int[] result = new int[arr.length];
    /**
     * 这里如果从索引为 0 的元素开始遍历，会导致该排序算法变成不稳定的算法。
     */
    for (int i = arr.length - 1; i >= 0; i--) {
      int j = arr[i];
      result[counter[j] - 1] = j;
      counter[j]--;
    }
    return result;
  }

  private static void count(int[] arr, int[] counter) {
    for (int i : arr) {
      counter[i]++;
    }
    for (int i = 1; i < counter.length; i++) {
      counter[i] += counter[i - 1];
    }
  }

  private static int[] initCounter(int max) {
    int[] result = new int[max + 1];
    for (int i = 0; i < max; i++) {
      result[i] = 0;
    }
    return result;
  }

  private static int getMax(int[] arr) {
    int max = arr[0];
    for (int j : arr) {
      if (j > max) {
        max = j;
      }
    }
    return max;
  }
}
