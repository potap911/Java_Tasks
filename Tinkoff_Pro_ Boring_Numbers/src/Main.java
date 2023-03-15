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
        TreeSet<Integer> treeSetLengths = new TreeSet<>(); // здесь складываем возможные уменьшения длины
        int repeatCount = 0; // колличество повторений чисел
        int offset = 0; // смещение поиска по отношению к колличеству повторений
        int lengthReduction = 0; // число на которое будем уменьшать длину
        int resultLength = 0; // префикс искомой длины "l" (она всегда больше на 1)

        if (2 <= n & n <= 2 * Math.pow(10, 5)) {
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                if (1 <= a & a <= 2 * Math.pow(10, 5)) { // заполняем массив числами
                    arrNumbers.add(a);
                }
            }
        }

        Collections.sort(arrNumbers);

        for (int i = offset; i < arrNumbers.size(); i++) {
            for (int j = offset; j < arrNumbers.size(); j++) {
                if (arrNumbers.get(i) == arrNumbers.get(j)) {
                    repeatCount++;
                }
                if (arrNumbers.get(i) != arrNumbers.get(j)) {
                    offset += repeatCount;
                    break;
                }
            }

            if (repeatCount > 0) {
                arrGroups.add(repeatCount);
            }
            repeatCount = 0;
        }

        Collections.sort(arrGroups);
        //System.out.println(arrGroups);
        //System.out.println(arrGroups.size());

        if (arrGroups.size() == 2) {
            if (arrGroups.get(0) < arrGroups.get(arrGroups.size() - 1)) {
                lengthReduction += arrGroups.get(arrGroups.size() - 1) - arrGroups.get(0);
                treeSetLengths.add(lengthReduction);
                //System.out.println(lengthReduction);
            }
        }

        if (arrGroups.size() > 2) {

            for (int i = 0; i < arrGroups.size(); i++) {
                for (int j = 0; j < arrGroups.size(); j++) {
                    if (arrGroups.get(i) > arrGroups.get(j)) {
                        lengthReduction += arrGroups.get(j);
                    }
                    if (arrGroups.get(i) < arrGroups.get(j)) {
                        lengthReduction += arrGroups.get(j) - arrGroups.get(i);
                        //System.out.println(lengthReduction);
                    }
                }
                //System.out.println();
                treeSetLengths.add(lengthReduction);
                lengthReduction = 0;
            }
            //System.out.println(treeSetLengths);
            if (treeSetLengths.first() == 0) {
                System.out.println(arrNumbers.size());
            } else {
                resultLength = arrNumbers.size() - (treeSetLengths.first() - 1);
                System.out.println(resultLength);
            }
        }
    }
}