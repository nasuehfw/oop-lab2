/*
 * Copyright (c) 2026. Anastasiia Gorbunova
 * National University "Odesa Polytechnic"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://apache.org
 */
package ad251.gorbunova;

/**
 * Реалізація кошика на базі структури даних LIFO (Стек) за допомогою масиву.
 */
public class StackCart implements Cart {
    /** Масив об'єктів для зберігання елементів стека */
    private final Item[] stack;
    /** Індекс вершини стека */
    private int topIndex;

    /**
     * Конструктор кошика-стека.
     * 
     * @param capacity максимальний розмір стека
     */
    public StackCart(int capacity) {
        this.stack = new Item[capacity];
        this.topIndex = -1; /* Стек порожній */
    }

    @Override
    public boolean addItem(Item item) {
        // Перевірка на переповнення стека
        if (topIndex >= stack.length - 1) {
            System.out.print("[ПОМИЛКА] Кошик-стек переповнений! Не вдалося додати: " + item.getName() + "\n");
            return false;
        }
        stack[++topIndex] = item;
        return true;
    }

    @Override
    public Item deleteItem() {
        // Перевірка на спробу видалити елемент із порожнього стека
        if (topIndex < 0) {
            System.out.print("[ПОМИЛКА] Спроба видалити елемент із порожнього кошика!\n");
            return null;
        }
        Item removedItem = stack[topIndex];
        stack[topIndex--] = null; /* Очищення посилання для роботи Garbage Collector */
        return removedItem;
    }

    @Override
    public double calculateTotalSum() {
        double sum = 0.0;
        for (int i = 0; i <= topIndex; i++) {
            sum += stack[i].getPrice();
        }
        return sum;
    }

    @Override
    public void raiseAllPrices(float percent) {
        for (int i = 0; i <= topIndex; i++) {
            stack[i].raisePrice(percent); /* Відправка повідомлення об'єкту Item */
        }
    }

    @Override
    public void cutAllPrices(float percent) {
        for (int i = 0; i <= topIndex; i++) {
            stack[i].cutPrice(percent);
        }
    }
}
