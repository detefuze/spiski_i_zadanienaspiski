package ru.mirea.kabo0222.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// класс, реализующий идею односвязного списка
public class Company {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public Company() {
    }

    // метод получения размера списка
    public int getSize() {
        return this.size;
    }

    // метод добавления элемента, новый элемент становится головой
    public void addElement(Student data) {
        Node a = new Node();
        a.data = data;
        if (this.isEmpty()) {
            this.head = a;
            this.tail = a;
            ++this.size;
        } else {
            a.next = this.head;
            this.head = a;
            ++this.size;
        }

    }

    // удалить первый элемент(голову)
    public void deleteFirst() {
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            --this.size;
        }
    }

    // удалить хвост
    public void deleteLast() {
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
            this.size = 0;
        } else {
            for (Node i = this.head; i != null; i = i.next) {
                if (i.next == this.tail) {
                    this.tail = i;
                    i.next = null;
                    --this.size;
                }
            }
        }
    }

    // удалить любой элемент списка
    public void deleteElement(Node student) {
        if (this.head == this.tail && this.head.data == student.data) {
            this.head = null;
            this.tail = null;
        }
        else if (this.head.data == student.data && this.size > 1) deleteFirst();
        else if (this.tail.data == student.data && this.size > 1) deleteLast();
        else {
                for (Node i = this.head; i.next != null; i = i.next)
                {
                    if (i.next.data == student.data)
                    {
                        i.next = i.next.next;
                    }
                }
        }
    }

    // напечатать элемент
    public void printElement(Student data) {
        for (Node i = this.head; i != null; i = i.next) {
            if (i.data == data) {
                System.out.println(i.data);
                i = this.tail;
            }
        }

    }

    // очистить список
    public void clear() {
        this.head = null;
        this.tail = null;
    }

    // проверка на пустоту
    public boolean isEmpty() {
        return this.head == null;
    }

    public static void writeFile(Company company) throws FileNotFoundException {
        File file = new File("textfile");
        PrintWriter pw = new PrintWriter(file);

        for (Node i = company.head; i != null; i = i.next) {
            pw.println(i.toString());
        }

        pw.close();
    }

    public void readFile() throws FileNotFoundException {
        File file = new File("textfile");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

        sc.close();
    }

    public void print()
    {
        for (Node i = head; i != null; i = i.next) {
            System.out.println(i.toString());
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        Company comp = new Company();
        comp.addElement(s1);
        comp.addElement(s2);
        comp.addElement(s3);
        Node node = new Node();
        node.data = s2;
        comp.deleteElement(node);

        comp.print();
    }
}