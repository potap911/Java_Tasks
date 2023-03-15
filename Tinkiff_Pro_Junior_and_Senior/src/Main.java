import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int junN = scanner.nextInt(); // колличество джунов
        int senM = scanner.nextInt(); // колличество сеньеров
        int countSeniorForCheck = scanner.nextInt(); // число необходимых проверок для одной работы
        int result = 0;

        int speedCheck = 0;

        if (1 <= countSeniorForCheck && countSeniorForCheck <= senM &&
            senM <= junN && junN <= Math.pow(10, 4)) {
            speedCheck = junN / senM;
            result = speedCheck * countSeniorForCheck + 1;
        }
        System.out.println(result);
    }
}