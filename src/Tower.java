import java.util.Scanner;

public class Tower {
    public void solve(int n, String start, String auxiliary, String end) {
        if (n == 1) {
            System.out.println(start + " -> " + end);
        } else {
            solve(n - 1, start, end, auxiliary);
            System.out.println(start + " -> " + end);
            solve(n - 1, auxiliary, start, end);
        }
    }

    public static void main(String[] args) {
        Tower towersOfHanoi = new Tower();
        System.out.print("Enter number of discs: ");
        int discs = 3;
        System.out.println();
        towersOfHanoi.solve(discs, "A", "B", "C");
    }
}
