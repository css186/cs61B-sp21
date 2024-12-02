package deque;

public class LinkedListDeque<T> {
    
    private static class Node<T> {
        private T item;
        private Node<T> prev;
        private Node<T> next;

        /* Constructors */
        public Node(T i) {
            item = i;
            prev = null;
            next = null;
        }

        public Node(T i, Node<T> p, Node<T> n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node<T> sentinel;
    private int size;

    /* Constructors */
    public LinkedListDeque() {
        // with one sentinel node
        sentinel = new Node<T>(null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** Adds an item of type T to the front of the deque */
    public void addFirst(T item) {
        Node<T> newNode = new Node<T>(item);

        // add connection with newNode and firstNode
        sentinel.next.prev = newNode;
        newNode.next = sentinel.next;

        // add connection with sentinel and newNode
        newNode.prev = sentinel;
        sentinel.next = newNode;

        size++;
    }

    /** Adds an item of type T at the end of the deque */
    public void addLast(T item) {
        Node<T> newNode = new Node<T>(item);

        // add connection with newNode and lastNode
        sentinel.prev.next = newNode;
        newNode.prev = sentinel.prev;

        // add connection with sentinel and newNode
        newNode.next = sentinel;
        sentinel.prev = newNode;
        
        size++;
    }

    /** Returns true if deque is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of items in the deque */ 
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space. 
     * Once all the items have been printed, print out a new line. 
    */
    public void printDeque() {
        Node<T> p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque. If no such item exists, returns null */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T returnItem = sentinel.next.item;

        // remove connection with sentinel and firstNode
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return returnItem;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null */
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

    public T get(int index) {
        if (index <0 || index >= size) {
            return null;
        }
        Node<T> p = sentinel.next;

        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }

    private T getRecursiveHelper(int index, Node<T> p) {
        if (index == 0) {
            return p.item;
        }
        return getRecursiveHelper(index - 1, p.next);
    }



}
