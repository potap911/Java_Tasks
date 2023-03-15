import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        long count_N = s.nextLong();

        if (count_N == 1) {
            System.out.println(count_N);
        }

        if (count_N > 1 && count_N <= 2 * (Math.pow(10, 9))) {
            if ((count_N & 1) == 0) {
                System.out.println(count_N/2);
            }
            else {
                System.out.println((count_N + 1)/2);
            }
        }
    }
}