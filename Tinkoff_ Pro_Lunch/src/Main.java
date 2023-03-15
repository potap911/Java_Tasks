import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> lunchList = new ArrayList<>(); // массив всех обедов
        ArrayList<Integer> lunchForCompensationList = new ArrayList<>(); // массив приоритетных обедов для компенсации
        ArrayList<Integer> lunchForCheckList = new ArrayList<>(); // массив для проверки обеда для оплаты/компенсации


        int countLunch = scanner.nextInt(); // колличество обедов
        int coupon = 0; // бесплатные обеды
        int indexOfFirstCoupon = 0; // индекс последнего полученого купона
        int allPriceLunches = 0; // общая цена обедов запланированных
        int freeSum = 0; // сумма цен обедов, которые компенсируем
        int resultSum = 0; // наивыгодная сумма обедов с учетом компенсации самых дорогих

        if (countLunch >= 0 && countLunch <= 100 ) {  // проверка колличества ланчей
            for (int i = countLunch; i > 0; i--) {
                int input = scanner.nextInt();
                if (input <= 300) {
                    lunchList.add(input);// заполняем массив всех обедов при условии стоймости обеда меньше 300
                    allPriceLunches += input;
                } else {
                    System.out.println("Некорректная цена обеда. Должно быть не больше 300");
                }
            }
        } else {
            System.out.println("Некорректное колличество обедов. Должно быть не больше 100");
        }

        for (int i = lunchList.size() - 1; i >= 0; i--) { // проверяем массив обедов, находим обеды >= 100
            if (lunchList.get(i) >= 100) {
                coupon++; // копим купоны
                indexOfFirstCoupon = i; // фиксируем индекс 1 купона
            }
        }

        for (int i = indexOfFirstCoupon; i < lunchList.size(); i++) { // провераяем пригодность обедов Дороже 100 к оплате/компенсации
            if (lunchList.get(i) >= 198) {
                lunchForCompensationList.add(lunchList.get(i)); // если дороже 198 компенсируем такой обед
                coupon--;
            }
            if (lunchList.get(i) < 198 && lunchList.get(i) >= 100) {
                for (int j = i; j < lunchList.size(); j++) { // если дешевле 198 доп проверка
                    if (lunchList.get(j) < 100) {
                        lunchForCheckList.add(lunchList.get(j));
                    }
                }

                Collections.sort(lunchForCheckList, Collections.reverseOrder());
                //System.out.println(lunchForCheckList);

                int checkSum = 0;
                if (lunchForCheckList.size() == 1) {
                    checkSum = lunchForCheckList.get(0);
                }
                if (lunchForCheckList.size() > 1) {
                    checkSum = lunchForCheckList.get(0) + lunchForCheckList.get(1);
                }
                if (lunchList.get(i) >= checkSum) {
                    lunchForCompensationList.add(lunchList.get(i)); // если сумма 2 следующих чисел, меньше цены обеда, компенсируем этот ланч
                    coupon--;
                }
                if (lunchList.get(i) < checkSum) {
                    lunchForCompensationList.add(lunchForCheckList.get(0)); // наоборот, компенсируем самый дорогой из этих двух? удаляем такой же из основного списка
                }
                lunchForCheckList.clear();
            }
        }
        //System.out.println(lunchForCompensationList);
        if (coupon > lunchForCompensationList.size()) {  // если есть лишние купоны, тратим их на дорогие обеды из тех которые меньше 100
            int limit = lunchForCompensationList.size();
            for (int i = 0; i < lunchList.size(); i++) {
                if (lunchList.get(i) < 100) {
                    lunchForCheckList.add(lunchList.get(i));
                }
            }
            Collections.sort(lunchForCheckList, Collections.reverseOrder());
            for (int i = 0; i < lunchForCheckList.size() ; i++) {
                if (coupon == limit) {
                    break;
                }
                if (coupon != limit) {
                    lunchForCompensationList.add(lunchForCheckList.get(i));
                    coupon--;
                    //System.out.println(coupon);
                }
            }
            coupon++;
        }
        //System.out.println(coupon);


        Collections.sort(lunchForCompensationList, Collections.reverseOrder());

        if (lunchForCompensationList.size() == 1) {
            freeSum = lunchForCompensationList.get(0);
        }
        if (lunchForCompensationList.size() > 1) {
            for (int i = 0; i < lunchForCompensationList.size(); i++) {
                if (coupon == 0) {
                    break;
                }
                if (coupon != 0) {
                    freeSum += lunchForCompensationList.get(i);
                    coupon--;
                }
            }
        }
        resultSum = allPriceLunches - freeSum;

        //System.out.println(allPriceLunches);
        //System.out.println(freeSum);
        System.out.println(resultSum);

    }

}