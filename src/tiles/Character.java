package tiles;

public class Character implements Suit {
    private int value;

    public Character(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    public String toString() {
        return value + "W";
    }
}
