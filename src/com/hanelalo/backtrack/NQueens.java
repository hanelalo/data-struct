package com.hanelalo.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 8 皇后问题 */
public class NQueens {

  public static void main(String[] args) {
    int n = 8;
    String[] chessboard = new String[n];
    Arrays.fill(chessboard, "..........");
    List<String[]> backtrack = new ArrayList<>();
    solutionNQueens(chessboard, backtrack, 0);
    System.out.println(backtrack.size());
//    for (String[] backtrackItem : backtrack) {
//      Arrays.stream(backtrackItem).forEach(System.out::println);
//      System.out.println("--------------------------------");
//    }
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
    if (col - 1 >= 0 && row - 1 >= 0 && chessboard[row - 1].charAt(col - 1) == 'Q') {
      return true;
    }
    if (col + 1 < chessboard.length
        && row - 1 >= 0
        && chessboard[row - 1].charAt(col + 1) == 'Q') {
      return true;
    }
    if (col - 1 >= 0 && row + 1 < chessboard.length && chessboard[row + 1].charAt(col - 1) == 'Q') {
      return true;
    }
    return col + 1 < chessboard.length
        && row + 1 < chessboard.length
        && chessboard[row + 1].charAt(col + 1) == 'Q';
  }
}
