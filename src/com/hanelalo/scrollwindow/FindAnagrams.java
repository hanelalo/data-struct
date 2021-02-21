package com.hanelalo.scrollwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 滑动窗口变种
 * 有字符串 S T, 查找 S 中所有 T 的字母异位词
 * 比如 S = “cbafghdjkbac”  T= “abc”
 * 返回结果为 [0, 9]，因为 S 的子串 “cba” 和 “bac” 是 T 的字母异位词
 */
public class FindAnagrams {

  public static void main(String[] args) {
    String s = "cbafghdjkbacsdfsdfcabsadsa";
    String t = "abc";
    System.out.println(Arrays.toString(new FindAnagrams().checkInclusion(s, t)));
  }

  public Integer[] checkInclusion(String s, String t){
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();
    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    List<Integer> resultList = new ArrayList<>();
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
          resultList.add(left);
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
    return resultList.toArray(resultList.toArray(new Integer[0]));
  }

}
