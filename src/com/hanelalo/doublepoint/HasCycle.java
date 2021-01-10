package com.hanelalo.doublepoint;

/**
 * 判断链表中是否有环
 */
public class HasCycle {

  public static void main(String[] args) {
    Node head = prepareNode();

    boolean hasCycle = hasCycle(head);
    System.out.println(hasCycle);

    Node cycleStart = findCycleStart(head);
    System.out.println(cycleStart.value);
  }

  /**
   * 通过快慢指针查找环的起点。
   * 当快慢指针在环中第一次相遇时，将任意一个指针重置到链表表头，
   * 然后两个指针以同样的速度前进，两个指针再次相遇时，就是环的起始节点。
   * 假设第一次相遇时，快指针走了 2k，慢指针走了 k，相遇点到环起始点相距 m
   * 从表头到环起始点相距 k-m，从第一次相遇点前进 k-m 恰好是 k+k-m = 2k-m
   * 就相当于是快指针从第一次相遇的地方往后退 m，这个点恰好是环起始点。
   */
  private static Node findCycleStart(Node head) {
    Node fastPoint = head;
    Node slowPoint = head;

    while(fastPoint.next!=null && fastPoint.next.next != null){
      fastPoint = fastPoint.next.next;
      slowPoint = slowPoint.next;
      if(fastPoint == slowPoint){
        fastPoint = head;
        break;
      }
    }
    if(slowPoint == null){
      return null;
    }
    while(fastPoint.next!=null && slowPoint.next != null){
      fastPoint = fastPoint.next;
      slowPoint = slowPoint.next;
      if(fastPoint == slowPoint){
        return fastPoint;
      }
    }
    return null;
  }

  /**
   * 判断链表中是否有环。
   * 使用快慢指针，一个指针走的快，一个指针走得慢，
   * 当两个指针相遇时，就是快指针在环中超过慢指针一圈的时候，
   * 也就表明链表中存在环。
   */
  private static boolean hasCycle(Node head) {

    Node fastPoint = head;
    Node slowPoint = head;

    while(fastPoint.next!=null && fastPoint.next.next != null){
      fastPoint = fastPoint.next.next;
      slowPoint = slowPoint.next;
      if(fastPoint == slowPoint){
        return true;
      }
    }
    return false;
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
    five.next = three;
    return head;
  }

}
