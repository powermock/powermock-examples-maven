package org.powermock.example;

/**
 *
 */
public class SomeClass {
    public int add(int x, int y) {
        if (Configuration.isEnabled()) {
            return x + y;
        }
        return 0;
    }
}
