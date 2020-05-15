package com.Alex.math;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Combinations<T> {
    private final static int MAX = 20;
    private final int count;
    private final int takenBy;
    private final Map<Integer, T> map = new HashMap<>();
    private int[] current;
    private final int[] last;

    public Combinations(List<T> elements, int takenBy) {
        this.count = elements.size();
        if (takenBy > count || count > MAX || count <= 0 || takenBy <= 0) {
            throw new IndexOutOfBoundsException("Elements are more than 20 or you try to combine more elements than you have.");
        }
        this.takenBy = takenBy;
        this.last = last();
        fillMap(elements);
    }

    /**
     * Get all combinations of n things taken by k at a time. The k grows from 1 to n.
     * @param elements - list of all elements to combine.
     * @param <P> - type of elements.
     * @return list of combinations. Each combinations is a list of P.
     */
    public static <P> List<List<P>> all(List<P> elements) {
        List<List<P>> list = new ArrayList<>();
        for (int i = 1; i <= elements.size(); i++) {
            Combinations<P> combinations = new Combinations<>(elements, i);
            list.addAll(combinations.get());
        }
        return list;
    }

    /**
     * Get only numbers of all combinations of n things taken by k at a time. The k grows from 1
     * to count.
     * @param count - the count of elements you have.
     * @param takenBy - the count you want to take.
     * @return list of combinations, only numbers.
     */
    public static List<List<Integer>> only(int count, int takenBy) {
        List<Integer> defaultElements = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            defaultElements.add(i + 1);
        }
        return new Combinations<>(defaultElements, takenBy).get();
    }

    /**
     * Get combinations from your elements taken by K.
     * @return - list of combinations.
     */
    public List<List<T>> get() {
        current = current();
        List<List<T>> list = new ArrayList<>();
        list.add(getValuesOfCurrentCombination());
        while (!Arrays.equals(current, last)) {
            next(current);
            list.add(getValuesOfCurrentCombination());
        }
        return list;
    }

    /**
     * Get count of possible combinations of your elements taken by K.
     * Method calculates Pascal's Triangle for no more 20 elements.
     * @return - count of combinations.
     */
    public int count() {
        int[] firstLine = new int[MAX];
        int[] secondLine = new int[MAX];
        firstLine[0] = 1;
        firstLine[1] = 1;
        for (int i = 1; i < count; i++) {
            secondLine[0] = 1;
            secondLine[1] = 1;
            for (int j = 1; j <= takenBy; j++) {
                secondLine[j] = firstLine[j] + firstLine[j - 1];
            }
            firstLine = Arrays.copyOf(secondLine, secondLine.length);
        }
        return firstLine[takenBy];
    }

    private void fillMap(List<T> elements) {
        int i = 0;
        for (T element : elements) {
            this.map.put(i, element);
            i++;
        }
    }

    private int[] current() {
        int[] current = new int[takenBy];
        for (int i = 0; i < current.length; i++) {
            current[i] = i + 1;
        }
        return current;
    }

    private int[] last() {
        int[] last = new int[takenBy];
        for (int i = 0; i < last.length; i++) {
            last[i] = count - takenBy + i + 1;
        }
        return last;
    }

    private void next(int[] current) {
        int i = takenBy - 1;
        while (current[i] + takenBy - i > count) {
            i--;
        }
        current[i]++;
        for (int j = i + 1; j < takenBy; j++) {
            current[j] = current[j - 1] + 1;
        }
    }

    @NotNull
    private List<T> getValuesOfCurrentCombination() {
        List<T> tempList = new ArrayList<>();
        for (int i : current) {
            tempList.add(map.get(i - 1));
        }
        return tempList;
    }

    public static void main(String[] args) {
        Combinations<String> combinations = new Combinations<>(
                Arrays.asList("1a", "2b", "3c", "4d")
                , 2);
        System.out.println(combinations.count());
        System.out.println(combinations.get());
        System.out.println(Combinations.only(7, 5));
        System.out.println(Combinations.all(Arrays.asList("1a", "2b", "3c", "4d")));
    }

}
