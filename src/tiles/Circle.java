package tiles;

public class Circle implements Suit {
    private int value;

    public Circle(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    public String toString() {
        return value + "C";
    }
}
