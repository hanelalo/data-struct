package com.hanelalo.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

  public static void main(String[] args) {
    int[] arr = {3, 5, 2, 6, 8, 1, 4, 9, 7};
    quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  private static void quickSort(int[] arr, int p, int r) {
    if (p >= r) {
      return;
    }
    int q = partition(arr, p, r);
    quickSort(arr, 0, q - 1);
    quickSort(arr, q + 1, r);
  }

  private static int partition(int[] arr, int p, int r) {
    int middle = arr[r];
    int i = p;
    for (int j = p; j < r; j++) {
      if (arr[j] < middle) {
        if (i == j) {
          ++i;
        } else {
          int tmp = arr[i];
          arr[i++] = arr[j];
          arr[j] = tmp;
        }
      }
    }
    arr[r] = arr[i];
    arr[i] = middle;
    return i;
  }
}
