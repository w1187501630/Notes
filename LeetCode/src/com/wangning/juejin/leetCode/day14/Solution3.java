package com.wangning.juejin.leetCode.day14;


//24. 两两交换链表中的节点

public class Solution3 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode tmpNode = dummyHead;

        while (tmpNode.next != null && tmpNode.next.next != null){
             ListNode l1 = tmpNode.next;
             ListNode l2 = tmpNode.next.next;

             tmpNode.next = l2;
             l1.next = l2.next;
             l2.next = l1;
             tmpNode = l1;

        }

        return dummyHead.next;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));

        ListNode node = swapPairs(listNode);

        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }



}
