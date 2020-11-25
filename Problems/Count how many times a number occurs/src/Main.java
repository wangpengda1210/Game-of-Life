import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[scanner.nextInt()];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        int find = scanner.nextInt();
        int count = 0;

        for (int i : array) {
            if (i == find) count++;
        }

        System.out.println(count);
    }
}