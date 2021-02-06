package Poker;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/2/1 14:50
 */
public class Card {
    // 点数
    String rank;
    // 花色
    String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "(" + rank + suit + ')';
    }
}
