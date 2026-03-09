package study.불변객체;

public class DeliveryAddress {
    private final String address;

    public DeliveryAddress(String address) {
        this.address = address;
    }
    public String getAddress() { return address; }
}
