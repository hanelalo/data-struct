package com.hanelalo.linked;

public class SkipListTest {

  public static void main(String[] args) {
    SkipList skipList = new SkipList(16);
    int delete = 0;
    for (int i = 0; i < 30; ) {
      int r = (int) (Math.random() * 100000) % 100;
      if (skipList.find(r) == null) {
        skipList.insert(r);
        delete = r;
        i++;
      }
    }
    skipList.printAll();
    skipList.delete(delete);
    System.out.println("---------delete " + delete + "-----------------");
    skipList.printAll();
  }
}
