package org.isaacbcdev.generics;

import org.isaacbcdev.oppinterface.model.Client;
import org.isaacbcdev.oppinterface.model.PremiumClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericExample {
    public static void main(String[] args) {

        List<Client> clients = new ArrayList<>();

        clients.add(new Client("John", "Doe"));

        Client john = clients.getFirst();

        Client[] clientsArray = {new Client("John", "Doe"), new Client("Mark", "Carl")};
        Integer[] integers = {1, 2, 3};

        List<Client> clientList = fromArrayToList(clientsArray);
        List<Integer> integerList = fromArrayToList(integers);

        clientList.forEach(System.out::println);
        integerList.forEach(System.out::println);

        List<String> names = fromArrayToList(new String[]{"John", "Luke", "Mark", "Jane"}, integers);

        names.forEach(System.out::println);

        List<PremiumClient> premiumClients = fromArrayToList(new PremiumClient[]{new PremiumClient("Luke", "Stark")
                , new PremiumClient("Rob", "Williams")});

        premiumClients.forEach(System.out::println);

        printClient(clients);
        printClient(clientList);
        printClient(premiumClients);

        System.out.println("Maximum number of 1, 7, 8 is: " + maximum(1, 7, 8));
        System.out.println("Maximum number of 12.5, 7.1, 8.9 is: " + maximum(12.5, 7.1, 8.9));
        System.out.println("Maximum number of carrots, blueberries and apples is: " + maximum("carrots", "blueberries", "apples"));
    }

    public static <T> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T extends Client> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T extends Number> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T, G> List<T> fromArrayToList(T[] c, G[] g) {
        for (G element : g) {
            System.out.println(element);
        }
        return Arrays.asList(c);
    }

    public static void printClient(List<? extends Client> clients) {
        clients.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximum(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }

        return max;
    }
}