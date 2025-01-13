

import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println(numOfDistributions(sc.nextInt()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int numOfDistributions(int stock) {
        if (stock == 0)
            return 0;
        return 1 + numOfDistributions(stock % 2 == 0 ? stock / 2 : stock - 1);
    }

}
