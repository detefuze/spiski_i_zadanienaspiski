package ru.mirea.kabo0222.task2;

import java.util.Scanner;

public class Student {
    private final String name;
    private final int age;

    public Student() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Имя:");
        this.name = sc.nextLine();
        System.out.println("Возраст:");
        this.age = sc.nextInt();
    }

    public String toString() {
        return "Student{name='" + this.name + "', age=" + this.age + "}";
    }
}
