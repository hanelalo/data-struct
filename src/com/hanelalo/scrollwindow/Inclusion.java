package com.hanelalo.scrollwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口变种
 * 有字符串 S T, 判断 S 中是否包含 T 的所有字母的排列的字串
 * 比如 S = “Helloworld”  T= “oow”
 * 返回结果为 true，因为 S 的子串 “owo” 是 T 的排列
 */
public class Inclusion {

  public static void main(String[] args) {
    String s = "Helloworld";
    String t = "oow";
    System.out.println(new Inclusion().checkInclusion(s, t));
  }

  public boolean checkInclusion(String s, String t){
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();
    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    for (char tChar : tChars) {
      need.put(tChar, need.getOrDefault(tChar, 0) + 1);
    }
    int left = 0, right = 0, valid = 0;
    while (right < s.length()){
      char c = sChars[right];
      right++;
      if(need.containsKey(c)){
        window.put(c, window.getOrDefault(c, 0) + 1);
        if(window.get(c).equals(need.get(c))){
          valid++;
        }
      }
      // 收缩窗口
      while (right - left >= t.length()) {
        if(valid == need.size()){
          return true;
        }
        char d = sChars[left];
        left++;
        if(need.containsKey(d)){
          if(need.get(d).equals(window.get(d))){
            valid--;
          }
          window.put(d, window.get(d) - 1);
        }
      }
    }
    return false;
  }

}
