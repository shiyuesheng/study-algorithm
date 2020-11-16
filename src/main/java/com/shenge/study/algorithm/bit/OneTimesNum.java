package com.shenge.study.algorithm.bit;

/**
 * @author : Shi Yue Sheng
 * @date : 2020/10/21
 * @time : 下午6:39
 * @desc :
 * 1、数组中只出现一次的一个数
 * 2、数组中只出现一次的两个数
 * <p>
 * 除了只出现一次的数以外，其他的都是出现两次
 */
public class OneTimesNum {

    /**
     * 数组中只出现一次的一个数
     *
     * @param nums
     * @return
     */
    public static int oneNum(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    /**
     * 数组中只出现一次的两个数
     *
     * @param nums
     * @return
     */
    public static int[] twoNums(int[] nums) {

        //得到异或结果，即为不相同两个数的异或结果sum
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }

        //得到sum的二进制的1的最低位
        int flag = (-sum) & sum;

        //结果集
        int result[] = new int[2];

        //分成两个组进行异或，每组异或后的结果就是不相同两个数的其中之一
        for (int num : nums) {
            if ((flag & num) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] oneNums = new int[]{1, 2, 3, 5, 3, 2, 1};
        int oneNumsResult = OneTimesNum.oneNum(oneNums);
        System.out.println("只出现一次的一个数：" + oneNumsResult);

        int[] twoNums = new int[]{1, 2, 3, 4, 5, 3, 2, 1};
        int[] twoNumsResult = OneTimesNum.twoNums(twoNums);
        System.out.println("只出现一次的两个数：" + twoNumsResult[0] + "," + twoNumsResult[1]);
    }
}
