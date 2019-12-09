import java.util.ArrayList;

import tiles.Bamboo;
import tiles.Circle;
import tiles.Character;
import tiles.Dragon;
import tiles.DragonType;
import tiles.Suit;
import tiles.Tile;
import tiles.Wind;
import tiles.WindType;

public class Hand {
    public static final int MAX_TILES = 13;

    private ArrayList<Bamboo> bamboos;
    private ArrayList<Circle> circles;
    private ArrayList<Character> characters;
    private ArrayList<Dragon> dragons;
    private ArrayList<Wind> winds;

    public Hand() {
        bamboos = new ArrayList<>();
        circles = new ArrayList<>();
        characters = new ArrayList<>();
        dragons = new ArrayList<>();
        winds = new ArrayList<>();
    }

    private Hand(ArrayList<Bamboo> bamboos, ArrayList<Circle> circles,
                 ArrayList<Character> characters, ArrayList<Dragon> dragons, ArrayList<Wind> winds) {
        this.bamboos = bamboos;
        this.circles = circles;
        this.characters = characters;
        this.dragons = dragons;
        this.winds = winds;
    }

    private int count() {
        return bamboos.size() + circles.size() + characters.size() + dragons.size() + winds.size();
    }

    public Hand add(Tile tile) {
        ArrayList<Bamboo> newBamboos = new ArrayList<>(this.bamboos);
        ArrayList<Circle> newCircles = new ArrayList<>(this.circles);
        ArrayList<Character> newCharacters = new ArrayList<>(this.characters);
        ArrayList<Dragon> newDragons = new ArrayList<>(this.dragons);
        ArrayList<Wind> newWinds = new ArrayList<>(this.winds);
        if (tile instanceof Bamboo) {
            newBamboos.add((Bamboo) tile);
        } else if (tile instanceof Circle) {
            newCircles.add((Circle) tile);
        } else if (tile instanceof Character) {
            newCharacters.add((Character) tile);
        } else if (tile instanceof Dragon) {
            newDragons.add((Dragon) tile);
        } else if (tile instanceof Wind) {
            newWinds.add((Wind) tile);
        }
        return new Hand(newBamboos, newCircles, newCharacters, newDragons, newWinds);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        this.bamboos.forEach(bamboo -> result.append(bamboo + " "));
        this.circles.forEach(circle -> result.append(circle + " "));
        this.characters.forEach(character -> result.append(character + " "));
        this.winds.forEach(winds -> result.append(winds + " "));
        this.dragons.forEach(dragon -> result.append(dragon + " "));
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
        hand = hand.add(new Dragon(DragonType.RED));
        hand = hand.add(new Wind(WindType.NORTH));
        return hand;
    }

    public ArrayList<Suit> solve() {
        assert count() == 13;
        ArrayList<Suit> remainingTilesOnTable = getRemainingTiles(this);
        return remainingTilesOnTable;
    }

    private static ArrayList<Suit> getRemainingTiles(Hand hand) {
        ArrayList<Suit> suits = new ArrayList<>();
        return suits;
    }

}
