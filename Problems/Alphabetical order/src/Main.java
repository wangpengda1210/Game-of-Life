import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        String last = words[0];
        boolean result = true;

        for (String word : words) {
            if (word.compareTo(last) < 0) {
                result = false;
                break;
            }
            last = word;
        }

        System.out.println(result);
    }
}