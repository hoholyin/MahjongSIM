import java.util.ArrayList;
import java.util.stream.IntStream;

import tiles.Bamboo;
import tiles.Circle;
import tiles.Character;
import tiles.Tile;

public class Hand {
    public static final int MAX_TILES = 13;

    private ArrayList<Bamboo> bamboos;
    private ArrayList<Circle> circles;
    private ArrayList<Character> characters;

    public Hand() {
        bamboos = new ArrayList<>();
        circles = new ArrayList<>();
        characters = new ArrayList<>();
    }

    private Hand(ArrayList<Bamboo> bamboos, ArrayList<Circle> circles, ArrayList<Character> characters) {
        this.bamboos = bamboos;
        this.circles = circles;
        this.characters = characters;
    }

    public Hand add(Tile tile) {
        ArrayList<Bamboo> newBamboos = new ArrayList<>(this.bamboos);
        ArrayList<Circle> newCircles = new ArrayList<>(this.circles);
        ArrayList<Character> newCharacters = new ArrayList<>(this.characters);
        if (tile instanceof Bamboo) {
            newBamboos.add((Bamboo) tile);
        } else if (tile instanceof Circle) {
            newCircles.add((Circle) tile);
        } else if (tile instanceof Character) {
            newCharacters.add((Character) tile);
        }
        return new Hand(newBamboos, newCircles, newCharacters);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        this.bamboos.forEach(bamboo -> result.append(bamboo + " "));
        this.circles.forEach(circle -> result.append(circle + " "));
        this.characters.forEach(character -> result.append(character + " "));
        return result.toString();
    }

    public static Hand createSampleHand() {
        Hand hand = new Hand();
        hand = hand.add(new Character(1));
        hand = hand.add(new Character(1));
        hand = hand.add(new Character(1));
        hand = hand.add(new Character(2));
        hand = hand.add(new Character(3));
        hand = hand.add(new Character(4));
        hand = hand.add(new Character(5));
        hand = hand.add(new Character(6));
        hand = hand.add(new Character(7));
        hand = hand.add(new Character(8));
        hand = hand.add(new Character(9));
        hand = hand.add(new Character(9));
        hand = hand.add(new Character(9));
        return hand;
    }
}
