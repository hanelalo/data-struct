package com.hanelalo.linked;

import java.util.Random;

/**
 * 跳表。 是对链表数据结构的优化，增加了索引，虽然会增加空间复杂度，但是空间复杂度是 O(n) 级别，还是可以接受的 至于时间复杂度，查询是 O(logN), 插入和删除也是。
 * 明白了插入逻辑，基本上删除和查询也就能明白，主要是得理解 Node.forwards 是节点在跳表每一层得下一个节点。
 */
public class SkipList {

  private int MAX_LEVEL = 16;
  private Random r = new Random();
  private int levelCount = 1;
  /** 头节点直接初始化，有点像哨兵节点的样子 */
  private Node head = new Node();

  public SkipList(int maxLevel) {
    this.MAX_LEVEL = maxLevel;
  }

  public Node find(int value) {
    if (head == null) {
      return null;
    }
    Node p = head;
    for (int i = levelCount - 1; i >= 0; i--) {
      while (p.forwards[i] != null && p.forwards[i].data < value) {
        p = p.forwards[i];
      }
    }

    if (p.forwards[0] != null && p.forwards[0].data == value) {
      return p.forwards[0];
    }
    return null;
  }

  public void delete(int value) {
    Node[] preNodes = new Node[levelCount];
    Node p = head;
    for (int i = levelCount - 1; i >= 0; i--) {
      while (p.forwards[i] != null && p.forwards[i].data < value) {
        p = p.forwards[i];
      }
      preNodes[i] = p;
    }
    if (p.forwards[0] != null && p.forwards[0].data == value) {
      for (int i = levelCount - 1; i >= 0; i--) {
        if (preNodes[i] != null && preNodes[i].forwards[i].data == value) {
          preNodes[i].forwards[i] = preNodes[i].forwards[i].forwards[i];
        }
      }
    }
    // 重新计算跳表层数
    resetLevelCount();
  }

  private void resetLevelCount() {
    while (levelCount > 1 && head.forwards[levelCount] == null) {
      levelCount--;
    }
  }

  public void insert(int value) {
    // 获取当前要插入的节点所在的层数，随机生成，尽力保证跳表每层索引的均衡
    int level = randomLevel();
    // 如果计算出来的层数大于当前最大层数, 那就只增加一层
    if (level > levelCount) {
      level = ++levelCount;
    }
    Node newNode = new Node();
    newNode.data = value;
    // 数据插入后，新节点在在每一层的前驱节点
    Node[] preNodes = new Node[levelCount];
    Node p = head;
    for (int i = levelCount - 1; i >= 0; i--) {
      /**
       * 调表是有序的，所以插入的新节点在最后一个比 value 小的节点后面，
       * 只需要找到每一层里面最后一个比 value 小的节点，这个节点就是心节点在这一层的前驱节点
       */
      while (p.forwards[i] != null && p.forwards[i].data < value) {
        p = p.forwards[i];
      }
      // 如果当前遍历层级比节点所在层级小，那就记录前驱节点，比节点层级大的话，说明新节点不会在当前层级索引中出现
      if (level > i) {
        preNodes[i] = p;
      }
    }
    // 插入，调表是以链表的方式实现，所以这里真正插入的逻辑和链表查询新数据的逻辑相似
    for (int i = 0; i < level; i++) {
      newNode.forwards[i] = preNodes[i].forwards[i];
      preNodes[i].forwards[i] = newNode;
    }
  }

  public int randomLevel() {
    int level = 0;
    // 以最大层数为限制，避免出现跳表层数大于最大层数的情况
    for (int i = 0; i < MAX_LEVEL; i++) {
      if (r.nextInt() % 2 == 1) {
        level++;
      }
    }
    return level;
  }

  public void printAll() {
    for (int i = levelCount - 1; i >= 0; i--) {
      Node p = head;
      while (p.forwards[i] != null) {
        print(p.forwards[i]);
        p = p.forwards[i];
      }
      System.out.println();
    }
  }

  private void print(Node head) {
    if (head.data < 10) {
      System.out.print("0" + head.data + "\t");
    } else {
      System.out.print(head.data + "\t");
    }
  }

  class Node {

    private int data = -1;
    /**
     * 当前节点在跳表中每一层对应的后继节点 比如 forwards[3] 就表示在第三层的后继节点
     */
    private Node[] forwards;
    private int level;

    public Node() {
      /**
       * 在每一层的后继节点时，直接将 forwards 数组初始化成最大层数，避免调用 node.forwards[i] 时数组越界
       * 尽管这会使得level比较高的节点的 forwards 中大面积都是 null
       */
      forwards = new Node[MAX_LEVEL];
    }
  }

}
