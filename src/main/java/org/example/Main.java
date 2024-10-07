/*
Упражнение: "Управление библиотекой книг"
Описание задачи:
Требуется разработать консольное Java-приложение для управления коллекцией книг
в библиотеке. Каждая книга имеет следующие поля:

id (идентификатор книги, автоинкремент)
title (название книги)
author (автор книги)
year (год издания)
Программа должна выполнять следующие функции:

Добавление новой книги в базу данных.
Просмотр списка всех книг с выводом их деталей.
Обновление данных о книге по её id.
Удаление книги из базы данных по её id.

Шаги для выполнения:
Создание базы данных и таблицы:
Создайте базу данных в любом СУБД (например, MySQL или PostgreSQL).
Создайте таблицу books со следующей структурой:*/
//-------------------------------------------------------------

package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Add add_book = new Add();
        Delete delete_book = new Delete();
        ReadDescription descr_of_book = new ReadDescription();
        String exit;
        String[] del = new String[1];
        String[] add = new String[3];
        String[] description = new String[1];
        String input;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Что вы хотите сделать?");
            System.out.println("(добавить/удалить/читать/выход)");
            input = scanner.nextLine();
            switch (input){
                case "добавить":
                    Scanner a = new Scanner(System.in);
                    System.out.println("Введите название автора и год_издания ");
                    add = a.nextLine().split(" ");
                    add_book.main(add);
                    break;
                case "удалить":
                    Scanner b = new Scanner(System.in);
                    System.out.println("Введите айди книги: ");
                    del[0] = b.nextLine();
                    delete_book.main(del);
                    break;
                case "читать":
                    Scanner c = new Scanner(System.in);
                    System.out.println("Введите айди книги: ");
                    description[0] = c.nextLine();
                    descr_of_book.main(description);
                    break;
            }
        } while (!input.equals("выход"));
    }
}