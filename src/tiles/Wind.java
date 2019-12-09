package tiles;

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
}
