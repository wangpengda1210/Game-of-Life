import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int current = 1;
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size / 2.0; i++) {
            for (int j = i; j < size - i; j++) {
                matrix[i][j] = current;
                current++;
            }
            for (int j = i + 1; j < size - i; j++) {
                matrix[j][size - i - 1] = current;
                current++;
            }
            for (int j = size - i - 2; j >= i; j--) {
                matrix[size - i - 1][j] = current;
                current++;
            }
            for (int j = size - i - 2; j >= i + 1; j--) {
                matrix[j][i] = current;
                current++;
            }
        }

        for (int[] line : matrix) {
            for (int number : line) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}