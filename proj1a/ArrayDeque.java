public class ArrayDeque<T> {

    private int size;
    private int head;
    private int nextFirst;
    private T[] items;
    private int nextLast;
    private int tail;


    /** Create an empty ArrayDeque */
    public ArrayDeque() {
        size = 0;
        head = 4;
        nextFirst = 4;
        items = (T[]) new Object[8];
        nextLast = 5;
        tail = 4;
    }

    /** Create a deep copy of an ArrayDeque */
    public ArrayDeque(ArrayDeque<T> other) {
        size = other.size;
        head = other.head;
        nextFirst = other.nextFirst;
        T[] newItems = (T[]) new Object[other.items.length];
        System.arraycopy(other.items, 0, newItems, 0, other.items.length);
        items = newItems;
        nextLast = other.nextLast;
        tail = other.tail;
    }

    /** Insert an item to the head of an ArrayDeque */
    public void addFirst(T item) {
        if (size < items.length) {
            items[nextFirst] = item;
            head = nextFirst;
            size += 1;
            if (size == 1) {
                tail = head;
            }
            if (nextFirst != 0) {
                nextFirst -= 1;
            } else {
                nextFirst = items.length - 1;
            }
        } else {
            T[] newItems = (T[]) new Object[items.length * 2];
            System.arraycopy(items, head, newItems, items.length, items.length - head);
            System.arraycopy(items, 0, newItems, items.length + items.length - head, head);
            items = newItems;
            head = items.length / 2;
            nextFirst = items.length / 2 - 1;
            nextLast = 0;
            tail = items.length - 1;

            items[nextFirst] = item;
            head = nextFirst;
            size += 1;
            nextFirst -= 1;
        }
    }

    /** Insert an item to the tail of an ArrayDeque */
    public void addLast(T item) {
        if (size < items.length) {
            items[nextLast] = item;
            tail = nextLast;
            size += 1;
            if (size == 1) {
                head = tail;
            }
            if (nextLast != items.length - 1) {
                nextLast += 1;
            } else {
                nextLast = 0;
            }
        } else {
            T[] newItems = (T[]) new Object[items.length * 2];
            System.arraycopy(items, head, newItems, items.length, items.length - head);
            System.arraycopy(items, 0, newItems, items.length + items.length - head, head);
            items = newItems;
            head = items.length / 2;
            nextFirst = items.length / 2 - 1;
            nextLast = 0;
            tail = items.length - 1;

            items[nextLast] = item;
            tail = nextLast;
            size += 1;
            nextLast += 1;
        }
    }

    /** Delete an item from the head of an ArrayDeque */
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else if (size >= items.length / 2 || size <= 9) {
            T value = items[head];
            nextFirst = head;
            size -= 1;
            if (head != items.length - 1) {
                head += 1;
            } else {
                head = 0;
            }
            return value;
        } else {
            T value = items[head];
            nextFirst = head;
            size -= 1;
            if (head != items.length - 1) {
                head += 1;
            } else {
                head = 0;
            }

            T[] newItems = (T[]) new Object[items.length / 2];
            System.arraycopy(items, head, newItems, 0, items.length - head);
            if (head > tail) {
                System.arraycopy(items, 0, newItems, items.length - head, tail);
            }

            items = newItems;
            head = 0;
            nextFirst = items.length - 1;
            nextLast = size;
            tail = size - 1;
            return value;
        }
    }

    /** Delete an item from the tail of an ArrayDeque */
    public T removeLast() {
        if (size == 0) {
            return null;
        } else if (size >= items.length / 2 || size <= 9) {
            T value = items[tail];
            nextLast = tail;
            size -= 1;
            if (tail != 0) {
                tail -= 1;
            } else {
                tail = items.length - 1;
            }
            return value;
        } else {
            T value = items[tail];
            nextLast = tail;
            size -= 1;
            if (tail != 0) {
                tail -= 1;
            } else {
                tail = items.length - 1;
            }

            T[] newItems = (T[]) new Object[items.length / 2];
            System.arraycopy(items, head, newItems, 0, items.length - head);
            if (head > tail) {
                System.arraycopy(items, 0, newItems, items.length - head, tail);
            }

            items = newItems;
            head = 0;
            nextFirst = items.length - 1;
            nextLast = size;
            tail = size - 1;
            return value;
        }
    }

    /** Retrieve the i-th item in an ArrayDeque */
    public T get(int i) {
        if (i >= size) {
            return null;
        } else {
            if (head <= tail) {
                if (i <= tail - head) {
                    return items[head + i];
                }
            } else {
                if (head + i <= items.length) {
                    return items[head + i];
                } else {
                    return items[head + i - items.length];
                }
            }
        }
        return null;
    }


    /** Print out all items in an ArrayDeque */
    public void printDeque() {
        if (size == 0) {
            System.out.println(" ");
        } else if (head <= tail) {
            for (int i = head; i <= tail; i += 1) {
                System.out.print(items[i] + " ");
            }
        } else {  // i.e. head > tail
            for (int i = head; i < items.length; i += 1) {
                System.out.print(items[i] + " ");
            }
            for (int i = 0; i <= tail; i += 1) {
                System.out.print(items[i] + " ");
            }
        }
        System.out.println();
//        System.out.println(" ---> Size = " + size);
    }

    /** Check if an ArrayDeque is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Return the size of an ArrayDeque */
    public int size() {
        return size;
    }
}