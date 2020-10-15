package com.shenge.study.algorithm.list;

/**
 * Author : Shi Yue Sheng
 * Date : 2020/5/11
 * Time : 上午12:34
 * Desc : 最小栈 LeetCode 155
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 变种：合并成1个array，但是要额外维护一个当前的最小值
 */
public class MinStackByDoubleArray {

    private int[] sourceStack;
    private int[] minStack;
    private int sourceCount;
    private int minCount;

    public MinStackByDoubleArray() {
        this.sourceStack = new int[10000];
        this.minStack = new int[10000];
        this.sourceCount = 0;
        this.minCount = 0;
    }

    public void push(int x) {
        sourceStack[sourceCount] = x;
        ++ sourceCount;

        if (minCount == 0) {
            minStack[minCount] = x;
            ++ minCount;
        } else {
            if (x <= minStack[minCount - 1]) {
                minStack[minCount] = x;
                ++ minCount;
            }
        }
    }

    public void pop() {
        if (sourceCount == 0) {
            return;
        }

        int temp = sourceStack[sourceCount - 1];
        -- sourceCount;

        if (temp == minStack[minCount - 1]) {
            -- minCount;
        }

    }

    public int top() {
        return sourceStack[sourceCount -1];
    }

    public int getMin() {
        return minStack[minCount - 1];
    }

}
