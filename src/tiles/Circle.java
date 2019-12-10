package tiles;

import java.util.Objects;

public class Circle implements Suit, Comparable<Circle> {
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

    @Override
    public Suit getNextTile() throws IllegalArgumentException {
        if (this.value == MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        return new Circle(this.value + 1);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.toString());
    }

    @Override
    public int compareTo(Circle other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Circle) && ((Circle) other).value == this.value;
    }
}
