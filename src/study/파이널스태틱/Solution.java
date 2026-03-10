package study.파이널스태틱;

import study.불변객체.AddressCache;
import study.불변객체.Counter;
import study.불변객체.DeliveryAddress;

class Solution {

    public static void main(String[] args) {
        AbstractTest t = new AbstractChild(5);
        t.printInfo();

        StaticTest s1 = new StaticTest();
        StaticTest s2 = new StaticTest();

        s1.increment();
        s1.increment();
        s2.increment();

        System.out.println(StaticTest.total);
        System.out.println(s1.myCount);
        System.out.println(s2.myCount);

        FinalTest f1 = new FinalTest();
        f1.MAX = 200;
    }
}
