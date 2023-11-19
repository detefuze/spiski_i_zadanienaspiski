package ru.mirea.kabo0222.task3naspiski;

public class Node {
    Node next;
    Node prev;
    int data;

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
