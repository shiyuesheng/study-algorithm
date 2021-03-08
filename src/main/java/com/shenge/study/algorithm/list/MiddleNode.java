package com.shenge.study.algorithm.list;

/**
 * Author : Shi Yue Sheng
 * Date : 2020/5/11
 * Time : 上午12:34
 * Desc : 链表的中间结点 LeetCode 876
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {

    public class ListNode {

        int val;

        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 快慢指针
     *
     * 1 -> 2 -> 3 -> 4 -> 5
     * 1 -> 3 -> 5 -> 7 -> 9
     *
     * 慢指针对应的永远是快指针的中位
     * 遍历结束后，
     * 如果快指针指向的是尾节点，说明当前链表长度为奇数，慢指针对应的是中间节点
     * 如果快指针指向的是null，说明当前链表长度为偶数，慢指针对应的是中间两个节点的第二个节点
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 快慢指针
     * 快指针早先一步
     *
     * 1 -> 2 -> 3 -> 4 -> 5
     * 2 -> 4 -> 6 -> 8 -> 10
     *
     * 遍历结束后，
     * 如果快指针指向的是尾节点，说明当前链表长度为偶数，慢指针对应的是中间两个节点的第一个节点
     * 如果快指针指向的是null，说明当前链表长度为奇数，慢指针对应的是中间节点
     *
     */
    public ListNode middleNode1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 其他思路一
     * 数组辅助容器，所有数据节点导入数组中，得出长度n，计算中位数
     * 根据数组的随机访问特性直接获取中位节点。
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */

    /**
     * 其他思路二
     * 二次遍历
     * 第一次遍历获取链表长度，计算中位数
     * 第二次遍历找到对应的节点
     */

}
