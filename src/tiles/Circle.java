package tiles;

public class Circle implements Tile {
    private int value;

    public Circle(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
