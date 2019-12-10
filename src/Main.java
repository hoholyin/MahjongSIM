import java.util.ArrayList;
import java.util.Scanner;

import tiles.Tile;

public class Main {
    public static void main(String args[]) {
        Hand myHand = new Hand();
        Parser parser = new Parser();

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < Hand.MAX_TILES; i++) {
            Tile current = parser.parse(sc.next());
            myHand = myHand.add(current);
        }
        //Hand myHand = Hand.createSampleHand();
        ArrayList<Tile> result = myHand.solve();
        String message = resultMessage(result);
        System.out.println(message);
    }

    public static String resultMessage(ArrayList<Tile> winnableTiles) {
        if (winnableTiles.isEmpty()) {
            return "No winnable tiles!";
        }
        StringBuilder result = new StringBuilder();
        result.append("Winnable tiles: " + winnableTiles.size() + "\n");
        winnableTiles.stream().forEach(tile -> result.append(tile + "\n"));
        return result.toString().substring(0, result.toString().length() - 1);
    }
}
