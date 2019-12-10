package tiles;

public interface Suit extends Tile {
    int MAX_VALUE = 9;

    int getValue();

    Suit getNextTile();
}
