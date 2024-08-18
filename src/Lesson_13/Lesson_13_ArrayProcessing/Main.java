package Lesson_13.Lesson_13_ArrayProcessing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("white");
        arrayList.add("black");
        arrayList.add("red");
        arrayList.add("yellow");
        arrayList.add("green");
        arrayList.add("blue");
        arrayList.add("purple");
        arrayList.add("pink");
        arrayList.add("white");
        arrayList.add("black");
        HashSet<String> uniqueWords = new HashSet<>(arrayList);
        System.out.println(uniqueWords);
        LinkedHashMap<String, Integer> wordCounter = new LinkedHashMap<>();
        for (String word : arrayList) {
            if (wordCounter.containsKey(word)) {
                wordCounter.put(word, wordCounter.get(word) + 1);
            } else {
                wordCounter.put(word, 1);
            }
        }
        System.out.println(wordCounter);
    }
}