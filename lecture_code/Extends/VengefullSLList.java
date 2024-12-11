package Extends;

public class VengefullSLList<T> extends SLList<T> {

    SLList<T> deletedItems;

    public VengefullSLList() {
        deletedItems = new SLList<>();
    }

    @Override
    public T removeLast() {
        T item = super.removeLast();
        deletedItems.addLast(item);
        return item;
    }


    public void printLostItems() {
        deletedItems.print();
    }

    public static void main(String[] args) {
        VengefullSLList<Integer> vsl = new VengefullSLList<>();
        vsl.addLast(1);
        vsl.addLast(5);
        vsl.addLast(10);
        vsl.addLast(13);

        vsl.removeLast();
        vsl.removeLast();
        System.out.println("The fallen are: ");
        vsl.printLostItems();
    }
}
