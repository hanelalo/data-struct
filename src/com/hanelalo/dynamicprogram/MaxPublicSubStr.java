package com.hanelalo.dynamicprogram;

/** 最长公共子串问题 给定两个字符串，求这两个字符串最长的公共字串 eg: abcde aceb --> ace */
public class MaxPublicSubStr {

  public static void main(String[] args) {
    String str1 = "abcdfdfde";
    String str2 = "acdsfdse";

    int maxPublic = maxPublicSubString(str1.split(""), str2.split(""));
    System.out.println(maxPublic);
  }

  private static int maxPublicSubString(String[] str1, String[] str2) {
    int[][] dp = new int[str1.length + 1][str2.length + 1];
    for (int i = 1; i <= str1.length; i++) {
      for (int j = 1; j <= str2.length; j++) {
        if (str1[i - 1].equals(str2[j - 1])) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[str1.length][str2.length];
  }
}
