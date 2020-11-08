package com.hanelalo.linked;

import java.nio.ByteBuffer;

public class ByteBufferTest {

  public static void main(String[] args) {
    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    System.out.println(byteBuffer.limit());
    System.out.println(byteBuffer.position());
    System.out.println(byteBuffer.capacity());
    System.out.println(byteBuffer.mark());
    byteBuffer.put("Hanelalo".getBytes());
    System.out.println("--------------------------");
    System.out.println(byteBuffer.limit());
    System.out.println(byteBuffer.position());
    System.out.println(byteBuffer.capacity());
    System.out.println(byteBuffer.mark());
    byteBuffer.flip();
    System.out.println("------------------------------");
    System.out.println(byteBuffer.limit());
    System.out.println(byteBuffer.position());
    System.out.println(byteBuffer.capacity());
    System.out.println(byteBuffer.mark());
    System.out.println("------------------------------");
    ByteBuffer buffer = byteBuffer.get(new byte[4], 0, 4);
  }
}
