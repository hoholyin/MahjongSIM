public class Main {
    public static void main(String args[]) {
        /*
        Hand myHand = new Hand();
        Parser parser = new Parser();

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < Hand.MAX_TILES; i++) {
            Suit current = parser.parse(sc.next());
            myHand = myHand.add(current);
        }
        */
        Hand myHand = Hand.createSampleHand();
        System.out.println(myHand);
    }
}
