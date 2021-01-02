package com.hanelalo.dynamicprogram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 凑零钱问题
 * 给定n种面额人民币，每种面额不限制数量，给定一个金额amount，使用最少的人民币数量凑出amount
 * BaseCase: amount=0,result=0
 * Status: amount-->0，每选择一张人民币，金额便会减少，最终变为0，整个过程中变化的只有amount，它就是状态
 * Change: 每选择一张人民币，就会引起状态amount的变化
 * DP Function/Table:
 *  DP Function:
 *    dp(amount) = 凑出目标金额amount所需的最少人民币数量
 *  DP Table:
 *
 */
public class CoinAmount {

  /**
   * base case: f(0)=0
   */
  public static void main(String[] args) {
    int amount = 13;
    int[] coins = new int[] {1, 3, 5};
    //暴力枚举解法
    int normal = dpNormal(coins, amount);
    System.out.println(normal);
    //带备忘录解法，解决重叠子问题
    int dpHelper = dpHelper(coins, amount);
    System.out.println(dpHelper);
    // 状态压缩
    int dpStatusCompact = dpStatusCompact(coins, amount);
    System.out.println(dpStatusCompact);
  }

  private static int dpStatusCompact(int[] coins, int amount) {
    // 定义dp table，要凑出金额i，需要dp[i]张纸币
    // dp表其实是每个状态的值的映射？？？
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount+1);
    dp[0] = 0;
    return doStatusCompact(coins,amount,dp);
  }

  private static int doStatusCompact(int[] coins, int amount, int[] dp) {
    if(amount<0){
      return -1;
    }
    if(amount == 0){
      return 0;
    }
    for (int i = 0; i < dp.length; i++) {
      for (int coin : coins) {
        if (i - coin < 0) {
          continue;
        }
        dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
      }
    }
    return dp[amount];
  }

  private static int dpHelper(int[] coins, int amount) {
    Map<Integer, Integer> dp = new HashMap<>();
    return doHelper(coins, amount, dp);
  }

  private static int doHelper(int[] coins, int amount, Map<Integer, Integer> dp) {
    if(dp.containsKey(amount)){
      return dp.get(amount);
    }
    if(amount ==0){
      return 0;
    }
    if (amount < 0) {
      return -1;
    }
    int result = Integer.MAX_VALUE;
    for (int coin : coins) {
      int subResult;
      if(dp.containsKey(amount -coin)){
        subResult = dp.get(amount - coin);
      } else {
        subResult = doHelper(coins, amount - coin, dp);
        dp.put(amount - coin, subResult);
      }
      if(subResult==-1){
        continue;
      }
      result = Math.min(result, subResult + 1);
    }
    return result;
  }

  private static int dpNormal(int[] coins, int amount) {
    if(amount==0){
      return 0;
    }
    if (amount < 0) {
      return -1;
    }
    int result = Integer.MAX_VALUE;
    for (int coin : coins) {
      int subResult = dpNormal(coins, amount - coin);
      if(subResult==-1){
        continue;
      }
      result = Math.min(result, subResult + 1);
    }
    return result;
  }

}
