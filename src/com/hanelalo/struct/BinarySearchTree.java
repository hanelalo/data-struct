package com.hanelalo.struct;

/**
 * 二叉查找树
 */
public class BinarySearchTree {

  private Node tree;

  public Node find(int value) {
    if (tree == null) {
      return null;
    }
    Node p = tree;
    /** 从根节点开始遍历 如果 value 比当前节点值大，向右继续查找 如果 value 比当前节点值小，向左继续查找 */
    while (p != null) {
      if (value < p.data) {
        p = p.left;
      } else if (value > p.data) {
        p = p.right;
      } else {
        return p;
      }
    }
    return null;
  }

  public void insert(int value) {
    if (tree == null) {
      tree = new Node(value);
      return;
    }
    Node p = tree;
    while (p != null) {
      if (p.data > value) {
        if (p.left == null) {
          p.left = new Node(value);
          return;
        }
        p = p.left;
      } else if (p.data < value) {
        if (p.right == null) {
          p.right = new Node(value);
          return;
        }
        p = p.right;
      }
    }
  }

  public void delete(int value) {
    Node p = tree;
    Node pp = null;
    while (p != null && p.data != value) {
      pp = p;
      if (p.data > value) {
        p = p.left;
      } else {
        p = p.right;
      }
    }
    if (p == null) {
      return;
    }

    // 要删除的节点有左右子节点
    if (p.left != null && p.right != null) {
      // 先找到 p 的右子节点中的最小值
      Node min = p.right;
      Node minPP = p;
      while (min.left != null) {
        minPP = min;
        min = min.left;
      }
      p.data = min.data;
      pp = minPP;
      p = min;
    }

    // pp 最终的子节点
    Node child;
    if (p.left != null) {
      child = p.left;
    } else if (p.right != null) {
      child = p.right;
    } else {
      child = null;
    }

    if (pp == null) {
      // 删除根节点
      tree = child;
    } else if (pp.left == p) {
      pp.left = child;
    } else {
      pp.right = child;
    }
  }

  public Node geHead() {
    return tree;
  }

  public static class Node {

    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
      this.data = data;
    }

    public Node getLeft() {
      return left;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public Node getRight() {
      return right;
    }

    public void setRight(Node right) {
      this.right = right;
    }
  }
}
