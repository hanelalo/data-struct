package com.hanelalo.dynamicprogram;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class NoReplicateStr {

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
  }

  public static int lengthOfLongestSubstring(String s) {
    int[] dp = new int[s.length() + 1];
    dp[1] = 1;
    List<String> strings = Arrays.asList(s.split(""));
    return getMaxLength(strings, s, dp, 2);
  }

  private static int getMaxLength(List<String> strings, String s, int[] dp, int index) {
    if (s.substring(0, index).contains(strings.get(index - 1))) {
      return dp[index - 1];
    }
    return 0;
  }
}
