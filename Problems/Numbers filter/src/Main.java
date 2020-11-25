import java.util.Scanner;

class NumbersFilter extends Thread {

    /* use it to read numbers from the standard input */
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        while (true) {
            int next = scanner.nextInt();
            if (next == 0) {
                break;
            } else if (next % 2 == 0) {
                System.out.println(next);
            }
        }
    }
}