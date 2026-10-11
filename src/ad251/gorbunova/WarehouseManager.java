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
 * Клас для виконання індивідуального завдання №7 "Облік товарів на складі".
 * Оперує структурами масивів для аналізу залишків та пошуку дефіцитних позицій.
 * 
 * @author Анастасія Горбунова
 * @version 2.0 09 Oct 2026
 */
public class WarehouseManager {

    /**
     * Запускає повний аналіз складських залишків.
     * Визначає загальну кількість, лідера за обсягом та дефіцитні товари.
     * 
     * @param minLimit мінімально допустима кількість одиниць товару на складі
     */
    public static void analyzeWarehouse(int minLimit) {
        String[] itemNames = {"Процесор", "Материнська плата", "ОЗП", "SSD Диск", "Блок живлення"};
        int[] itemQuantities = {15, 8, 42, 24, 5}; /* Паралельний масив кількості одиниць */
        
        int maxIndex = 0;			/* Індекс товару з максимальною кількістю */
        int totalItems = 0;			/* Загальна сума всіх одиниць на складі */

        System.out.print("Всі товари на складі:\n");
        for (int i = 0; i < itemNames.length; i++) {
            System.out.printf("  - %-20s: %d од.\n", itemNames[i], itemQuantities[i]);
            totalItems += itemQuantities[i];
            
            // Пошук індексу максимального елемента масиву
            if (itemQuantities[i] > itemQuantities[maxIndex]) {
                maxIndex = i;
            }
        }

        System.out.print("\nРезультати аналізу складу за Варіантом №7:\n");
        System.out.printf("  1) Загальна кількість товарів на складі: %d од.\n", totalItems);
        System.out.printf("  2) Товар із найбільшою кількістю: %s (%d од.)\n", itemNames[maxIndex], itemQuantities[maxIndex]);
        
        /* Перевірка умовних критеріїв для пошуку дефіцитних позицій */
        System.out.printf("  3) Товари, кількості яких менше за ліміт (%d од.):\n", minLimit);
        for (int i = 0; i < itemNames.length; i++) {
            if (itemQuantities[i] < minLimit) {
                System.out.printf("     * %s (залишилось лише %d од.)\n", itemNames[i], itemQuantities[i]);
            }
        }
    }
}
