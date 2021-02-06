package Poker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/2/6 14:29
 */
public class Person {
    public List<Card> cars1;
    public Person() {
        this.cars1 = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Person = {" + cars1 + '}';
    }
}
