package Poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/2/6 13:20
 */
public class PokerGame {
    public static final String[] suits = {"♣", "♠", "♥", "♦"};
    private static List<Card> burPoker() {
        // 向上转型
        List<Card> poker = new ArrayList<>();
        for (int i= 0; i < 4; i++) {
            for (int j = 2; j <= 10; j++) {
                poker.add(new Card("" +j, suits[i]));
            }
            poker.add(new Card("A", suits[i]));
            poker.add(new Card("J", suits[i]));
            poker.add(new Card("Q", suits[i]));
            poker.add(new Card("K", suits[i]));
        }
        poker.add(new Card("Big Joker", ""));
        poker.add(new Card("Small Joker", ""));
        return poker;
    }

    public static void shuffle(List<Card> poker) {
        Random random = new Random();
        for (int i = poker.size() - 1; i > 0; i--) {
            int pos = random.nextInt(i);
            swap(poker, i, pos);
        }
    }

    private static void swap(List<Card> poker, int i, int pos) {
        Card temp = poker.get(i);
        poker.set(i, poker.get(pos));
        poker.set(pos, temp);
    }

    public static void deal(List<Card> poker, List<Person> people) {
        Person person1 = new Person();
        Person person2 = new Person();
        people.add(person1);
        people.add(person2);
        for (int i = 0; i < poker.size() - 1; i += 2) {
            person1.cars1.add(poker.get(i));
            person2.cars1.add(poker.get(i + 1));
        }
    }
    public static void printPeoplePoker(List<Person> people) {
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }
    }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        List<Card> poker = burPoker();
        System.out.println(poker);
        shuffle(poker);
        System.out.println(poker);
        deal(poker, people);
        printPeoplePoker(people);
    }
    
}
