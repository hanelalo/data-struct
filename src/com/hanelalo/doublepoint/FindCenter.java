package com.hanelalo.doublepoint;

/**
 * 使用快慢指针寻找链表中点
 * 快指针一次前进 2 步，慢指针一次前进 1 步
 * 快指针到达终点时，如果节点数为奇数，慢指针所在节点就是中点
 * 如果节点数为偶数，慢指针所在节点就是中点偏左
 */
public class FindCenter {

  public static void main(String[] args) {
    Node head = prepareNode();
    Node center = findCenter(head);
    System.out.println(center);
  }

  private static Node findCenter(Node head) {
    Node fast = head;
    Node slow = head;

    while(fast.next != null && fast.next.next != null){
      fast = fast.next.next;
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
