package com.hanelalo.dynamicprogram;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态规划问题
 * 核心问题：穷举
 * 解题思路：
 *  暴力穷举会有重叠子问题
 *    比如下面求解非波那契函数，normal函数的解法，会做很多重复计算
 *  最优子结构
 *  状态转移方程
 *    1. base case 是什么
 *    2.都有什么状态
 *    3.什么”选择“会让”状态“怎样改变
 *    4.如何定义dp数组/函数来表示选择和状态转移
 */
public class Fibonacci {

  public static void main(String[] args) {
    int n = 10;
    // 日常解法
    int normal = normal(n);
    System.out.println(normal);
    // 备忘录解法
    int helper = helper(n);
    System.out.println(helper);
    // dp表解法
    int dpFunc = dpFunc(n);
    System.out.println(dpFunc);
    int statusCompact = doStatusCompact(n);
    System.out.println(statusCompact);
  }

  /**
   * 状态压缩其实是基于dp表的升级版
   */
  private static int doStatusCompact(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    }
    int pre = 1;
    int result = 1;
    for (int i = 3; i <= n; i++) {
      int tmp = result;
      result += pre;
      pre = tmp;
    }
    return result;
  }

  private static int dpFunc(int n) {
    int[] dp = new int[n + 1];
    dp[1] = dp[2] = 1;
    for (int i=3;i<=n;i++){
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  private static int helper(int n) {
    Map<Integer, Integer> helper = new HashMap<>();
    return doHelper(helper, n);
  }

  private static int doHelper(Map<Integer, Integer> helper, int n) {
    if(n==0){
      return 0;
    }
    if(n==1 || n==2){
      return 1;
    }
    int result = helper.getOrDefault(n, 0);
    if(result != 0){
      return result;
    }
    result = doHelper(helper, n - 1) + doHelper(helper, n - 2);
    helper.put(n, result);
    return result;
  }

  private static int normal(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    }
    return normal(n - 1) + normal(n - 2);
  }
}