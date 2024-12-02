package List;

public class Lists1Exercises {
    /**
     * Returns an IntList identical to L, but with
     * each element incremented by x. L is not allowed
     * to change.
     */
    public static List.IntList incrList(List.IntList L, int x) {
        /* Your code here. */
        List.IntList Q = new List.IntList(L.first + x, null);
        List.IntList q = Q;
        List.IntList p = L.rest;
        while (p != null) {
            q.rest = new List.IntList(p.first + x, null);
            p = p.rest;
            q = q.rest;
        }

        return Q;
    }

    /**
     * Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed to use
     * the 'new' keyword.
     */
    public static List.IntList dincrList(List.IntList L, int x) {
        /* Your code here. */
        List.IntList p = L;

        while (p != null) {
            p.first += x;
            p = p.rest;
        }

        return L;
    }

    public static void main(String[] args) {
        List.IntList L = new List.IntList(5, null);
        L.rest = new List.IntList(7, null);
        L.rest.rest = new List.IntList(9, null);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        System.out.println(L.get(1));
        System.out.println(incrList(L, 3));
        System.out.println(dincrList(L, 3));
    }
}