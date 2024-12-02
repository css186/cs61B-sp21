package AList;

public class AList<T> {

    private T[] items;
    private int size;
    private static final int REFACTOR = 2;

    public AList() {
        items = (T[]) new Object[10];
        size = 0;
    }

    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    public void addLast(T x) {
        if (size == items.length) {
            resize(size * REFACTOR);
        }

        items[size] = x;
        size++;
    }

    public T getLast() {
        return items[size - 1];
    }

    public T get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    public T removeLast() {
        T returnItem = getLast();
        items[size - 1] = null; // if storing object, we have to do this to avoid loitering
        size--;
        return returnItem;
    }
}
