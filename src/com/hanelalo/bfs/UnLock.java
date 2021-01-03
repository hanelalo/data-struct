package com.hanelalo.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * from @labuladong
 *
 * <p>about LeetCode752
 */
public class UnLock {

  public static void main(String[] args) {
    String[] deadends = new String[] {"0201", "0101", "0102", "1212", "2002"};
    String unLockTarget = "0202";
    int steps = doUnLock(deadends, unLockTarget);
    System.out.println(steps);
    steps = doUnLockByBfsTwice(deadends, unLockTarget);
    System.out.println(steps);
  }

  private static int doUnLockByBfsTwice(String[] deadends, String target) {
    Set<String> q1 = new HashSet<>();
    Set<String> q2 = new HashSet<>();
    Set<String> v1 = new HashSet<>();
    q1.add("0000");
    q2.add(target);
    v1.addAll(Arrays.asList(deadends));
    int result = 0;
    while (!q1.isEmpty() && !q2.isEmpty()) {
      Set<String> temp = new HashSet<>();
      for (String cur : q1) {
        if (Arrays.asList(deadends).contains(cur)) {
          continue;
        }
        if (q2.contains(cur)) {
          return result;
        }
        v1.add(cur);
        for (int j = 0; j < 4; j++) {
          String minOne = minOne(cur, j);
          if (!v1.contains(minOne)) {
            temp.add(minOne);
          }
          String plusOne = plusOne(cur, j);
          if (!v1.contains(plusOne)) {
            temp.add(plusOne);
          }
        }
      }
      result++;
      q1 = q2;
      q2 = temp;
    }
    return -1;
  }

  private static int doUnLock(String[] deadends, String target) {
    Queue<String> queue = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();
    queue.offer("0000");
    visited.add("0000");
    visited.addAll(Arrays.asList(deadends));
    int result = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String cur = queue.poll();
        if (Arrays.asList(deadends).contains(cur)) {
          continue;
        }
        if (target.equals(cur)) {
          return result;
        }
        for (int j = 0; j < 4; j++) {
          String minOne = minOne(cur, j);
          String plusOne = plusOne(cur, j);
          if (!visited.contains(minOne)) {
            queue.offer(minOne);
            visited.add(minOne);
          }
          if (!visited.contains(plusOne)) {
            queue.offer(plusOne);
            visited.add(plusOne);
          }
        }
      }
      result++;
    }
    return -1;
  }

  private static String minOne(String str, int index) {
    char[] chars = str.toCharArray();
    int i = chars[index] - 48;
    if (i == 9) {
      chars[index] = '0';
    } else {
      chars[index] += 1;
    }
    return new String(chars);
  }

  private static String plusOne(String str, int index) {
    char[] chars = str.toCharArray();
    int i = chars[index] - 48;
    if (i == 0) {
      chars[index] = '9';
    } else {
      chars[index] -= 1;
    }
    return new String(chars);
  }
}
