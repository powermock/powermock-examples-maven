package org.powermock.example;

import java.util.List;
import java.util.function.Consumer;

public class Lamda {

    public static String capitalize(String in) {
        String result = "";
        String[] a = in.split(",");
        for (String s : a) {
            result += s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
        }
        return result;
    }

    public void validate(List<String> in) {
        doWithList(in, s -> {
            if (s != null && s.length() > 10) {
                throw new RuntimeException("");
            }
        });
    }

    private void doWithList(List<String> in, Consumer<String> consumer) {
        in.stream().map(Lamda::capitalize).forEach(consumer);
    }

}
