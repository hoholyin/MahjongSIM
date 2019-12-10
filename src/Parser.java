import tiles.Bamboo;
import tiles.Character;
import tiles.Circle;
import tiles.Dragon;
import tiles.DragonType;
import tiles.Suit;
import tiles.Tile;
import tiles.Wind;
import tiles.WindType;

public class Parser {
    private static final String BAMBOO_STRING = "B";
    private static final String CIRCLE_STRING = "C";
    private static final String CHARACTER_STRING = "W";
    private static final String RED_DRAGON = "RED";
    private static final String GREEN_DRAGON = "GREEN";
    private static final String WHITE_DRAGON = "WHITE";
    private static final String NORTH_WIND = "NORTH";
    private static final String SOUTH_WIND = "SOUTH";
    private static final String EAST_WIND = "EAST";
    private static final String WEST_WIND = "WEST";

    public Tile parse(String input) {
        // now we assume input is valid (number followed by C, B or W)
        switch (input) {
        case RED_DRAGON:
            return new Dragon(DragonType.RED);
        case GREEN_DRAGON:
            return new Dragon(DragonType.GREEN);
        case WHITE_DRAGON:
            return new Dragon(DragonType.WHITE);
        case NORTH_WIND:
            return new Wind(WindType.NORTH);
        case SOUTH_WIND:
            return new Wind(WindType.SOUTH);
        case EAST_WIND:
            return new Wind(WindType.EAST);
        case WEST_WIND:
            return new Wind(WindType.WEST);
        default:
            return extractAndParse(input);
        }
    }

    private Tile extractAndParse(String input) {
        int value = extractValue(input);
        if (isBamboo(input)) {
            return new Bamboo(value);
        } else if (isCircle(input)) {
            return new Circle(value);
        } else if (isCharacter(input)) {
            return new Character(value);
        }
        throw new IllegalArgumentException("No such type");
    }

    private int extractValue(String input) {
        return Integer.parseInt(input.substring(0, 1));
    }

    private boolean isBamboo(String input) {
        return input.substring(1).equals(BAMBOO_STRING);
    }

    private boolean isCircle(String input) {
        return input.substring(1).equals(CIRCLE_STRING);
    }

    private boolean isCharacter(String input) {
        return input.substring(1).equals(CHARACTER_STRING);
    }

}
