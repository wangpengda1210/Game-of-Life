import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int n = scanner.nextInt();
        double m = scanner.nextDouble();

        while (true) {
            Random random = new Random(k);
            boolean isCorrect = true;
            for (int i = 0; i < n; i++) {
                if (random.nextGaussian() > m) {
                    isCorrect = false;
                    break;
                }
            }
            if (isCorrect) {
                System.out.println(k);
                break;
            } else {
                k++;
            }
        }
    }
}