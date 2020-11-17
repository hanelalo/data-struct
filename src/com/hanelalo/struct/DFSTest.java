package com.hanelalo.struct;

/**
 * 广度优先搜索
 */
public class DFSTest {

  public static void main(String[] args) {
    Graph graph = new Graph(8);
    graph.addEdge(0, 1);
    graph.addEdge(1, 2);
    graph.addEdge(0, 3);
    graph.addEdge(1, 4);
    graph.addEdge(3, 4);
    graph.addEdge(4, 5);
    graph.addEdge(6, 4);
    graph.addEdge(6, 7);
    graph.addEdge(5, 7);
    graph.dfs(0, 6);
  }
}
