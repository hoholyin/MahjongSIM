import java.util.ArrayList;
import java.util.Scanner;

import tiles.Tile;

public class Main {
    public static void main(String args[]) {
        /*
        Hand myHand = new Hand();
        Parser parser = new Parser();

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < Hand.MAX_TILES; i++) {
            Tile current = parser.parse(sc.next());
            myHand = myHand.add(current);
        }
         */
        Hand myHand = Hand.createSampleHand();
        ArrayList<Tile> result = myHand.solve();
        String message = resultMessage(result);
        System.out.println(message);
    }

    private static String resultMessage(ArrayList<Tile> winnableTiles) {
        if (winnableTiles.isEmpty()) {
            return "No winnable tiles!";
        }
        StringBuilder result = new StringBuilder();
        int numberOfWinnableTiles = (int) getNumberOfWinnableTiles(winnableTiles);
        appendHeaderWithCount(result, numberOfWinnableTiles);
        appendTilesToMessage(result, winnableTiles);
        return trimNewline(result);
    }

    private static void appendHeaderWithCount(StringBuilder message, int count) {
        message.append("Winnable tiles: " + count + "\n");
    }

    private static long getNumberOfWinnableTiles(ArrayList<Tile> tiles) {
        return tiles.stream().filter(tile -> tile != null).count();
    }

    private static void appendTilesToMessage(StringBuilder message, ArrayList<Tile> tiles) {
        tiles.stream().forEach(tile -> message.append(tile + "\n"));
    }

    private static String trimNewline(StringBuilder string) {
        return string.toString().substring(0, string.toString().length() - 1);
    }
}
