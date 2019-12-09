package tiles;

import java.util.Objects;

public class Wind implements Tile {
    private WindType windType;

    public Wind(WindType windType) {
        this.windType = windType;
    }

    public String toString() {
        switch (windType) {
        case NORTH:
            return "N";
        case SOUTH:
            return "S";
        case EAST:
            return "E";
        case WEST:
            return "W";
        }
        return "Error";
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.toString());
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Wind) && ((Wind) other).windType.equals(this.windType);
    }
}
