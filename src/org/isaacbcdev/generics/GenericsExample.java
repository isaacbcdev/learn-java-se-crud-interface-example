package org.isaacbcdev.generics;

import org.isaacbcdev.generics.models.Animal;
import org.isaacbcdev.generics.models.Car;
import org.isaacbcdev.generics.models.Machinery;
import org.isaacbcdev.generics.models.Truck;

public class GenericsExample {
    public static void main(String[] args) {
        Truck<Animal> animalTransport = new Truck<>(10);
        animalTransport.add(new Animal("Lightning", "Horse"));
        animalTransport.add(new Animal("Shadow", "Horse"));
        animalTransport.add(new Animal("Midnight", "Horse"));
        animalTransport.add(new Animal("Cinnamon", "Horse"));

        printTruck(animalTransport);

        Truck<Machinery> heavyMachineryTransport = new Truck<>(3);
        heavyMachineryTransport.add(new Machinery("Backhoe"));
        heavyMachineryTransport.add(new Machinery("Bulldozer"));
        heavyMachineryTransport.add(new Machinery("Excavator"));

        printTruck(heavyMachineryTransport);

        Truck<Car> carTransport = new Truck<>(5);
        carTransport.add(new Car("Toyota"));
        carTransport.add(new Car("Lamborghini"));
        carTransport.add(new Car("Mazda"));
        carTransport.add(new Car("Tesla"));
        carTransport.add(new Car("Chevrolet"));

        printTruck(carTransport);
    }

    public static <T> void printTruck(Truck<T> truck) {
        for (T t : truck) {
            if (t instanceof Animal) {
                System.out.println("Animal name: " + ((Animal) t).getName() + " - type: " + ((Animal) t).getType());
            }

            if (t instanceof Machinery) {
                System.out.println("Machinery type: " + ((Machinery) t).getType());
            }

            if (t instanceof Car) {
                System.out.println("Car brand: " + ((Car) t).getBrand());
            }
        }
    }
}