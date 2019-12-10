package tiles;

import java.util.Objects;

public class Bamboo implements Suit, Comparable<Bamboo> {
    private int value;

    public Bamboo(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public Suit getNextTile() throws IllegalArgumentException {
        if (this.value == MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        return new Bamboo(this.value + 1);
    }

    public String toString() {
        return value + "B";
    }

    @Override
    public int compareTo(Bamboo other) {
        return Integer.compare(this.value, other.value);
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
