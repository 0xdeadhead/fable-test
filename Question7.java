

import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int number = sc.nextInt();
            long product = number == 0 ? 0 : 1;
            while (number > 0) {
                product *= (number % 10);
                number /= 10;
            }
            System.out.println(product);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
