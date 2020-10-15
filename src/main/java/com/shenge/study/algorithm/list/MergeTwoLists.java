package com.shenge.study.algorithm.list;

/**
 * Author : Shi Yue Sheng
 * Date : 2020/5/11
 * Time : 上午1:28
 * Desc : 合并两个有序链表 LeetCode 21
 */
public class MergeTwoLists {

    public class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode flag = preHead;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                flag.next = l1;
                l1 = l1.next;
            } else {
                flag.next = l2;
                l2 = l2.next;
            }
        }

        flag.next = l1 == null ? l2 : l1;

        return preHead.next;
    }


    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l1;
        }
        if (l2 == null) {
            return l2;
        }

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }
}
