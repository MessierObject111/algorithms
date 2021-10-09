package com.jvm.stringPool;

public class StringInternTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1 () {
        //When we use new keyword, String instances will always be created on heap, outside of StringPool
        String str1 = new String("Welcome to Java");
        String str2 = new String("Welcome to Java");
        System.out.println(str1 == str2); // prints false
    }

    private static void test2 () {
        //When we use String literals, Java will check if this string already exists in StringPool; if yes, it will
        // simply return the reference to that string, instead of creating new instance on heap;
        // if not, String instances will always be created and 'interned' to StringPool
        String str1 = "Welcome to test2";
        String str2 = "Welcome to test2";
        System.out.println(str1 == str2); // prints true
    }

    private static void test3 () {
        //intern() method will return the reference to the identical copy of given string in StringPool, if it is not in
        // StringPool, it will copy it there first before returning the reference to it
        String str1 = new String("Welcome to test3").intern(); // statement - 1
        String str2 = new String("Welcome to test3").intern(); // statement - 2
        System.out.println(str1 == str2); // prints true
    }

    private static void test4 () {
        System.out.println("test 4:");
        String str1 = new StringBuilder("ab").append("cd").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("abc").append("d").toString();
        System.out.println(str2.intern() == str2);

        String str3 = new StringBuilder("ab").append("cd").toString();
        System.out.println(str3.intern() == str3);

        String str4 = new String("abcd");
        System.out.println(str4.intern() == str4);

        String str5 = "abcd";
        System.out.println(str5.intern() == str5);
    }
}
