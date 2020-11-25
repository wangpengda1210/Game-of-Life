import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int d = 0;
        int c = 0;
        int b = 0;
        int a = 0;
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            switch (scanner.nextInt()) {
                case 5:
                    a++;
                    break;
                case 4:
                    b++;
                    break;
                case 3:
                    c++;
                    break;
                case 2:
                    d++;
                    break;
            }
        }

        System.out.println(d + " " + c + " " + b + " " + a);
    }
}