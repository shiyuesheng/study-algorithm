package com.shenge;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Author : Shi Yue Sheng
 * Date : 2018/5/28
 * Time : 上午2:32
 */
public class HelloWorld {

    public static void main(String[] args) {

        new ClassPathXmlApplicationContext();

        new FileSystemXmlApplicationContext();


//        String s1 = "ab" + "cd";
//        String s2 = "abcd";
//        System.out.println(s1 == s2);

//        final String s1 = "b";
//        String s2 = "a" + s1;
//        String s12 = "ab";
//        System.out.println(s2 == s12);


    }
}
