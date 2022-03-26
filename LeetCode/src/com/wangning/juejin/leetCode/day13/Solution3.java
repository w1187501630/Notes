package com.wangning.juejin.leetCode.day13;


//19. 删除链表的倒数第 N 个结点
class Solution3 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode R = head;
        ListNode L = dummy;
        for (int i = 0; i < n; ++i) {
            R = R.next;
        }
        while (R != null) {
            R = R.next;
            L = L.next;
        }
        L.next = L.next.next;
        ListNode res = dummy.next;
        return res;
    }

    public class ListNode {
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
}

