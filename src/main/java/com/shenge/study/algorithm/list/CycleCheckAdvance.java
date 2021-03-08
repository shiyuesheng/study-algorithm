package com.shenge.study.algorithm.list;

/**
 * Author : Shi Yue Sheng
 * Date : 2020/5/11
 * Time : 上午12:34
 * Desc : 单链表环路检测 进阶 LeetCode 141
 * 环内为何一定会相遇：巧妙的回答
 * 把慢跑者视作参考系，这样来思考，慢跑者站着不动，快跑者速度为1，就会发现一定会相遇
 */
public class CycleCheckAdvance {

    public class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
