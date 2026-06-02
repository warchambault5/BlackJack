import exceptions.InvaildAction;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private ArrayList<Card> hand;
    private Deck dealer;
    private boolean isTurn;

    public Player(Deck d) {
        hand = new ArrayList<Card>();
        dealer = d;
        isTurn = true;
        hand.add(dealer.deal());
        hand.add(dealer.deal());
    }

    public void runTurn() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Action (h/s)-> ");
        String decide = scanner.nextLine();
        switch (decide) {
            case "h" -> {
                getCard();
            }
            case "s" -> {
                isTurn = false;
            }
            default -> throw new InvaildAction();
        }

        if (calculateHand() > 21) {
            if (!checkAces()) {
                System.out.println();
                System.out.println("You busted you lose!");
                end();
            }
        }
    }

    public void getCard() {
        hand.add(dealer.deal());
    }

    public boolean isTurn() {
        return isTurn;
    }

    public boolean checkAces() {
        for (Card c : hand) {
            if (c.value() == 11) {
                c.aceLower();
                return true;
            }
        }
        return false;
    }

    public void end() {
        isTurn = false;
    }

    public void turn() {
        isTurn = true;
    }

    public int calculateHand() {
        int total = 0;
        for (Card c : hand) {
            total += c.value();
        }
        return total;
    }

    public int calculateCard(int i) {
        return hand.get(i).value();
    }

    public String handString() {
        String result = "";
        for (Card c : hand) {
            result += c.toString() + "\t\t";
        }
        return result;
    }
}
