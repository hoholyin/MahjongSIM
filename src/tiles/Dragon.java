package tiles;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hashCode(this.toString());
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Dragon) && ((Dragon) other).dragonType.equals(this.dragonType);
    }
}
