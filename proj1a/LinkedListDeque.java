public class LinkedListDeque<T> {

    private class Node {
        private T item;
        private Node next;
        private Node prev;

        /** Default constructor of a Node */
        private Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }

        /** Create an empty Node */
        /*
        private Node() {
            item = null;
            next = null;
            prev = null;
        }
        */
    }

    private Node sentinel;
    private int size;

    /** Create an empty LinkedListDeque */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Create a LinkedListDeque with one item */
    public LinkedListDeque(T item) {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

        Node n = new Node(item, sentinel, sentinel);
        sentinel.next = n;
        sentinel.prev = n;
        size = 1;
    }

    /** Create a deep copy of a LinkedListDeque */
    public LinkedListDeque(LinkedListDeque<T> other) {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i += 1) {
            addLast(other.get(i));
        }
    }

    /** Insert an item to the head of a LinkedListDeque */
    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    /** Insert an item to the tail of a LinkedListDeque */
    public void addLast(T item) {
        sentinel.prev = new Node(item, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    /** Delete an item from the head of a LinkedListDeque */
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T value = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev.next = null;
        sentinel.next.prev.prev = null;
        sentinel.next.prev = sentinel;
        size -= 1;
        return value;
    }

    /** Delete an item from the tail of a LinkedListDeque */
    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        }
        T value = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next.prev = null;
        sentinel.prev.next.next = null;
        sentinel.prev.next = sentinel;
        size -= 1;
        return value;
    }

    /** Retrieve the i-th item in a LinkedListDeque, using iteration */
    public T get(int i) {
        if (size == 0) {
            return null;
        }
        if (i > size - 1) {
            return null;
        }
        int j = -1;
        Node node = sentinel;
        while (j < i) {
            node = node.next;
            j += 1;
        }
        return node.item;
    }

    /** Retrieve the i-th item in a LinkedListDeque, using recursion */
    public T getRecursive(int i) {
        if (size == 0) {
            return null;
        }
        if (i > size - 1) {
            return null;
        }
        Node tmpNode = sentinel;
        return getRecursiveHelper(i, tmpNode);
    }

    public T getRecursiveHelper(int i, Node n) {
        if (i == 0) {
            return n.next.item;
        }
        return getRecursiveHelper(i - 1, n.next);
    }

    /** Print out all items in a LinkedListDeque */
    public void printDeque() {
        Node tempNode = sentinel.next;
        while (tempNode != sentinel) {
            System.out.print(tempNode.item + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    /** Check if a LinkedListDeque is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Return the size of a LinkedListDeque */
    public int size() {
        return size;
    }
}