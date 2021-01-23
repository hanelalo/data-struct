package com.hanelalo.dynamicprogram;

import java.util.HashMap;
import java.util.Map;

/** 编辑距离 字符串 A 和字符串 B, 在只能做插入一个字符、删除一个字符、替换一个字符三种操作的情况下， 将 A 编辑为 B 需要多少次操作 */
public class MinEditInstance {

  private static Map<String, Integer> map = new HashMap<>();

  public static void main(String[] args) {
    String str1 = "radsadasdfsdfsdfsddafjhvj";
    String str2 = "applesaddadfssdfdfadkj";

    int minInstance = calculateMinEditInstance(str1.split(""), str2.split(""));
    System.out.println(minInstance);
  }

  private static int calculateMinEditInstance(String[] str1, String[] str2) {
    //    return dp(str1, str2, str1.length - 1, str2.length - 1);
    // 到这里终于体会到了 dpTable 到底有多强， 用递归要跑接近一分钟，而使用 dpTable 基本是一秒不到
    return dpTable(str1, str2);
  }

  private static int dpTable(String[] str1, String[] str2) {
    int[][] dp = new int[str1.length + 1][str2.length + 1];
    for(int i = 0;i<= str2.length;i++){
      dp[0][i] = i;
    }
    for (int i = 0; i <= str1.length; i++) {
      dp[i][0] = i;
    }
    for (int i = 1; i <= str1.length; i++) {
      for (int j = 1; j <= str2.length; j++) {
        if (str1[i - 1].equals(str2[j - 1])) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
        }
      }
    }
    return dp[str1.length][str2.length];
  }

  private static int dp(String[] str1, String[] str2, int i, int j) {
    if(map.containsKey(i+"-"+"j")){
      return map.get(i + "-" + j);
    }
    if (i == -1) {
      return j + 1;
    }
    if (j == -1) {
      return i + 1;
    }
    int result = 0;
    if(str1[i].equals(str2[j])){
      result = dp(str1, str2, i - 1, j - 1);
    } else {
      result =
          Math.min(
              Math.min(dp(str1, str2, i - 1, j) + 1, dp(str1, str2, i, j - 1) + 1),
              dp(str1, str2, i - 1, j - 1) + 1);
    }
    map.put(i + "-" + j, result);
    return result;
  }
}
