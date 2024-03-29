import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Card {
    String suit;
    String color;
    String value;

    public Card(String suit, String color, String value) {
        this.suit = suit;
        this.color = color;
        this.value = value;
    }

    @Override
    public String toString() {
        return suit + "," + color + "," + value;
    }
}


