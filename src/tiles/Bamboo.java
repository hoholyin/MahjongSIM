package tiles;

public class Bamboo implements Tile {
    private int value;

    public Bamboo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return value + "B";
    }
}
