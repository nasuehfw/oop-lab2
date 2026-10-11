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
 * Реалізація кошика на базі структури даних FIFO (Черга) за допомогою масиву.
 * Демонструє незмінність інтерфейсу при повній зміні внутрішньої логіки.
 */
public class QueueCart implements Cart {
    private final Item[] queue;
    private int head;
    private int tail;
    private int size;

    public QueueCart(int capacity) {
        this.queue = new Item[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    @Override
    public boolean addItem(Item item) {
        if (size == queue.length) {
            System.out.print("[ПОМИЛКА] Кошик-черга переповнений!\n");
            return false;
        }
        queue[tail] = item;
        tail = (tail + 1) % queue.length; /* Кільцевий буфер */
        size++;
        return true;
    }

    @Override
    public Item deleteItem() {
        if (size == 0) {
            System.out.print("[ПОМИЛКА] Кошик-черга порожній!\n");
            return null;
        }
        Item removedItem = queue[head];
        queue[head] = null;
        head = (head + 1) % queue.length;
        size--;
        return removedItem;
    }

    @Override
    public double calculateTotalSum() {
        double sum = 0.0;
        int current = head;
        for (int i = 0; i < size; i++) {
            sum += queue[current].getPrice();
            current = (current + 1) % queue.length;
        }
        return sum;
    }

    @Override
    public void raiseAllPrices(float percent) {
        int current = head;
        for (int i = 0; i < size; i++) {
            queue[current].raisePrice(percent);
            current = (current + 1) % queue.length;
        }
    }

    @Override
    public void cutAllPrices(float percent) {
        int current = head;
        for (int i = 0; i < size; i++) {
            queue[current].cutPrice(percent);
            current = (current + 1) % queue.length;
        }
    }
}

