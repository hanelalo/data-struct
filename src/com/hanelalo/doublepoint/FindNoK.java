package com.hanelalo.doublepoint;

/**
 * 使用快慢指针寻找链表倒数第 k 个节点
 */
public class FindNoK {

  public static void main(String[] args) {
    int k = 3;
    Node head = prepareNode();
    Node node = findNoK(head, 3);
    System.out.println(node);
  }

  /**
   * 使用一对快慢指针，快指针先走 k 步，然后快慢指针同样的速度前进
   * 当快指针到达终点时，慢指针所在就是倒数第 K 个元素
   */
  private static Node findNoK(Node head, int k) {
    Node fast = head;
    for (int i = 0; i < k-1; i++) {
      if(fast.next != null){
        fast = fast.next;
      }else{
        throw new IllegalArgumentException(String.valueOf(k));
      }
    }
    Node slow = head;
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }

  private static Node prepareNode(){
    Node head = new Node(0);
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);
    head.next = one;
    one.next = two;
    two.next = three;
    three.next = four;
    four.next = five;
    return head;
  }

}
