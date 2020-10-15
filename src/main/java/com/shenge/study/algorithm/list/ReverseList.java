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

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;//换个名字舒服点，表示当前节点
        ListNode flag = null;
        while (cur != null) {
            flag = cur.next;
            cur.next = pre;
            pre = cur;
            cur = flag;
        }
        return pre;
    }

    /**
     * 单节点从后向前递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        //head == null 判断初始 为空的情况
        //head.next == null 判断是否是最后一位，直接返回，一路返回
        if (head == null || head.next == null ) {
            return head;
        }

        //处理下一个节点跟下下个节点的反转  一路返回最后的节点
        ListNode flag = reverseList2(head.next);

        //反转当前节点跟下一个节点
        head.next.next = head;
        //断开向下的关系，防止循环
        head.next = null;

        //一路返回最后的节点
        return flag;
    }

    /**
     * 双节点从前向后递归
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        ListNode pre = null;
        return reverseNode(pre, head);
    }

    /**
     * 因为 pre 跟 cur 是割裂的，所以要一块传递进来
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

}
