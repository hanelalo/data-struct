package com.hanelalo.binarysearch;

public class BinarySearch {

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(new BinarySearch().search(nums, 5));
  }

  public int search(int[] nums, int target){
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if(nums[mid] == target){
        return mid;
      }else if(nums[mid] > target){
        right = mid - 1;
      }else if(nums[mid] < target){
        left = mid + 1;
      }
    }
    return -1;
  }

}
