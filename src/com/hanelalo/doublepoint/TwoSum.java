package com.hanelalo.doublepoint;

import java.util.Arrays;

/**
 * 左右指针计算两数之和
 * 给定以有序数组 nums，从中找到和为 target 的两个数字，返回这两个数字的下标
 */
public class TwoSum {

  public static void main(String[] args) {
    int[] nums = new int[] {2,3,4};
    int target = 6;
    int[] index = twoSum(nums, target);
    System.out.println(Arrays.toString(index));
  }

  private static int[] twoSum(int[] nums, int target) {

    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int sum = nums[left] + nums[right];
      if (sum == target) {
        return new int[] {left, right};
      }
      if(sum<target){
        left++;
      }
      if(sum>target){
        right--;
      }
    }
    return new int[] {-1, -1};
  }
}
