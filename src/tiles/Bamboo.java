package tiles;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hashCode(this.toString());
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Bamboo) && ((Bamboo) other).value == this.value;
    }
}
