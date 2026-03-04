package org.isaacbcdev.oppinterface.model;

public class PremiumClient extends Client implements Comparable {

    public PremiumClient(String name, String lastname) {
        super(name, lastname);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}