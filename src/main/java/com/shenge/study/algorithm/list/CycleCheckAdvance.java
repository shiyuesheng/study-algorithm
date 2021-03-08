package com.shenge.study.algorithm.list;

import java.util.HashSet;
import java.util.Set;

/**
 * Author : Shi Yue Sheng
 * Date : 2020/5/11
 * Time : 上午12:34
 * Desc : 单链表环路检测 进阶 LeetCode 142
 * 返回环切入点节点
 */
public class CycleCheckAdvance {

    public class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * hash表，比较好理解，占用内存
     * 时间复杂度 O(n) 注：因为涉及到散列表的插入、查询，真实的时间消耗反客为主
     * 空间复杂度 O(n)
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return head;
    }

    /**
     * 快慢指针
     * slow 、fast同时从链表头节点出发，如果链表有环，那么一定会相遇。
     * 而且相遇的时候，slow在环内第一圈！第一圈！第一圈！尚未跑完，可以通过极限举例论证，
     * 例如：slow刚刚进入环的时候fast正好在后一个身位，并列，前一个身位，这几个极限情况都不会出现slow跑第二圈的情况。
     *
     * 设头节点到环切点的距离为 a
     * 设环切点到相遇点的距离为 b
     * 设相遇点到环切点的距离为 c
     *
     * 假设fast在与slow相遇之前已经再环内跑了n圈，可以得出下面公式：
     * 2(a + b) = a + n(b + c) + b ===>>> a + b = n(b + c) ===>>> a = (n - 1)(b + c) + c
     * 也就是说 a 的长度为从相遇点继续往下走到环切点 + n圈的举例
     * 也就是说 分别从头节点、相遇点继续遍历，将会在环切点相遇
     * 妙啊！妙！
     *
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        //如果是空链表、单节点链表，则认为不存在环
        if (head == null || head.next == null) {
            return null;
        }

        /**
         * 慢指针、快指针,一定要统一起跑线
         * 初始的步调一定要是head，不能这样写：slow = head，fast = head.next，
         * 这样快慢指针就不是从统一起跑线出发，相当于快指针提前走了一步，这样的话后面的逻辑需要补偿。
         */
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        //判断快慢指针是否相等，
        //如果相等则认为有环
        //如果不相等则继续遍历，遍历到尾节点后则认为没有环（因为有环的话是不存在尾节点的）
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        //程序运行到此处说明链表有环，相遇点为 slow、fast对应的指针
        //head 与 slow 同步的遍历，相遇的地方就是环切入点
        while (head != null) {
            if (head == slow) {
                return head;
            }
            head = head.next;
            slow = slow.next;
        }
        return null;
    }

}
