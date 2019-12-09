package tiles;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hashCode(this.toString());
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Circle) && ((Circle) other).value == this.value;
    }
}
