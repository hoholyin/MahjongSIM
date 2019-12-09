import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.IntStream;

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
        return editHand(tile, true);
    }

    public Hand remove(Tile tile) {
        return editHand(tile, false);
    }

    private Hand editHand(Tile tile, boolean isAdd) {
        ArrayList<Bamboo> newBamboos = new ArrayList<>(this.bamboos);
        ArrayList<Circle> newCircles = new ArrayList<>(this.circles);
        ArrayList<Character> newCharacters = new ArrayList<>(this.characters);
        ArrayList<Dragon> newDragons = new ArrayList<>(this.dragons);
        ArrayList<Wind> newWinds = new ArrayList<>(this.winds);
        if (tile instanceof Bamboo) {
            if (isAdd) {
                newBamboos.add((Bamboo) tile);
            } else {
                newBamboos.remove(tile);
            }
        } else if (tile instanceof Circle) {
            if (isAdd) {
                newCircles.add((Circle) tile);
            } else {
                newCircles.remove(tile);
            }
        } else if (tile instanceof Character) {
            if (isAdd) {
                newCharacters.add((Character) tile);
            } else {
                newCharacters.remove(tile);
            }
        } else if (tile instanceof Dragon) {
            if (isAdd) {
                newDragons.add((Dragon) tile);
            } else {
                newDragons.remove(tile);
            }
        } else if (tile instanceof Wind) {
            if (isAdd) {
                newWinds.add((Wind) tile);
            } else {
                newWinds.remove(tile);
            }
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
        hand = hand.add(new Character(9));
        hand = hand.add(new Character(9));
        return hand;
    }

    public ArrayList<Tile> solve() {
        assert count() == 13;
        ArrayList<Tile> remainingTilesOnTable = getRemainingTiles(this);
        ArrayList<Tile> winningTiles = new ArrayList<>();
        Hand originalHand = this;
        for (Tile t : remainingTilesOnTable) {
            Hand newHand = originalHand.add(t);
            if (newHand.isWinningHand()) {
                winningTiles.add(t);
            }
        }
        return winningTiles;
    }

    private boolean isWinningHand() {
        assert count() == 14;
        Hand currentHand = this;
        // 0 tai also considered win
        ArrayList<Tile> eyes = this.extractEyes();
        for (Tile t : eyes) {
            Hand newHand = currentHand.remove(t);
            newHand = newHand.remove(t);
            System.out.println(newHand);
        }
        return true;
    }

    private ArrayList<Tile> extractEyes() {
        HashSet<Tile> noDuplicates = new HashSet<>();
        noDuplicates.addAll(this.characters);
        noDuplicates.addAll(this.dragons);
        noDuplicates.addAll(this.circles);
        noDuplicates.addAll(this.bamboos);
        noDuplicates.addAll(this.winds);

        ArrayList<Tile> hand = new ArrayList<>();
        hand.addAll(this.characters);
        hand.addAll(this.dragons);
        hand.addAll(this.circles);
        hand.addAll(this.bamboos);
        hand.addAll(this.winds);

        noDuplicates.forEach(tile -> hand.remove(tile));

        HashSet<Tile> handNoDuplicates = new HashSet<>(hand);
        return new ArrayList<>(handNoDuplicates);
    }

    private ArrayList<Bamboo> getBamboos() {
        return bamboos;
    }

    private ArrayList<Circle> getCircles() {
        return circles;
    }

    private ArrayList<Character> getCharacters() {
        return characters;
    }

    private ArrayList<Dragon> getDragons() {
        return dragons;
    }

    private ArrayList<Wind> getWinds() {
        return winds;
    }

    private static ArrayList<Tile> getRemainingTiles(Hand hand) {
        ArrayList<Tile> tiles = getDefaultTiles();
        hand.getBamboos().forEach(tiles::remove);
        hand.getCircles().forEach(tiles::remove);
        hand.getCharacters().forEach(tiles::remove);
        hand.getWinds().forEach(tiles::remove);
        hand.getDragons().forEach(tiles::remove);
        HashSet<Tile> set = new HashSet<>(tiles); //remove duplicates
        return new ArrayList<>(set);
    }

    private static ArrayList<Tile> getDefaultTiles() {
        ArrayList<Tile> tiles = new ArrayList<>();

        IntStream.rangeClosed(1, 9).forEach(value -> {
            IntStream.rangeClosed(1, 4).forEach(i -> {
                tiles.add(new Bamboo(value));
                tiles.add(new Circle(value));
                tiles.add(new Character((value)));
            });
        });

        IntStream.rangeClosed(1, 4).forEach(i -> {
            tiles.add(new Wind(WindType.NORTH));
            tiles.add(new Wind(WindType.SOUTH));
            tiles.add(new Wind(WindType.EAST));
            tiles.add(new Wind(WindType.WEST));

            tiles.add(new Dragon(DragonType.RED));
            tiles.add(new Dragon(DragonType.GREEN));
            tiles.add(new Dragon(DragonType.WHITE));
        });
        return tiles;
    }

}
