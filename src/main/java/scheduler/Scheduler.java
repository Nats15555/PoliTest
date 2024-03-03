package scheduler;

//Планировщик выбирает задачи для выполнения из списка задач,
//которые находятся в состоянии ready основываясь на их приоритете.

//Всего существует три уровня приоритета 0-3, где 0 – это наименьший приоритет задачи.

//Задачи с одинаковым уровнем приоритета запускаются в зависимости
//от порядка их активации, при этом расширенные задачи в состоянии
//ожидания не блокируют запуск последующих задач с одинаковым
//приоритетом.

//Выбор задач происходит по алгоритму FIFO, сначала выполняется
//первая (самая старая) задача из списка задач с одинаковым приоритетом.
//Задача, переходящая из состояния ожидания, рассматривается как последняя
//(самая новая) задача в очереди ready. Планировщик имеет ограничение по
//количеству задач, которые могут находиться в состоянии ready.(TODO узнать какое ограничение)

//На рис 3 продемонстрирован пример реализации планировщика,
//используемого для каждого уровня приоритета. Несколько задач различных
//приоритетов находятся в состоянии ready, три задачи с приоритетом 3, одна
//задача с приоритетом 2, одна с приоритетом 1 и две задачи с приоритетом 0.
//Задача, которая прождала больше всего времени, в зависимости от порядка
//запроса, находится в нижней части каждой очереди.

import java.util.Queue;

//После того как TODO процессор(Написать типа процессора мб это вообще не делать) обработал и завершил задачу, планировщик
//выбирает следующую задачу для обработки (приоритет 3, первая очередь).
//Задачи с приоритетом 2 могут быть обработаны только после того, как все
//задачи с более высоким приоритетом перейдут из состояний running и ready

//file:///C:/Users/Hisoka/Desktop/Poli/8sem/%D0%A2%D0%B5%D1%81%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5%20%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%BD%D0%BE%D0%B3%D0%BE%20%D0%BE%D0%B1%D0%B5%D1%81%D0%BF%D0%B5%D1%87%D0%B5%D0%BD%D0%B8%D1%8F/%D0%9B%D0%B0%D0%B1%D0%BE%D1%80%D0%B0%D1%82%D0%BE%D1%80%D0%BD%D0%B0%D1%8F%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0%20(2).pdf

/**
 * Класс планировщика
 */
public class Scheduler {

    //Очередь для 3
    //Очередь для 2
    //Очередь для 1
    //Очередь для 0

    //метод, который будет добавлять задачи в ожидание

    //метод, который будет удалять задачи из ожидания

    //получить номер очереди, которая сейчас обрабатывается

    //TODO ready - Задача завершила свое выполнение. Планировщик решает, какая готовая задача будет выполнена следующей.

    //получить задачу в планировщике
}