import exceptions.DeckEmpty;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        resetDeck();
    }

    // ace is 1
    public void resetDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        for (String suit : suits) {
            for (int value : values) {
                cards.add(new Card(value, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        if (cards.isEmpty()) {
            throw new DeckEmpty();
        }
        return cards.remove(cards.size() - 1);
    }
}
