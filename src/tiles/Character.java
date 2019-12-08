package tiles;

public class Character implements Tile {
    private int value;

    public Character(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
