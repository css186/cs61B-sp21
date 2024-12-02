package DLList;

public class DLList<T> {

    private static class ListNode<T> {
        T item;
        ListNode<T> prev;
        ListNode<T> next;

        ListNode(T i) {
            item = i;
            prev = null;
            next = null;
        }
    }

    ListNode<T> sentinel;
    private int size;

    /**
     * Constructor
     */
    public DLList() {
        sentinel = new ListNode<>(null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        ListNode<T> newNode = new ListNode<>(item);
        sentinel.next.prev = newNode;
        newNode.next = sentinel.next;

        newNode.prev = sentinel;
        sentinel.next = newNode;
        size++;
    }

    public void addLast(T item) {
        ListNode<T> newNode = new ListNode<>(item);
        sentinel.prev.next = newNode;
        newNode.prev = sentinel.prev;

        newNode.next = sentinel;
        sentinel.prev = newNode;
        size++;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T returnItem = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return returnItem;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T returnItem = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return returnItem;
    }

    public T getLast() {
        if (size == 0) {
            return null;
        }
        return sentinel.prev.item;
    }

    public T getFrist() {
        if (size == 0) {
            return null;
        }
        return sentinel.next.item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        ListNode<T> curr = sentinel.next;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.item;
    }

    public void print() {
        for (ListNode<T> p = sentinel.next; p != null; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }
}
