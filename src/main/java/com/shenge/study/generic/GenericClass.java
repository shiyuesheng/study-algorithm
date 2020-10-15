package com.shenge.study.generic;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.Objects;

/**
 * @Author : Shi Yue Sheng
 * @Date : 2020/6/8
 * @Time : 下午1:14
 * @Desc : 范型类
 */

interface DemoA {}

interface DemoB {}

public class GenericClass<T1, T2 extends DemoA, T3 extends DemoA & DemoB> {

    public T1 test(T1 t1) {
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {

        //获取当前类上定义的范型变量列表
        TypeVariable<Class<GenericClass>>[] typeVariables = GenericClass.class.getTypeParameters();

        System.out.println(GenericClass.class.getSimpleName());

        Class<GenericClass> clazz = GenericClass.class;

        Method[] methods = clazz.getMethods();
        clazz.getMethod("test", Object.class);

        System.out.println(JSON.toJSONString(clazz));

        System.out.println(int.class.getTypeName());

        //循环打印范型变量
        for (TypeVariable<Class<GenericClass>> typeVariable : typeVariables) {

            /*
            TypeVariable<Class<GenericClass> 描述GenericClass类型上定义的范型变量
             */

            //范型变量的名称，T1、T2、T3
            System.out.println("变量名称：" + typeVariable.getName());

            //范型变量的声明者
            Class<GenericClass> genericClassClass = typeVariable.getGenericDeclaration();
            System.out.println(genericClassClass);

            //范型变量的上边界
            typeVariable.getBounds();

            System.out.println();

            System.out.println(typeVariable.getAnnotatedBounds());

            System.out.println();
        }

    }

}
