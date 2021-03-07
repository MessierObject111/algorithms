package com.alg.other;

import java.util.HashSet;

public class DumpJVM {
    public static void main(String arg[]) {
        Object[] obj = null;
        while (true) {
            obj = new Object[]{obj};
        }


    }
}
//    Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//        at com.mercury.code.DumpJVM.main(DumpJVM.java:7)
