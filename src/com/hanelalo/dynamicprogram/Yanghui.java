package com.hanelalo.dynamicprogram;

import java.util.ArrayList;
import java.util.List;

public class Yanghui {

  public static void main(String[] args) {
    List<Integer> row = getRow(3);
    System.out.println(row.toString());
  }

  public static List<Integer> getRow(int rowIndex) {
    List<Integer> res = new ArrayList<>();
    if (rowIndex == 0) {
      res.add(1);
      return res;
    }
    if (rowIndex == 1) {
      res.add(1);
      res.add(1);
      return res;
    }
    List<Integer> pre = new ArrayList<>();
    pre.add(1);
    pre.add(1);
    for (int i = 2; i <= rowIndex; i++) {
      res = new ArrayList<>();
      res.add(1);
      for (int j = 1; j <= pre.size() - 1; j++) {
        res.add(pre.get(j) + pre.get(j - 1));
      }
      res.add(1);
      pre = res;
    }
    return res;
  }
}
