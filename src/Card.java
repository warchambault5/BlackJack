public class Card {
    private String suit;
    private int value;
    private int index;


    //  index: hearts, diamonds, clubs, spades
    //  a : 1
    public Card(int v, String s) {
        suit = s;
        if (v == 1) {
            value = 11;
            index = v;
        }
        else if (v > 10) {
            value = 10;
            index = v;
        }
        else {
            value = v;
            index = v;
        }
    }

    public String toString() {
        return suit.charAt(0) + rank();
    }

    public String rank() {
        return switch (index) {
            case 1 -> "A";
            case 2 -> "2";
            case 3 -> "3";
            case 4 -> "4";
            case 5 -> "5";
            case 6 -> "6";
            case 7 -> "7";
            case 8 -> "8";
            case 9 -> "9";
            case 10 -> "10";
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            default -> "";
        };
    }

    public int value() {
        return value;
    }

    public void aceLower() {
        value -= 10;
    }

    public String suit() {
        return suit;
    }
}
