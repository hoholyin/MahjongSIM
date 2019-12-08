import tiles.Bamboo;
import tiles.Character;
import tiles.Circle;
import tiles.Tile;

public class Parser {
    private static final String BAMBOO_STRING = "B";
    private static final String CIRCLE_STRING = "C";
    private static final String CHARACTER_STRING = "W";

    public Tile parse(String input) throws IllegalArgumentException {
        // now we assume input is valid (number followed by C, B or W)
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
