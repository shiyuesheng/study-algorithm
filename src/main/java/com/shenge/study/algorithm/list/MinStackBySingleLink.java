package com.shenge.study.algorithm.list;

/**
 * Author : Shi Yue Sheng
 * Date : 2020/5/11
 * Time : 上午12:34
 * Desc : 最小栈 LeetCode 155
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 逆生长的单链表
 */
public class MinStackBySingleLink {

    private ListNode head;

    public class ListNode {

        int val;

        int min;

        ListNode next;

        public ListNode(int val, int min, ListNode next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public void push(int x) {
        if (head == null) {
            head = new ListNode(x, x, null);
            return;
        }

        ListNode newNode = new ListNode(x, Math.min(head.min, x), head);
        head = newNode;
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

}
