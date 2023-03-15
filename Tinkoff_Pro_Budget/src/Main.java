import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> arrayDays = new ArrayList<>();
        int sumCheck = 0;
        int normaSegment = 0;

        if (1 <= n & n <= 2 * Math.pow(10, 5)) {
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                if (Math.pow(-10, 9) <= a & a <= Math.pow(10, 9)) {
                    arrayDays.add(a);
                }
            }
        }

        for (int i = 0; i < arrayDays.size(); i++) {
            for (int j = i + 1; j < arrayDays.size(); j++) {
                for (int indexCheck = i; indexCheck <= j; indexCheck++) {
                    sumCheck += arrayDays.get(indexCheck);
                }
                if (sumCheck == 0) {
                    normaSegment++;
                    normaSegment += arrayDays.size() - 1 - j;
                }
                sumCheck = 0;
            }
        }
        System.out.println(normaSegment);
    }
}