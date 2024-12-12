package ArraySet;

public class ArraySet<T> {

    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (x.equals(items[i])) {
                return true;
            }
        }
        return false;
    }


    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("cannot add null");
        }
        if (contains(x)) {
            return;
        }
        items[size++] = x;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<String>();
//        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size());
    }

}
