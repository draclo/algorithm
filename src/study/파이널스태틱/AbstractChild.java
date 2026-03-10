package study.파이널스태틱;

public class AbstractChild extends AbstractTest{

    private double radius;

    public AbstractChild(double radius) { this.radius = radius; }

    @Override
    public double area() { return Math.PI * radius * radius; }

    @Override
    public double perimeter() { return 2 * Math.PI * radius; }
}
