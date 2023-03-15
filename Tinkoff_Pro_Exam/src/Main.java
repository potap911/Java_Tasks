import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // колличество учеников. Гарантируется, что оно нечетно
        int s = scanner.nextInt(); // ограничение сверху суммарный бал учеников
        int sumMin = 0; // сумма минимальнных балов
        int limitScores = 0; // лимит балов для увеличения минимального бала для 1 проверки (по Min)
        int indexOfMedian = 0; // индекс медианного значения
        int resultForMin = 0; // результат по Min
        int resultForMax = 0; // результат по Max

        ArrayList<BoxScore> boxScoresCheckForMin = new ArrayList<>();
        ArrayList<BoxScore> boxScoresCheckForMax = new ArrayList<>();

        if (1 <= n & n <= 2 * Math.pow(10, 5) & 1 <= s & s <= Math.pow(10, 9) & (n % 2) != 0) {
            for (int i = 0; i < n; i++) {
                int min = scanner.nextInt();
                int max = scanner.nextInt();
                if (1 <= min & min <= max & max <= Math.pow(10, 9)) {
                    sumMin += min;
                    boxScoresCheckForMin.add(new BoxScore(min, max));
                    boxScoresCheckForMax.add(new BoxScore(min, max));
                }
            }
            limitScores = s - sumMin;
        }

        indexOfMedian = boxScoresCheckForMin.size() / 2;

        Collections.sort(boxScoresCheckForMin, Comparator.comparing(BoxScore::getMin));
        resultForMin = checkBoxScore(boxScoresCheckForMin, indexOfMedian, limitScores);

        Collections.sort(boxScoresCheckForMax, Comparator.comparing(BoxScore::getMax));
        resultForMax = checkBoxScore(boxScoresCheckForMax, indexOfMedian, limitScores);

        if (resultForMin > resultForMax) {
            System.out.println(resultForMin);
        } else {
            System.out.println(resultForMax);
        }
    }
    public static int checkBoxScore (ArrayList<BoxScore> boxScores, int indexOfMedian, int limitScores) {
        while (limitScores > 0) {
            if (boxScores.get(indexOfMedian).min == boxScores.get(indexOfMedian).max) {
                return boxScores.get(indexOfMedian).min;
            }
            for (int i = indexOfMedian; i < boxScores.size(); i++) {
                if (limitScores == 0) {
                    break;
                }

                if (i < boxScores.size() - 1) {
                    if (boxScores.get(i).min < boxScores.get(i).max & boxScores.get(i).min < boxScores.get(i + 1).min & boxScores.get(i).min <= boxScores.get(indexOfMedian).min) {
                        boxScores.get(i).min++;
                        limitScores--;
                    }
                    if (boxScores.get(i).min == boxScores.get(i).max & i != boxScores.size() - 1) {
                        return boxScores.get(indexOfMedian).min;
                    }
                }
                if (i == boxScores.size() - 1) {
                    if (boxScores.get(i).min == boxScores.get(i).max) {
                        continue;
                    }
                    if (boxScores.get(i).min < boxScores.get(i).max & boxScores.get(i).min <= boxScores.get(indexOfMedian).min) {
                        boxScores.get(i).min++;
                        limitScores--;
                    }
                }
            }
        }
        return boxScores.get(indexOfMedian).min;
    }

}
class BoxScore {
    public int min, max;
    public BoxScore(int min, int max) {
        this.min = min;
        this.max = max;
    }
    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public String toString() {
        return "Min - " + min + " :: " + "Max - " + max;
    }
}



