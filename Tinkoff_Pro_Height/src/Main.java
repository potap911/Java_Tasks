import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayListCheck = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            int input = scanner.nextInt();
            if (0 <= input && input <= 300) {
                arrayList.add(input);
                arrayListCheck.add(input);
            }
        }

        Collections.sort(arrayListCheck);

        for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) == arrayListCheck.get(i)) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
        }

        if (flag) {
            System.out.println("YES");
            System.exit(0);
        }

        Collections.sort(arrayListCheck, Collections.reverseOrder());
        for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) == arrayListCheck.get(i)) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
        }

        if (flag) {
            System.out.println("YES");
        } else  {
            System.out.println("NO");
        }
    }
}