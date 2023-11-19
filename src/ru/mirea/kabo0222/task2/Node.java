package ru.mirea.kabo0222.task2;

public class Node {
    Node next;
    Node prev;
    Student data;

    public Node() {
    }

    public String toString() {
        return this.data.toString();
    }
}
