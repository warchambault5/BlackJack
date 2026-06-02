package exceptions;

public class DeckEmpty extends RuntimeException {
    public DeckEmpty() {
        super("Deck is empty!");
    }
}