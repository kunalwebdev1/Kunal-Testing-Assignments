package com.Task62.Features;
import java.util.HashMap;

public class DuplicateCharacters {
    public static void main(String[] args) {

        String str = "programming";

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        System.out.println("Duplicate Characters:");

        for (char ch : map.keySet()) {
            if (map.get(ch) > 1) {
                System.out.println(ch + " = " + map.get(ch));
            }
        }
    }
}