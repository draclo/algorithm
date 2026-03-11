package study.람다StreamAPI;

import java.util.*;
import java.util.stream.*;

public class StreamExamples {

    record Order(String id, String status, int amount, String region) {}

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> names = List.of("김철수", "이영희", "박민준", "최지원", "정수현");
        List<Order> orders = List.of(
                new Order("001", "DELIVERED", 15000, "서울"),
                new Order("002", "SHIPPING",  8000,  "부산"),
                new Order("003", "DELIVERED", 32000, "서울"),
                new Order("004", "CANCELLED", 5000,  "대구"),
                new Order("005", "DELIVERED", 21000, "부산"),
                new Order("006", "SHIPPING",  9000,  "서울")
        );


        // ── 1. filter ── 조건에 맞는 요소만 추출 ──────────────────────────
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)              // Predicate<Integer>  : T → boolean
                .collect(Collectors.toList());
        // [2, 4, 6, 8, 10]

        List<Integer> event1 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(event1);

        for (int i = 0; i < 10; i++) {
            System.out.println(i / 3); //0001112223
            System.out.println(i % 3); //0120120120
        }

        // ── 2. map ── 각 요소를 변환 ──────────────────────────────────────
        List<Integer> amounts = orders.stream()
                .map(o -> o.amount())                  // Function<Order, Integer>  : T → R
                .collect(Collectors.toList());
        // [15000, 8000, 32000, 5000, 21000, 9000]

        List<String> status = orders.stream()
                .map(o -> o.status)
                .collect(Collectors.toList());

        // ── 3. mapToInt + sum ── 합계 ─────────────────────────────────────
        int totalAmount = orders.stream()
                .mapToInt(o -> o.amount())             // ToIntFunction<Order>  : T → int
                .sum();
        // 90000


        // ── 4. sorted ── 정렬 ─────────────────────────────────────────────
        List<Order> sortedByAmount = orders.stream()
                .sorted((a, b) -> b.amount() - a.amount()) // Comparator<Order>  : (T, T) → int
                .collect(Collectors.toList());
        // 32000 → 21000 → 15000 → ...

        // 금액 내림차순으로 정렬
        List<Order> sorted = orders.stream()
                .sorted(Comparator.comparingInt(Order::amount).reversed())
                .collect(Collectors.toList());

        // 카테고리 오름차순 → 금액 내림차순 2단계 정렬
        List<Order> sorted1 = orders.stream()
                .sorted(Comparator.comparing(Order::status)
                .thenComparing(Comparator.comparingInt(Order::amount).reversed()))
                .collect(Collectors.toList());

        // ── 5. distinct ── 중복 제거 ──────────────────────────────────────
        List<String> regions = orders.stream()
                .map(o -> o.region())                  // Function<Order, String>  : T → R
                .distinct()
                .collect(Collectors.toList());
        // ["서울", "부산", "대구"]


        // ── 6. limit ── 앞에서 n개만 ─────────────────────────────────────
        List<Integer> firstThree = numbers.stream()
                .limit(3)                              // 함수형 인터페이스 없음 (long 값)
                .collect(Collectors.toList());
        // [1, 2, 3]


        // ── 7. skip ── 앞에서 n개 건너뛰기 ───────────────────────────────
        List<Integer> afterThree = numbers.stream()
                .skip(3)                               // 함수형 인터페이스 없음 (long 값)
                .collect(Collectors.toList());
        // [4, 5, 6, 7, 8, 9, 10]


        // ── 8. anyMatch ── 하나라도 조건 만족하면 true ────────────────────
        boolean hasCancelled = orders.stream()
                .anyMatch(o -> o.status().equals("CANCELLED")); // Predicate<Order>  : T → boolean
        // true


        // ── 9. allMatch ── 모두 조건 만족하면 true ────────────────────────
        boolean allDelivered = orders.stream()
                .allMatch(o -> o.status().equals("DELIVERED")); // Predicate<Order>  : T → boolean
        // false


        // ── 10. noneMatch ── 모두 조건 불만족하면 true ────────────────────
        boolean noPending = orders.stream()
                .noneMatch(o -> o.status().equals("PENDING")); // Predicate<Order>  : T → boolean
        // true


        // ── 11. count ── 개수 세기 ────────────────────────────────────────
        long deliveredCount = orders.stream()
                .filter(o -> o.status().equals("DELIVERED"))   // Predicate<Order>  : T → boolean
                .count();
        // 3


        // ── 12. findFirst ── 첫 번째 요소 가져오기 ───────────────────────
        Optional<Order> firstSeoul = orders.stream()
                .filter(o -> o.region().equals("서울"))         // Predicate<Order>  : T → boolean
                .findFirst();                                   // 함수형 인터페이스 없음
        firstSeoul.ifPresent(o -> System.out.println(o.id())); // Consumer<Order>  : T → void


        // ── 13. min / max ── 최솟값 / 최댓값 ─────────────────────────────
        Optional<Order> cheapest = orders.stream()
                .min(Comparator.comparingInt(o -> o.amount())); // Comparator<Order>  : (T, T) → int

        Optional<Order> mostExpensive = orders.stream()
                .max(Comparator.comparingInt(o -> o.amount())); // Comparator<Order>  : (T, T) → int


        // ── 14. reduce ── 누적 연산 ───────────────────────────────────────
        int total = numbers.stream()
                .reduce(0, (acc, n) -> acc + n);       // BinaryOperator<Integer>  : (T, T) → T
        // 55


        // ── 15. collect(joining) ── 문자열 합치기 ────────────────────────
        String nameList = names.stream()
                .collect(Collectors.joining(", "));    // 함수형 인터페이스 없음 (Collector 사용)
        // "김철수, 이영희, 박민준, 최지원, 정수현"


        // ── 16. collect(groupingBy) ── 그룹화 ────────────────────────────
        Map<String, List<Order>> byRegion = orders.stream()
                .collect(Collectors.groupingBy(
                        o -> o.region()                    // Function<Order, String>  : T → R
                ));
        // { "서울": [...], "부산": [...], "대구": [...] }


        // ── 17. collect(groupingBy + counting) ── 그룹별 개수 ────────────
        Map<String, Long> countByStatus = orders.stream()
                .collect(Collectors.groupingBy(
                        o -> o.status(),                   // Function<Order, String>  : T → R
                        Collectors.counting()              // 함수형 인터페이스 없음 (Collector 사용)
                ));
        // { "DELIVERED": 3, "SHIPPING": 2, "CANCELLED": 1 }


        // ── 18. collect(groupingBy + summingInt) ── 그룹별 합계 ──────────
        Map<String, Integer> sumByRegion = orders.stream()
                .collect(Collectors.groupingBy(
                        o -> o.region(),                   // Function<Order, String>  : T → R
                        Collectors.summingInt(o -> o.amount()) // ToIntFunction<Order>  : T → int
                ));
        // { "서울": 56000, "부산": 29000, "대구": 5000 }


        // ── 19. flatMap ── 중첩 리스트 펼치기 ────────────────────────────
        List<List<Integer>> nested = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );
        List<Integer> flat = nested.stream()
                .flatMap(list -> list.stream())        // Function<List<Integer>, Stream<Integer>>  : T → Stream<R>
                .collect(Collectors.toList());
        // [1, 2, 3, 4, 5, 6, 7, 8, 9]


        // ── 20. filter + map + sorted + limit 조합 ────────────────────────
        List<String> top2SeoulDelivered = orders.stream()
                .filter(o -> o.region().equals("서울"))           // Predicate<Order>     : T → boolean
                .filter(o -> o.status().equals("DELIVERED"))      // Predicate<Order>     : T → boolean
                .sorted((a, b) -> b.amount() - a.amount())        // Comparator<Order>    : (T, T) → int
                .limit(2)                                         // 함수형 인터페이스 없음
                .map(o -> o.id() + " : " + o.amount() + "원")     // Function<Order, String> : T → R
                .collect(Collectors.toList());
        // ["003 : 32000원", "001 : 15000원"]
    }
}