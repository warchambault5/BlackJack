import exceptions.InvaildAction;

import java.util.Scanner;

public class Dealer extends Player{
    private boolean cardUp;

    public Dealer(Deck d) {
        super(d);
        cardUp = false;
    }

    public void runTurn() {
        cardUp = true;
        if (super.calculateHand() < 17) {
            super.getCard();
            System.out.println();
            System.out.println("Dealer hits");
        }
        else {
            System.out.println();
            System.out.println("Dealer stands");
            end();
        }
        if (calculateHand() > 21) {
            if (!checkAces()) {
                System.out.println();
                System.out.println("The dealer busted you win!!");
                end();
            }
        }
    }

    public String handString() {
        if (!cardUp) {
            return super.handString().substring(0, 2) + "\t\t" + "**" + "\t\t";
        }
        return super.handString();
    }

    public int calculateHand() {
        if (!cardUp) {
            return calculateCard(0);
        }
        return super.calculateHand();
    }
}
