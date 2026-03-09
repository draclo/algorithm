package study.불변객체;

import java.util.HashMap;
import java.util.Map;

public class AddressCache {
    private static final Map<String, DeliveryAddress> cache = new HashMap<>();

    public static DeliveryAddress get(String address) {
        // 없으면 만들고, 있으면 같은 객체 재사용
        return cache.computeIfAbsent(address, DeliveryAddress::new);
    }
}
