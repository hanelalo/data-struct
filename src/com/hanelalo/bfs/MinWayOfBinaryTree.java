package com.hanelalo.bfs;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 * 广度优先搜索（BFS）
 * 查找二叉树的小高度
 * Node[] tree = new Node[]{1,2,3,4,5,6,7,null,null,10,11,12,13,14,15};
 */
public class MinWayOfBinaryTree {

  public static void main(String[] args) {
    Node tree = init();
    int deepin = doBfs(tree);
    System.out.println(deepin);
  }

  private static int doBfs(Node head) {
    Queue<Node> queue = new ArrayDeque<>();
    // 二叉树没有字节点到父节点的指针，不需要考虑重复路径
//    Set<Node> visited = new HashSet<>();
    queue.offer(head);
//    visited.add(head);
    int result = 1;
    while (!queue.isEmpty()){
      int size = queue.size();
      for(int i = 0;i<size;i++){
        Node node = queue.poll();
        if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
          return result;
        }
        if (Objects.nonNull(node.left)) {
          queue.offer(node.left);
//          visited.add(node.left);
        }
        if(Objects.nonNull(node.right)){
          queue.offer(node.right);
//          visited.add(node.right);
        }
      }
      result++;
    }
    return result;
  }

  static class Node {
    private final int value;
    Node left;
    Node right;
    public Node(int value) {
      this.value = value;
    }
  }

  private static Node init() {
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);
    Node six = new Node(6);
    Node seven = new Node(7);
    Node eight = new Node(8);
    Node nine = new Node(9);
    one.left = two;
    one.right = three;
    two.left = four;
    two.right = five;
    three.left = six;
    three.right = seven;
    four.left = eight;
    four.right = nine;
    return one;
  }

}
