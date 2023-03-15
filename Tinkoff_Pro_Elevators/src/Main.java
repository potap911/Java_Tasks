import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        byte i;
        byte floorCount;

        byte[] workerCount = new byte[s.nextByte()];
        byte time = s.nextByte();
        for (i = 0; i < workerCount.length; i++) {
            workerCount[i] = s.nextByte();
        }
        byte numberWorkerLeave = s.nextByte();

        if (numberWorkerLeave >= workerCount[workerCount.length - 1]) {
            // этаж чела, который уходит выше целевых этажей с него вниз
            floorCount = (byte) (numberWorkerLeave - (workerCount[0]));
            System.out.println(floorCount);
        }

        else if ((Math.abs((numberWorkerLeave - workerCount[0]))) < time) {
            // c 1 эатажа на верх
            floorCount = (byte) ((workerCount[workerCount.length - 1]) - (workerCount[0]));
            System.out.println(floorCount);
        }

        else if ((Math.abs((numberWorkerLeave - workerCount[0]))) < (Math.abs((numberWorkerLeave - workerCount[workerCount.length - 1])))) {
            // идем с чела котрый уходит, вниз, а потом вверх
            floorCount = (byte) ((workerCount[workerCount.length - 1]) - (workerCount[0]) + (numberWorkerLeave - workerCount[0]));
            System.out.println(floorCount);

        }

        else if ((Math.abs((numberWorkerLeave - workerCount[workerCount.length - 1]))) < time) {
            // с последнего вниз
            floorCount = (byte) ((workerCount[workerCount.length - 1]) - (workerCount[0]));
            System.out.println(floorCount);
        }

        else if ((Math.abs((numberWorkerLeave - workerCount[0]))) > (Math.abs((numberWorkerLeave - workerCount[workerCount.length - 1])))) {
            // идем с чела котрый уходит, вверх, а потом вниз
            floorCount = (byte) ((workerCount[workerCount.length - 1]) - (workerCount[0]) + (Math.abs(workerCount[workerCount.length - 1] - numberWorkerLeave)));
            System.out.println(floorCount);
        }
    }
}