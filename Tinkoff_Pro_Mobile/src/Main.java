import java.util.Scanner;
public class Main {
        public static void main(String[] args) {

            Scanner s = new Scanner(System.in);

            short sum = 0;
            byte price_A = s.nextByte();
            byte traffic_B = s.nextByte();
            byte priceOverLimit_C = s.nextByte();
            byte trafficNext_D = s.nextByte();

            if (price_A <= 100 & 1 <= price_A &
                    traffic_B <= 100 & 1 <= traffic_B &
                    priceOverLimit_C <= 100 && 1 <= priceOverLimit_C &
                    traffic_B <= 100 & 1 <= traffic_B) {

                if (trafficNext_D <= 10) {
                    System.out.println(price_A);
                }
                else {
                    sum += price_A + (trafficNext_D - traffic_B) * priceOverLimit_C;
                    System.out.println(sum);
                }
            }
            else {
                System.out.println("Ошибка! Значения должны быть больше \"1\" и меньше \"100\"");
            }
        }
    }
