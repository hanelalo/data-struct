package com.hanelalo.dynamicprogram;

public class MaxTurbulenceSize {

  public static void main(String[] args) {
    int[] arr = new int[]{9,4,2,10,7,8,8,1,9};
    System.out.println(maxTurbulenceSize(arr));
  }

  private static int maxTurbulenceSize(int[] arr) {
    // int[] dp = new int[arr.length];
    int res = 1;
    // Arrays.fill(dp,1);
    int cur = 1;
    for(int i=0;i < arr.length;i++){
      if(i == 0){
        continue;
      }
      if(i == 1 && arr[i] != arr[i-1]){
        // dp[i]=2;
        cur = 2;
        res = Math.max(res, cur);
        continue;
      }
      if(arr[i]>arr[i-1] && arr[i-1]<arr[i-2]){
        cur = cur+1;
        res = Math.max(res, cur);
        // dp[i] = Math.max(dp[i],dp[i-1]+1);
        continue;
      }
      if(arr[i]<arr[i-1] && arr[i-1] > arr[i-2]){
        cur = cur+1;
        res = Math.max(res, cur);
        // dp[i] = Math.max(dp[i],dp[i-1]+1);
        continue;
      }
      if(arr[i]!=arr[i-1]){
        cur = 2;
        res = Math.max(res, cur);
        continue;
        // dp[i] = 2;
      }
      cur= 1;
    }
    // for(int i : dp){
    // res = Math.max(i,res);
    // }
    return res;
  }


}
