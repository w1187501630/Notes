package com.wangning.juejin.leetCode.day15;

//25. k个一组反转链表
class Solution {


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

    public ListNode reverseKGroup(ListNode head, int k) {
        // 特殊情况直接返回
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        // 记录要反转的子链表
        ListNode tail = head;
        ListNode start = dummy;

        while (tail != null) {
            // 记录是否到达k了
            int cnt = 0;
            while (cnt < k && tail != null) {
                tail = tail.next;
                cnt++;
            }

            // tail为null但是cnt没数到k个，不反转
            if (cnt < k) {
                break;
            }
            // 下一个子链表的头
            ListNode tmp = start.next;
            // 反转
            reverse(start, tail);
            start = tmp;
        }
        return dummy.next;
    }

    public void reverse(ListNode head, ListNode tail) {
        if (head == tail || head.next == tail) {
            return;
        }
        ListNode p1 = head.next;
        ListNode p2 = head.next.next;
        while (p2 != null && p2 != tail) {
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        head.next.next = tail;
        head.next = p1;
    }
}