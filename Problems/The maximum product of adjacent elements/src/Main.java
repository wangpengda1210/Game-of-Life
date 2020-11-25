import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        int last = scanner.nextInt();
        int maxMul = 0;

        for (int i = 1; i < count; i++) {
            int next = scanner.nextInt();
            if (last * next > maxMul) {
                maxMul = last * next;
            }
            last = next;
        }

        System.out.println(maxMul);
    }
}