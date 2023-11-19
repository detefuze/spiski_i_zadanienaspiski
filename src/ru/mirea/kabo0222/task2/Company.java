package ru.mirea.kabo0222.task2;

public class Company {
    private Node head = null;
    private Node tail = null;
    int size = 0;

    public Company() {
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    // метод добавления элемента, новый элемент становится головой
    public void addElement(Student data) {
        Node a = new Node();
        a.data = data;
        if (this.isEmpty()) {
            this.head = a;
            this.tail = a;
            ++this.size;
        } else if (this.head == this.tail) {
            a.prev = this.head;
            this.head.next = a;
            this.head = a;
            ++size;
        } else {
            this.head.next = a;
            a.prev = this.head;
            this.head = a;
            ++size;
        }
    }

    // удалить голову
    public void deleteFirst() {
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.prev;
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
            for (Node i = this.head; i != null; i = i.prev) {
                if (i.prev == this.tail) {
                    this.tail = i;
                    i.prev = null;
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
            size = 0;
        }
        else if (this.head.data == student.data && this.size > 1) deleteFirst();
        else if (this.tail.data == student.data && this.size > 1) deleteLast();
        else {
            for (Node i = this.head; i.prev != null; i = i.prev)
            {
                if (i.prev.data == student.data)
                {
                    i.prev = i.prev.prev;
                    (i.prev).next = i;
                    --size;
                }
            }
        }
    }

    public void print()
    {
        for (Node i = head; i != null; i = i.prev) {
            System.out.println(i.toString());
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        Company comp = new Company();
        comp.addElement(s1);
        comp.addElement(s2);
        comp.addElement(s3);

        comp.deleteLast();

        comp.print();
    }
}
