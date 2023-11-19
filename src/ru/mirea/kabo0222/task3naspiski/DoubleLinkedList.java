package ru.mirea.kabo0222.task3naspiski;

public class DoubleLinkedList {
    private Node head = null;
    private Node tail = null;
    int size = 0;

    public DoubleLinkedList() {
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    // метод добавления элемента, новый элемент становится головой
    public void addElement(int data) {
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
        for (Node i = tail; i != null; i = i.next) {
            System.out.println(i.data);
        }
    }

    //{5, 1, 6}

    public void insertionSort()
    {
        for (Node i = tail.next; i != null; i = i.next)
        {
            Node previous = i.prev; // предыдущий элемент
            Node following = i.next; // следующий элемент
            while (previous.data > i.data) // пока предыдущий больше текущего
            {
                if (previous == tail)
                {
                    i.prev = null;
                    i.next = previous;
                    previous.prev = i;
                    previous.next = following;
                    following.prev = previous;
                    tail = i;
                    break;
                }
                else if (i == head)
                {
                    Node pre_previous = previous.prev; // элемент после предыдущего
                    i.prev = pre_previous;
                    i.next = previous;
                    pre_previous.next = i;
                    previous.prev = i;
                    previous.next = null;
                    head = previous;
                }
                else
                {
                    Node pre_previous = previous.prev; // элемент после предыдущего
                    i.prev = pre_previous;
                    i.next = previous;
                    pre_previous.next = i;
                    previous.prev = i;
                    previous.next = following;
                    following.prev = previous;
                }
                previous = i.prev;
                following = i.next;
            }
        }
        this.print();
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.addElement(5);
        list.addElement(1);
        list.addElement(7);
        list.addElement(1);
        list.addElement(3);

        list.insertionSort();
    }
}