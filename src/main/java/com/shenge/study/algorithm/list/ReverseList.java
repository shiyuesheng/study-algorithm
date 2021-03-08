package com.shenge.study.algorithm.list;

/**
 * Author : Shi Yue Sheng
 * Date : 2020/5/10
 * Time : 下午11:32
 * Desc : 单链表反转， leecode 206
 */
public class ReverseList {

    public class ListNode {

        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 双指针迭代
     * 解题思路：参考了冒泡排序的交换思路
     * 区别是，这里交换的是前后位置，冒泡排序交换的是值。
     * 交换过程中需要一个临时节点中转，用来协助当前节点的反转、遍历
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode cur = head;//遍历过程中当前节点
        ListNode pre = null;//遍历过程中当前节点的前一个节点
        ListNode temp = null;//临时节点，用来协助当前节点反转
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 双节点从前向后递归
     * 上一种思路的递归写法
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        return reverseNode(pre, head);
    }

    /**
     * 因为 pre 跟 cur 是割裂的，所以要一块传递进来
     *
     * @param pre
     * @param cur
     * @return
     */
    public ListNode reverseNode(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }

        ListNode flag = cur.next;
        cur.next = pre;
        pre = cur;
        cur = flag;
        return reverseNode(pre, cur);
    }

    /**
     * 单节点从后向前递归
     * 1、如果当前链表为空，或者只有一个节点，直接返回
     * 2、反转当前节点后续的链表，看作一个新链表，并返回新链表的头节点
     * 3、后续的链表处理完成后，反转当前节点与后续链表，并返回新链表的头节点
     * 注意反转当前节点与后续链表时，一定要断开向前关联
     *
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        //head == null 判断初始 为空的情况
        //head.next == null 判断是否是最后一位，直接返回，一路返回
        if (head == null || head.next == null) {
            return head;
        }

        //处理下一个节点跟下下个节点的反转  一路返回最后的节点
        ListNode newHead = reverseList3(head.next);

        //反转当前节点跟下一个节点
        head.next.next = head;
        //断开向下的关系，防止循环
        head.next = null;

        //一路返回最后的节点
        return newHead;
    }

}
