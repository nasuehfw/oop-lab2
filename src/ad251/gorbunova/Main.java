/*
 * Copyright (c) 2026 Anastasiia Gorbunova
 * National University "Odesa Polytechnic"
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://apache.org
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ad251.gorbunova;

/**
 * Головний керуючий клас програми (Точка входу).
 * Координує створення об'єктів-компонентів та демонстрацію виконання завдань
 * лабораторної роботи №2.*.
 * 
 * @author Анастасія Горбунова
 * @version 1.0 09 Oct 2026
 */
public class Main {

    public static void main(String[] args) {
        System.out.print("=== Лабораторна робота №2 ===\n\n");
        System.out.print("Тема: Основи роботи з класами та об'єктами.\n");
        System.out.print("Інкапсуляція. \n");                       
        System.out.print("Модифікатори доступу.\n\n");                     

        // --- 1. Традиційне виконання на базі Стека (LIFO) ---
        System.out.print("--- Тестування Кошика на базі СТЕКА (LIFO) ---\n");
        Cart stackCart = new StackCart(8); /* Створення через інтерферс контракт */

        // Заповнення 5-6 об'єктами
        stackCart.addItem(new Item("Ноутбук", 25000.0f));
        stackCart.addItem(new Item("Мишка", 600.0f));
        stackCart.addItem(new Item("Клавіатура", 1500.0f));
        stackCart.addItem(new Item("Монітор", 7000.0f));
        stackCart.addItem(new Item("Навушники", 2200.0f));

        System.out.printf("Початкова сума товарів у стеку: %.2f грн\n", stackCart.calculateTotalSum());

        // Підняття цін на 15%
        stackCart.raiseAllPrices(15.0f);
        System.out.printf("Сума після підвищення цін на 15%%: %.2f грн\n", stackCart.calculateTotalSum());

        // Зниження цін на 30%
        stackCart.cutAllPrices(30.0f);
        System.out.printf("Сума після зниження цін на 30%%: %.2f грн\n\n", stackCart.calculateTotalSum());


        // --- 2. Пункт 4: Зміна внутрішньої структури на Чергу (FIFO) ---
        System.out.print("--- Тестування Кошика на базі ЧЕРГИ (FIFO) ---\n");
        Cart queueCart = new QueueCart(8); /* Інтерфейс ТОЙ САМИЙ, логіка інша */

        queueCart.addItem(new Item("Ноутбук", 25000.0f));
        queueCart.addItem(new Item("Мишка", 600.0f));
        queueCart.addItem(new Item("Клавіатура", 1500.0f));

        System.out.printf("Початкова сума у черзі: %.2f грн\n", queueCart.calculateTotalSum());
        queueCart.raiseAllPrices(15.0f);
        System.out.printf("Сума у черзі після підвищення на 15%%: %.2f грн\n\n", queueCart.calculateTotalSum());


        // --- 3. ЗАДАННЯ з файлу lab2-2.docx: Варіант №7 (Облік товарів на складі) ---
        System.out.print("--- Індивідуальне завдання (Варіант №7) ---\n");
        WarehouseManager.analyzeWarehouse(10); /* Передаємо мінімальний ліміт 10 одиниць */
 
    }
    
}
