package com.al.linkedlist;

public class ListNode {
  public int val;
  public ListNode next;
  public ListNode(int x) { val = x; }
  public static ListNode generate(String input){
      ListNode cur = null;
      ListNode header = null;
      String[] val = input.split("->");
      for (int i = 0; i < val.length-1; i++) {
          if (cur == null) {
              cur = new ListNode(Integer.valueOf(val[i]));
              header = cur;
          } else {
              cur.next = new ListNode(Integer.valueOf(val[i]));
              cur = cur.next;
          }
      }
      return header;
  }
  public static void print(ListNode root) {
      ListNode cur = root;
      while (cur != null) {
          System.out.println(cur.val);
          cur = cur.next;
      }

  }
}
