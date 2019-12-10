package tiles;

import java.util.Objects;

public class Character implements Suit, Comparable<Character> {
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

    @Override
    public Suit getNextTile() throws IllegalArgumentException {
        if (this.value == MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        return new Character(this.value + 1);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.toString());
    }

    @Override
    public int compareTo(Character other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Character) && ((Character) other).value == this.value;
    }
}
