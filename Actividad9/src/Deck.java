import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {
    ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"tréboles", "corazones", "picas", "diamantes"};
        String[] colors = {"negro", "rojo"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String suit : suits) {
            for (String color : colors) {
                for (String value : values) {
                    cards.add(new Card(suit, color, value));
                }
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (cards.isEmpty()) {
            System.out.println("No quedan cartas en el deck.");
            return;
        }
        Card card = cards.remove(0);
        System.out.println(card);
        System.out.println("Quedan " + cards.size() + " cartas en deck");
    }

    public void pick() {
        if (cards.isEmpty()) {
            System.out.println("No quedan cartas en el deck.");
            return;
        }
        int randomIndex = (int) (Math.random() * cards.size());
        Card card = cards.remove(randomIndex);
        System.out.println(card);
        System.out.println("Quedan " + cards.size() + " cartas en deck");
    }

    public void hand() {
        if (cards.size() < 5) {
            System.out.println("No hay suficientes cartas en el deck para generar una mano.");
            return;
        }
        for (int i = 0; i < 5; i++) {
            Card card = cards.remove(0);
            System.out.println(card);
        }
        System.out.println("Quedan " + cards.size() + " cartas en deck");
    }

    public static void showMenu() {
        System.out.println("Bienvenido a Poker!");
        System.out.println("Selecciona una opción:");
        System.out.println("1 Mezclar deck");
        System.out.println("2 Sacar una carta");
        System.out.println("3 Carta al azar");
        System.out.println("4 Generar una mano de 5 cartas");
        System.out.println("0 Salir");
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            showMenu();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    deck.shuffle();
                    break;
                case 2:
                    deck.head();
                    break;
                case 3:
                    deck.pick();
                    break;
                case 4:
                    deck.hand();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (option != 0);

        scanner.close();
    }
}
