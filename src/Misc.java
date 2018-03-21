import java.util.ArrayList;

public class Misc {

    public static void main(String[] args) {

        ArrayList<Integer> l1 = new ArrayList<>() {{add(1); add(2); add(3);}};
        ArrayList<Integer> l2 = new ArrayList<>() {{add(4); add(5); add(6);}};

        l1 = l2;

        l2.remove(1);
        System.out.println(l1.toString());

        l1.remove(0);
        System.out.println(l1.toString());
        System.out.println(l2.toString());
    }
}
