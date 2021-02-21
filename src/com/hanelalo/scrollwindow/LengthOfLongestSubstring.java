package com.hanelalo.scrollwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长无重复子串
 */
public class LengthOfLongestSubstring {

  public static void main(String[] args) {
    String s = "aaabbbdddabdfcidghhhjjjkkdjdh";
    System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(s));
  }

  public int lengthOfLongestSubstring(String s){
    char[] sChars = s.toCharArray();
    Map<Character, Integer> window = new HashMap<>();
    int left = 0, right = 0;
    int result = Integer.MIN_VALUE;
    while (right < s.length()) {
      char c = sChars[right];
      right++;
      window.put(c, window.getOrDefault(c, 0) + 1);
      while (window.get(c) > 1) {
        char d = sChars[left];
        left++;
        window.put(d, window.get(d) - 1);
      }
      result = Math.max(result, right - left);
    }
    return result;
  }

}
