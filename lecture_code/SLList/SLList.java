
public class SLList {

    private static class IntNode {
        private int item;
        private IntNode next;

        private IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }

    }
    /* The first node will be at sentinel.next */
    private IntNode sentinel;
    // private IntNode first;
    private int size;

    /**
     * Creates an empty SLList.
     */
    public SLList() {
        // first = null;
        sentinel = new IntNode(-100, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(-100, null);
        sentinel.next = new IntNode(x, null);
        // first = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        // first = new IntNode(x, first);
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public int getFirst() {
        // return first.item;
        return sentinel.next.item;
    }

    public void addLast(int x) {

        // if (first == null) {
        //     first = new IntNode(x, null);
        //     size += 1;
        //     return;
        // }

        // IntNode p = first;
        IntNode p = sentinel;
        /* Move p until it reaches the end of the list */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size += 1;
    }

    // private int sizeHelper(IntNode p) {
    // if (p.next == null) {
    // return 1;
    // }
    // return 1 + sizeHelper(p.next);
    // }

    // public int size() {
    // // IntNode p = first;
    // // while (p != null) {
    // // size += 1;
    // // p = p.next;
    // // }
    // // return size;
    // return sizeHelper(first);
    // }

    public static void main(String[] args) {

        // SLList L = new SLList(15);
        SLList L = new SLList();
        // L.addFirst(10);
        // L.addFirst(5);
        L.addLast(20);
        // System.out.println(L.getFirst());
        // System.out.println(L.size());
        System.out.println(L.size);

    }
}