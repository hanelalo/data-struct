package com.hanelalo.binarysearch;

/**
 * 二分搜索左边界
 */
public class LeftLimitSearch {

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 3, 4, 4, 4, 4, 4, 5, 6, 7, 8, 9};
    System.out.println(new LeftLimitSearch().search(nums, 0));
  }

  public int search(int[] nums, int target){
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right-left)/2;
      if(nums[mid] == target){
        right = mid - 1;
      }else if(nums[mid] > target){
        right = mid - 1;
      }else if(nums[mid] < target){
        left = mid + 1;
      }
    }
    return left >= nums.length || nums[left] != target ? -1 : left;
  }

}
