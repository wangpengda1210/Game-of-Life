import java.util.Scanner;

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input

    @Override
    public void run() {

        while (true) {
            String text = scanner.nextLine();
            boolean finish = true;
            for (int i = 0; i < text.length(); i++) {
                if ("abcdefghijklmnopqrstuvwxyz".contains(text.charAt(i) + "")) {
                    finish = false;
                    break;
                }
            }

            if (finish) {
                System.out.println("FINISHED");
                break;
            } else {
                System.out.println(text.toUpperCase());
            }
        }

    }

}