package com.hanelalo.dynamicprogram;

/**
 * 子数组最大和问题
 * 给定数组[-3,1,3,-1,2,-4,2], 求和最大的子数组
 * 比如前面这个数组的输出为 5, 最大和子数组为 [1,3,-1,-2]
 */
public class MaxSum {

  public static void main(String[] args) {
    int[] nums = new int[] {-3, 1, 3, -1, 2, -4, 2};
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    for(int i=1;i<nums.length;i++){
      dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
    }
    int res = 0;
    for(int i : dp){
      res = Math.max(i, res);
    }
    System.out.println(res);
  }
}
