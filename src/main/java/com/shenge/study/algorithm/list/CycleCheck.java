package com.shenge.study.algorithm.list;

import java.util.HashSet;
import java.util.Set;

/**
 * Author : Shi Yue Sheng
 * Date : 2020/5/11
 * Time : 上午12:34
 * Desc : 单链表环路检测 LeetCode 141
 * 环内为何一定会相遇：巧妙的回答
 * 把慢跑者视作参考系，这样来思考，慢跑者站着不动，快跑者速度为1，就会发现一定会相遇
 */
public class CycleCheck {

    public class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 快慢指针
     * <p>
     * 刚才看了个环内快慢指针必然相遇的解释，很形象，不需要什么公式：
     * 慢指针步长1，快指针步长为2
     * 设参考系是慢指针，那么快指针相对于慢指针就是步长为1，在环内的节点间隔是1，
     * 那么它们必然相遇，也不会出现我曾经理解的从头顶跳过的情况。
     * <p>
     * 所以代码里不需要写
     * slow == fast.next （这是为了提前判断有环，并没有快多少）
     * 其实等价于 slow.next == fast.next.next
     * 再下一次行进中他俩直接就相遇了
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        //如果是空链表、单节点链表，则认为不存在环
        if (head == null || head.next == null) {
            return false;
        }

        //慢指针、快指针
        ListNode slow = head;
        ListNode fast = head.next;

        //判断快慢指针是否相等，
        //如果相等则认为有环
        //如果不相等则继续遍历，遍历到尾节点后则认为没有环（因为有环的话是不存在尾节点的）
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 散列表辅助
     * <p>
     * 使用散列表辅助处理，比较好理解，但是占用内存
     * 时间复杂度 O(n) 注：因为涉及到散列表的插入、查询，真实的时间消耗反客为主
     * 空间复杂度 O(n)
     *
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }


    /**
     * 特殊标记处理
     * 路子野，改变了链表
     * <p>
     * 你能用 O(1)（即，常量）内存解决此问题吗？
     * 能：
     * 思路：每次遍历是，断开他的next节点，并且将val设置为一个特殊值
     * 当遍历到尾部，走到下一个环的连接点时，next=null && val=特殊值，就说明这个访问过，直接返回true即可
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        ListNode temp;
        while (head != null) {
            if (head.next == null && head.val == Integer.MIN_VALUE) {
                return true;
            }
            temp = head.next;
            head.next = null;
            head.val = Integer.MIN_VALUE;
            head = temp;
        }
        return false;
    }

    //路子野，判断时间的，超过一定时间认为有环

}
