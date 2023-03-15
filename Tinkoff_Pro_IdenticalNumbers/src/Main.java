import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        long r = scanner.nextLong();

        if (l >= 1 && r <= Math.pow(r, 18)) {
            long generateNumber;
            long test = 0;
            for (generateNumber = l; generateNumber < r; generateNumber++) {
                String str = String.valueOf(generateNumber);
                char[] charsGenerateNumber = str.toCharArray();
                if (charsGenerateNumber.length == 1) {
                    test++;
                    continue;
                }

                boolean flag = true;
                for (int i = 1; i < charsGenerateNumber.length; i++) {
                    if (charsGenerateNumber[i] != charsGenerateNumber[0]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    test++;
                }
            }
            System.out.println(test);
        }
    }
}