package core.oop.nested;

public class A {
    class B {
        //static void foo() {}// right or wrong, if wrong what should it be?
        C c = new C();
    }
    static class C {
        static void foo() {}
        void foo2() {}
        //B b = new B();  // right or wrong, if wrong what should it be?
    }
    static void foo1() {
        //new B();  // right or wrong, if wrong what should it be?
        new C();
    }
    void foo2() {
        new B();
        new C();
    }}

