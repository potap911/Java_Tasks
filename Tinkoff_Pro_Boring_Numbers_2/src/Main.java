import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // длина массива
        ArrayList<Integer> arrNumbers = new ArrayList<>(); // массив чисел
        ArrayList<Integer> arrGroups = new ArrayList<>(); // массив групп чисел
        int repeatCount = 0; // колличество повторений чисел
        int countElementToRemove = 0; // колличество элекментов, которые нужно удалить с конца
        int resultLength = 0; // префикс длины "l" состоящий из "скучных чисел"

        if (2 <= n & n <= 2 * Math.pow(10, 5)) {
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                if (1 <= a & a <= 2 * Math.pow(10, 5)) { // заполняем массив числами
                    arrNumbers.add(a);
                }
            }
        }

        while (true) {
            countElementToRemove = arrNumbers.size();
            for (int i = 0; i < arrNumbers.size(); i++) {
                for (int j = i; j < arrNumbers.size(); j++) {
                    if (arrNumbers.get(i) == arrNumbers.get(j)) {
                        repeatCount++;
                    }
                }
                if (repeatCount > 0) {
                    arrGroups.add(repeatCount);
                }
                repeatCount = 0;
            }

            Collections.sort(arrGroups, Collections.reverseOrder());

            boolean flag = true;

            for (int i = 0; i < arrGroups.size(); i++) {
                    if (arrGroups.get(0) == arrGroups.get(i)) {
                        flag = true;
                    } else {
                        flag = false;
                    }

            }

            if (flag) {
                resultLength = n - countElementToRemove;
                if (resultLength == 0) {
                    System.out.println(n);
                    break;
                }
                if (resultLength > 0) {
                    System.out.println(resultLength);
                    break;
                }
            } else {
                arrNumbers.remove(arrNumbers.size() - 1);
                arrGroups.clear();
            }
        }
    }
}