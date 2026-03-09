package study.불변객체;

public final class Counter {
    private final int count;

    public Counter(int count) { this.count = count; }
    public int getCount() { return count; }

    public Counter increment() {
        return new Counter(count + 1); // 새 객체 반환
    }
}
