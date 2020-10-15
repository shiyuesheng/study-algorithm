package com.shenge.study.algorithm.list;

/**
 * Author : Shi Yue Sheng
 * Date : 2020/5/11
 * Time : 上午12:34
 * Desc : 删除链表的倒数第N个节点 LeetCode 19
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗
 */
public class RemoveNthFromEndB {

    public class ListNode {

        int val;

        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    int space = 0;
    ListNode preHead;
    ListNode before;
    ListNode after;

    /**
     * 一次循环查找，双指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        preHead = new ListNode(n, head);
        before = preHead;
        after = head;

        while (after != null) {
            after = after.next;

            if (space == n) {
                before = before.next;
            } else {
                ++ space;
            }
        }

        before.next = before.next.next;
        return preHead.next;
    }

}
