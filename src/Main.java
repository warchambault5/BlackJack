public class Main {
    public static void printGame(Player d, Player p) {
        System.out.println("=============================================================================================================");
        System.out.println("Dealer:\t\t" + d.handString() + "You:\t\t" + p.handString());
        System.out.println("=============================================================================================================");
        System.out.println("Dealer:  " + d.calculateHand() + "\t\t" + "You:  " + p.calculateHand());
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("********************************************** Blackjack ****************************************************");
        System.out.println();
        Deck deck = new Deck();
        deck.shuffle();
        Player me = new Player(deck);
        Dealer dealer = new Dealer(deck);
        while (me.isTurn()) {
            printGame(dealer, me);
            me.runTurn();
            if (!me.isTurn()) {
                if (me.calculateHand() > 21) { printGame(dealer, me); System.exit(0); }
            }
        }
        dealer.turn();
        while (dealer.isTurn()) {
            Thread.sleep(750);
            dealer.runTurn();
            printGame(dealer, me);
            if (dealer.calculateHand() > 21) { System.exit(0); }
        }
        if (me.calculateHand() == dealer.calculateHand()) {
            System.out.println();
            System.out.println("You Tied!!!!");
            System.exit(0);
        }
        else if (me.calculateHand() > dealer.calculateHand()) {
            System.out.println();
            System.out.println("You win $" + (int) (Math.random() * 10000) + "!!!");
            System.exit(0);
        }
        System.out.println();
        System.out.println("You lose :(");
    }
}