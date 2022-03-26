package com.wangning.juejin.leetCode.day1;


//2. 两数相加

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution1 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 输出结果的链表
        ListNode resultNode = new ListNode(0);
        ListNode head = resultNode;
        // 记录进位数
        int carryNum = 0;

        while (l1 != null || l2 != null){
            // 判断两个链表中对应位置是否存在值 （可能连个链表位数不一致）
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;

            // 对应位置上的数字相加 以及加上进位数
            int tmpnum = num1 + num2 + carryNum;

            // 记录对应数字到链表
            head.next = new ListNode(tmpnum % 10 );

            //获取进位数
            carryNum = tmpnum / 10;

            head = head.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }

        // 如果最高位还有进位 补位。
        if (carryNum > 0) head.next = new ListNode(carryNum);
        return resultNode.next;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        ListNode dd = addTwoNumbers(l1,l2);

        while (dd != null){
            System.out.println(dd.val);
            dd = dd.next;
        }

    }
}