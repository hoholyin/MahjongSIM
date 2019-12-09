package tiles;

public class Dragon implements Tile {
    private DragonType dragonType;

    public Dragon(DragonType dragonType) {
        this.dragonType = dragonType;
    }

    public String toString() {
        switch (dragonType) {
        case RED:
            return "RED";
        case GREEN:
            return "GREEN";
        case WHITE:
            return "WHITE";
        }
        return "Error";
    }
}
