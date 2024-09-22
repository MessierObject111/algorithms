package com.java.se.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlayersComparableTest {
    public static void main(String[] args) {
        Player p1 = new Player(3, "Derek", 19);
        Player p2 = new Player(1, "Adam", 23);
        Player p3 = new Player(2, "Charlie", 33);

        System.out.println(p1.compareTo(p2));
        System.out.println(p2.compareTo(p1));
        System.out.println(p3.compareTo(p1));

        Car c1 = new Car("Honda", 134377, "Silver", 4599.99);
        Car c2 = new Car("Audi", 75626, "Black", 15599.99);
        Car c3 = new Car("Dodge", 30897, "White",28500.99);

        CarComparatorByMileage carComparatorByMileage = new CarComparatorByMileage();
        int result1 = carComparatorByMileage.compare(c1, c2);
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
        players.stream().forEach(player -> System.out.println(player.getName() + "-"+ player.getRanking()));

        System.out.println("-----Sort car by mileage-----");
        Collections.sort(cars, new CarComparatorByMileage());
        cars.stream().forEach(car -> System.out.println(car.getManufacturer() + ", mileage:"+car.getMileage()));

        System.out.println("-----Sort car by price-----");
        Collections.sort(cars, new CarComparatorByPrice());
        cars.stream().forEach(car -> System.out.println(car.getManufacturer() + ", price:"+car.getPrice()));

        System.out.println("-----Sort by anonymous Comparator class with custom logic-----");

        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getMileage() - o2.getMileage();
            }
        });
        cars.stream().forEach(car -> System.out.println(car.getManufacturer() + ", mileage:"+car.getMileage()));

    }
}
