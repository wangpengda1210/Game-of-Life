import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();

        while (!line.equals("0")) {
            try {
                System.out.println(Integer.parseInt(line) * 10);
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + line);
            } finally {
                line = in.nextLine();
            }
        }
    }
}