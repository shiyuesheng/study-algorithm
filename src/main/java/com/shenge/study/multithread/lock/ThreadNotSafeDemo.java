package com.shenge.study.multithread.lock;

/**
 * @Author : Shi Yue Sheng
 * @Date : 2020/6/1
 * @Time : 下午1:09
 * @Desc : 下午1:09
 */
public class ThreadNotSafeDemo {

    private static class Count {
        private int num;
        private void count() {
            for (int i = 1; i <= 10; i++) {
                num ++;
            }
            System.out.println(Thread.currentThread().getName() + "-" + num);
        }
    }
    public static void main(String[] args) {
        Runnable runnable = runnableCount();
        //创建10个线程，
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

    }


    public static Runnable runnableCount() {
        Count count = new Count();
        Count count2 = new Count();
        return () -> {count.count();count2.count();};
    }
}
