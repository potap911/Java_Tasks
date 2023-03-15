import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String s = scanner.next();
        TreeSet<Integer> treeSet = new TreeSet<>();
        Pattern pattern_a = Pattern.compile("a");
        Pattern pattern_b = Pattern.compile("b");
        Pattern pattern_c = Pattern.compile("c");
        Pattern pattern_d = Pattern.compile("d");
        if (1 <= length & length <= 2 * Math.pow(10, 5)) {
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String checkString = s.substring(i, j);
                    if (checkString.length() >= 4) {
                        Matcher matcher_a = pattern_a.matcher(checkString);
                        Matcher matcher_b = pattern_b.matcher(checkString);
                        Matcher matcher_c = pattern_c.matcher(checkString);
                        Matcher matcher_d = pattern_d.matcher(checkString);
                        if (matcher_a.find() & matcher_b.find() &
                                matcher_c.find() & matcher_d.find()) {
                            treeSet.add(checkString.length());
                            //System.out.println(checkString);
                        }
                    }
                }
            }
        }
        if (treeSet.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(treeSet.first());
        }
    }
}