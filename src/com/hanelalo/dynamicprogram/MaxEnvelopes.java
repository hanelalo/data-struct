package com.hanelalo.dynamicprogram;

import java.util.Arrays;

/**
 * 信封嵌套问题
 * 有长宽分别为[w,h]信封: [[5,4],[6,4],[6,7],[2,3]]
 * 问这几个信封嵌套最多能嵌套几层？
 *
 * 先对 w 进行升序， w想同的对 h 做降序排序， 然后去排序后的 h 的最大递增子序列
 */
public class MaxEnvelopes {

  public static void main(String[] args) {
    int[][] envelopes =
        new int[][] {new int[] {5, 4}, new int[] {6, 4}, new int[] {6, 7}, new int[] {2, 3}};
    int max = findMaxEnvelopes(envelopes);
    System.out.println(max);
  }

  private static int findMaxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
    int[] height = new int[envelopes.length];
    for (int i = 0;i<envelopes.length;i++){
      height[i] = envelopes[i][1];
    }
    // 寻找最大递增序列长度
    return findMaxSub(height);
  }

  private static int findMaxSub(int[] height) {
    int[] dp = new int[height.length];
    Arrays.fill(dp, 1);
    for(int i = 0;i<height.length;i++){
      for(int j = 0;j<i;j++){
        if(height[j]<height[i]){
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    int res = 0;
    for(int i : dp){
      res = Math.max(i, res);
    }
    return res;
  }
}
