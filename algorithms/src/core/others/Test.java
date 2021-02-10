package core.others;

import jdk.nashorn.internal.ir.annotations.Immutable;

@Immutable
public class Test {
    float x = 1.2f;

    public static void main(String[] args) {
        Integer x = 1000, y = 1000;
        System.out.println(x==y);      	//
        System.out.println(x>=y);      	//  xx

    }
}
