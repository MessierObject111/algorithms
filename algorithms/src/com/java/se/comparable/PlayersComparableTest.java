package com.java.se.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayersComparableTest {
    public static void main(String[] args) {
        Player p1 = new Player(3, "Derek", 19);
        Player p2 = new Player(1, "Adam", 23);
        Player p3 = new Player(2, "Charlie", 33);

        System.out.println(p1.compareTo(p2));
        System.out.println(p2.compareTo(p1));
        System.out.println(p3.compareTo(p1));

        Car c1 = new Car("Honda", 134377, "Silver");
        Car c2 = new Car("Audi", 75626, "Black");
        Car c3 = new Car("Dodge", 30897, "White");

        CarComparator carComparator = new CarComparator();
        int result1 = carComparator.compare(c1, c2);
        System.out.println(result1);
        System.out.println("----------");

        List<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);

        List<Car> cars = new ArrayList<>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);

        Collections.sort(players);

    }
}
