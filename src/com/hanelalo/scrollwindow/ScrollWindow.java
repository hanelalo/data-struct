package com.hanelalo.scrollwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口算法
 * 有字符串 S 和 T, 找出 S 中包含 T 中所有字母的最小子串
 */
public class ScrollWindow {

  public static void main(String[] args) {
    String s = "ADBECFEBANC";
    String t = "ABC";
    String minWindow = new ScrollWindow().minWindow(s, t);
    System.out.println(minWindow);
  }

  public String minWindow(String s, String t) {
    char[] srcChars = s.toCharArray();
    char[] targetChars = t.toCharArray();
    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    int left = 0, right = 0, valid = 0, len = Integer.MAX_VALUE, start = 0;
    for (char targetChar : targetChars) {
      need.put(targetChar, need.getOrDefault(targetChar, 0) + 1);
    }
    while (right < srcChars.length) {
      char c = srcChars[right];
      right++;
      if (need.containsKey(c)) {
        window.put(c, window.getOrDefault(c, 0) + 1);
        if (window.get(c).equals(need.get(c))) {
          valid++;
        }
      }
      while (valid == need.size()) {
        if (right - left < len) {
          len = right - left;
          start = left;
        }
        char d = srcChars[left];
        left++;
        if (need.containsKey(d)) {
          if (window.get(d).equals(need.get(d))) {
            valid--;
          }
          window.put(d, window.get(d) - 1);
        }
      }
    }
    return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
  }
}
