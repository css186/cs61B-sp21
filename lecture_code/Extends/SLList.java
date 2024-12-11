package Extends;

public class SLList<T> {

    private static class Node<T> {
        private T item;
        private Node<T> next;

        private Node(T i, Node<T> n) {
            item = i;
            next = n;
        }

    }
    /* The first node will be at sentinel.next */
    private Node<T> sentinel;
    // private IntNode first;
    private int size;

    /**
     * Creates an empty SLList.
     */
    public SLList() {
        // first = null;
        sentinel = new Node<T>(null, null);
        size = 0;
    }

    public SLList(T x) {
        sentinel = new Node<T>(null, null);
        sentinel.next = new Node<T>(x, null);
        // first = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(T x) {
        // first = new IntNode(x, first);
        sentinel.next = new Node<T>(x, sentinel.next);
        size += 1;
    }

    public T getFirst() {
        // return first.item;
        return sentinel.next.item;
    }

    public void addLast(T x) {

        // if (first == null) {
        //     first = new IntNode(x, null);
        //     size += 1;
        //     return;
        // }

        // IntNode p = first;
        Node<T> p = sentinel;
        /* Move p until it reaches the end of the list */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node<T>(x, null);
        size += 1;
    }

    public T removeLast() {
        Node<T> p = sentinel;
        while (p.next.next != null) {
            p = p.next;
        }
        T returnItem = p.next.item;
        p.next = null;
        return returnItem;
    }

    public void print() {
        Node<T> p = sentinel.next;
        while (p != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }
}