package com.java.se;

import java.util.ArrayList;

public class ClassLoaderTest {
    public static void printClassLoaders() throws ClassNotFoundException {

        System.out.println("Classloader of this class:"
                + ClassLoaderTest.class.getClassLoader());

        //External libs
//        System.out.println("Classloader of Logging:"
//                + Logging.class.getClassLoader());

        System.out.println("Classloader of ArrayList:"
                + ArrayList.class.getClassLoader());
    }

//    Classloader of this class:jdk.internal.loader.ClassLoaders$AppClassLoader@c387f44
//    Classloader of SLF4JLogger:jdk.internal.loader.ClassLoaders$AppClassLoader@c387f44
//    Classloader of ArrayList:null
    public static void main(String[] args, int num, String param) throws ClassNotFoundException {
        printClassLoaders();
        main(args);
    }

    public static void main(String[] args ) throws ClassNotFoundException {
        printClassLoaders();
    }
}
