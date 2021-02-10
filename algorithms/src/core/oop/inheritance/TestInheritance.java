package core.oop.inheritance;

public class TestInheritance {
    public static void main(String[] args) {
        A a = new C();
        B b = (B) a;
        C c = (C) a;

        a.talk();
        a.talk();
        a.talk();
        b.talk();
        b.talk();
        b.talk();
        c.talk();
        c.talk();
        c.talk();

    }
}
