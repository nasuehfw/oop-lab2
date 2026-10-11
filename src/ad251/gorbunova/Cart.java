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
 * Інтерфейс кошика товарів. Визначає загальнодоступний контракт (API)
 * для будь-якої внутрішньої структури даних зберігання.
 */
public interface Cart {
    /** Додавання товару до кошика */
    boolean addItem(Item item);
    
    /** Видалення останнього доданого товару з кошика */
    Item deleteItem();
    
    /** Підрахунок суми цін усіх товарів у кошику */
    double calculateTotalSum();
    
    /** Підвищення ціни всіх товарів у кошику на відсоток */
    void raiseAllPrices(float percent);
    
    /** Зниження ціни всіх товарів у кошику на відсоток */
    void cutAllPrices(float percent);
}

