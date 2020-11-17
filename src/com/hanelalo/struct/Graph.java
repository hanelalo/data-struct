package com.hanelalo.struct;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图（邻接表实现）
 */
public class Graph {

  private boolean dfsFound = false;
  /** 图的顶点个数 */
  private int n;
  /** 邻接表 */
  private LinkedList<Integer>[] adj;

  public Graph(int n) {
    this.n = n;
    adj = new LinkedList[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new LinkedList<>();
    }
  }

  public void addEdge(int s, int t) {
    adj[s].add(t);
    adj[t].add(s);
  }

  /** 广度优先搜索 */
  public void bfs(int s, int t) {
    if (s == t) {
      return;
    }
    // 已经被访问的顶点， true表示该位置的顶点已经被访问
    boolean[] visited = new boolean[n];
    visited[s] = true;
    // 用来存储已经被访问但是相连的顶点未被访问的顶点
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);
    // 最终记录的是从 s 到 t 的路径
    int[] prev = new int[n];
    initPrev(prev);
    while (queue.size() != 0) {
      int w = queue.poll();
      for (int i = 0; i < adj[w].size(); i++) {
        int q = adj[w].get(i);
        if (!visited[q]) {
          prev[q] = w;
          if (q == t) {
            print(prev, s, t);
            return;
          }
          visited[q] = true;
          queue.add(q);
        }
      }
    }
  }

  /**
   * 深度优先搜索
   */
  public void dfs(int s, int t) {
    if (s == t) {
      return;
    }
    // 已经被访问的顶点， true表示该位置的顶点已经被访问
    boolean[] visited = new boolean[n];
    visited[s] = true;
    // 用来存储已经被访问但是相连的顶点未被访问的顶点
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);
    // 最终记录的是从 s 到 t 的路径
    int[] prev = new int[n];
    initPrev(prev);
    doDfs(s, t, prev, visited);
    print(prev, s, t);
  }

  private void doDfs(int s, int t, int[] prev, boolean[] visited) {
    if (dfsFound) {
      return;
    }
    visited[s] = true;
    if (s == t) {
      dfsFound = true;
      return;
    }
    for (int i = 0; i < adj[s].size(); i++) {
      if (!visited[adj[s].get(i)]) {
        prev[adj[s].get(i)] = s;
        doDfs(adj[s].get(i), t, prev, visited);
      }
    }
  }

  private void print(int[] prev, int s, int t) {
    if (prev[t] != -1 && prev[t] != s) {
      print(prev, s, prev[t]);
    }
    System.out.println(t + " ");
  }

  private void initPrev(int[] prev) {
    for (int i = 0; i < n; i++) {
      prev[i] = -1;
    }
  }
}
