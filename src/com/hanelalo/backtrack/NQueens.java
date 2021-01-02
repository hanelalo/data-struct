package com.hanelalo.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 8 皇后问题 给定一个 N×N 的棋盘和 N 个皇后，每个棋子可以攻击其所在列、所在行、左上、左下、右上、右下的棋子，
 * 问怎么排列这 N 个皇后，才不会让他们相互攻击？ */
public class NQueens {

  public static void main(String[] args) {
    int n = 8;
    String[] chessboard = new String[n];
    Arrays.fill(chessboard, "..........");
    List<String[]> backtrack = new ArrayList<>();
    solutionNQueens(chessboard, backtrack, 0);
    System.out.println(backtrack.size());
        for (String[] backtrackItem : backtrack) {
          Arrays.stream(backtrackItem).forEach(System.out::println);
          System.out.println("--------------------------------");
        }
  }

  private static void solutionNQueens(String[] chessboard, List<String[]> backtrack, int row) {
    if (row == chessboard.length) {
      backtrack.add(chessboard.clone());
      return;
    }
    for (int col = 0; col < chessboard.length; col++) {
      if (isInValid(chessboard, row, col)) {
        continue;
      }
      mark(chessboard, row, col);
      solutionNQueens(chessboard, backtrack, row + 1);
      unMark(chessboard, row);
    }
  }

  private static void unMark(String[] chessboard, int row) {
    chessboard[row] = chessboard[row].replace("Q", ".");
  }

  private static void mark(String[] chessboard, int row, int col) {
    char[] chessboardItem = chessboard[row].toCharArray();
    chessboardItem[col] = 'Q';
    chessboard[row] = new String(chessboardItem);
  }

  private static boolean isInValid(String[] chessboard, int row, int col) {
    if (chessboard[row].contains("Q")) {
      return true;
    }
    if (Arrays.stream(chessboard).anyMatch(chessboardItem -> chessboardItem.charAt(col) == 'Q')) {
      return true;
    }
    // 左上
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (chessboard[i].charAt(j) == 'Q') {
        return true;
      }
    }
    // 右上
    for (int i = row - 1, j = col + 1; i >= 0 && j < chessboard.length; i--, j++) {
      if (chessboard[i].charAt(j) == 'Q') {
        return true;
      }
    }
    // 左下
    for (int i = row + 1, j = col - 1; i < chessboard.length && j >= 0; i++, j--) {
      if (chessboard[i].charAt(j) == 'Q') {
        return true;
      }
    }

    // 右下
    for (int i = row + 1, j = col + 1; i < chessboard.length && j < chessboard.length; i++, j++) {
      if (chessboard[i].charAt(j) == 'Q') {
        return true;
      }
    }
    return false;
  }
}
