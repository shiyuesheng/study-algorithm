package com.shenge.study.algorithm.list;

/**
 * Author : Shi Yue Sheng
 * Date : 2020/5/11
 * Time : 上午12:34
 * Desc : 删除链表的倒数第N个节点 LeetCode 19
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗
 */
public class RemoveNthFromEndA {

    public class ListNode {

        int val;

        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    ListNode preHead;

    int size = 0;

    int targetIndex = 0;

    /**
     * 两次循环查找
     * 第一次循环确定链表数量，size - n + 1 为目标节点
     * 第二次循环定位目标节点，删除
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        preHead = new ListNode(n, head);

        ListNode cursor = preHead.next;
        while (cursor != null) {
            ++ size;
            cursor = cursor.next;
        }

        targetIndex = size - n + 1;

        size = 1;
        cursor = preHead;
        while (size < targetIndex) {
            ++ size;
            cursor = cursor.next;
        }

        cursor.next = cursor.next.next;
        return preHead.next;
    }


}
