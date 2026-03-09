package study.불변객체;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Counter c = new Counter(0);
        System.out.println(c.getCount());
        System.out.println(c.getCount());
        System.out.println(c.getCount());
        c.increment();
        System.out.println(c.getCount());
        Counter c1 = c.increment();
        System.out.println(c1.getCount());

        // 10만 개의 주문이 같은 주소를 써도 객체는 딱 1개만 생성!
        DeliveryAddress addr1 = AddressCache.get("서울시 강남구");
        DeliveryAddress addr2 = AddressCache.get("서울시 강남구");
        System.out.println(addr1 == addr2); // true — 같은 객체!


    }
}
