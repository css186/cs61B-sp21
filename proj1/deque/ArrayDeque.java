package deque;

public class ArrayDeque<T> {
    // initial capacity of underlying array
    private static final int INIT_CAPACITY = 8;
    private T[] items;
    private int size; // numbers of items in the deque
    private int start; // index of the first item
    private int end; // index of the next empty slot

    public ArrayDeque() {
        items = (T[]) new Object[INIT_CAPACITY];
        size = 0;
        start = 0;
        end = 0;
    }

    /**
     * Check empty
     * @return true if deque is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the number of items inside the deque
     * @return the number of items
     */
    public int size() {
        return size;
    }

    /**
     * Resize the underlying array
     * @param capacity
     *        the new capacity of the array
     */
    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = items[(start + i) % items.length];
        }
        items = copy;
        // update start and end
        start = 0;
        end = size;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        // update start pointer first
        // Note: we need to make sure the index is non-negative
        // and when start = 0, we have to move to the end of the array to addFirst
        // (i - 1 + length) % length is left shift
        start = (start - 1 + items.length) % items.length;
        items[start] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[end] = item;

        // left shift end pointer
        // (i + 1) % length is right shift
        end = (end + 1) % items.length;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T returnItem = items[start];
        // remove item at start
        items[start] = null;
        // right shift start pointer
        start = (start + 1) % items.length;
        size--;

        // shrink the array if necessary
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }

        return returnItem;
    }


    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        // left shift end pointer
        end = (end - 1 + items.length) % items.length;
        T returnItem = items[end];
        items[end] = null;
        size--;

        // shrink the array if necessary
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        return returnItem;
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[(start + i) % items.length] + " -> ");
        }
        System.out.println();
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return items[start];
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        // left shift end pointer
        return items[(end - 1 + items.length) % items.length];
    }

}
