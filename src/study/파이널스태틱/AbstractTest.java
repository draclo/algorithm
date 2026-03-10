package study.파이널스태틱;

public abstract class AbstractTest {
    public abstract double area();
    public abstract double perimeter();

    public void printInfo() {
        System.out.println("넓이: " + area());
        System.out.println("둘레: " + perimeter());
    }
}
