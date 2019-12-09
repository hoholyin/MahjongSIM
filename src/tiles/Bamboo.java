package tiles;

public class Bamboo implements Suit {
    private int value;

    public Bamboo(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    public String toString() {
        return value + "B";
    }
}
