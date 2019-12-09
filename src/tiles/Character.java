package tiles;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hashCode(this.toString());
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Character) && ((Character) other).value == this.value;
    }
}
