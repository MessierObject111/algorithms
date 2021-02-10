package com.java.se.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        Person person_1 = new Person(32, "Eric");
        Class personClass = Person.class;

        Field privateAgeField = Person.class.
                getDeclaredField("age");
        privateAgeField.setAccessible(true);
        System.out.println("Printing private field: --- " + privateAgeField);

        Method privateAgeMethod = Person.class.
                getDeclaredMethod("privateAge", null);
        privateAgeMethod.setAccessible(true);
        System.out.println("Printing private method: --- " + privateAgeMethod);
        //TODO: why this is still private after modified visibility in reflection?
//        int age = person_1.privateAge();

        Field[] fields   = personClass.getFields();
        Method[] methods = personClass.getMethods();

        System.out.println("Printing fields--------------");
        for(Field field : fields) {
            System.out.println(field);
        }
        System.out.println("Printing methods--------------");
        for(Method method : methods) {
            System.out.println(method);
        }
    }
}
