import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        StringReverser reverser = str -> {
            StringBuilder result = new StringBuilder();
            for (int i = line.length() - 1; i >= 0; i--) {
                result.append(line.charAt(i));
            }
            return result.toString();
        };

        System.out.println(reverser.reverse(line));
    }

    interface StringReverser {

        String reverse(String str);
    }

}