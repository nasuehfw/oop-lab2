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
 * Клас, що описує сутність "Товар".
 * Забезпечує інкапсуляцію даних та безпечну валідацію вартості.
 * 
 * @author Анастасія Горбунова
 * @version 2.0 09 Oct 2026
 */
public class Item {
    /** Найменування товару */
    private final String name;
    /** Поточна ціна товару */
    private float price;

    /**
     * Конструктор для ініціалізації товару.
     * 
     * @param name найменування товару
     * @param initialPrice початкова вартість
     */
    public Item(String name, float initialPrice) {
        this.name = name;
        setPrice(initialPrice); /* Виклик валідатора для запобігання негативній ціні */
    }

    /**
     * Публічний метод для підвищення ціни на певний відсоток.
     * 
     * @param percent відсоток підвищення (значення типу float)
     */
    public void raisePrice(float percent) {
        if (percent > 0) {
            this.price += this.price * (percent / 100.0f);
        }
    }

    /**
     * Публічний метод для зниження ціни на певний відсоток.
     * Автоматично скидає ціну до 0, якщо зниження перевищує 100%.
     * 
     * @param percent відсоток зниження (значення типу float)
     */
    public void cutPrice(float percent) {
        if (percent > 0) {
            this.price -= this.price * (percent / 100.0f);
            validatePrice();
        }
    }

    /**
     * Приватний метод-валідатор для контролю негативних значень ціни.
     */
    private void validatePrice() {
        if (this.price < 0.0f) {
            this.price = 0.0f; /* Примусове встановлення в нуль згідно умов завдання */
        }
    }

    // --- Сеттери та Геттери згідно з конвенцією безпеки ---
    
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
        validatePrice();
    }
}
