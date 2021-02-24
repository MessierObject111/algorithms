package com.java.se.exceptionHandling;

public class FinallyBlock {
    public int testFinallyBlock (){
        try {
            throw new NullPointerException();
        } catch(NullPointerException ea) {
            System.out.println("NullPointerException catch block");
            // There is only one situation that finally block is not executed. In try or catch block, the code execute System.exit(n) to stop JVM
            System.exit(-15);
            return 10;
        } catch(Exception e) {
            System.out.println("Exception catch block");
            return 20;
        } finally {
            System.out.println("Finally block");
            return 30;
        }
    }
    public static void main(String[] args) {
        FinallyBlock test = new FinallyBlock();
        System.out.println(test.testFinallyBlock());
    }
}
