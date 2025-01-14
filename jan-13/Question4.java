
import java.util.Scanner;

public class Question4 {

    public static void main(String[] args) {
        boolean[] isPrimeDigit = new boolean[10];
        for (int i = 0; i < isPrimeDigit.length; i++)
            isPrimeDigit[i] = isPrime(i);
        try (Scanner sc = new Scanner(System.in)) {
            int number = sc.nextInt();
            int sumOfNonPrimes = 0;
            while (number > 0) {
                int digit = number % 10;
                if (!isPrimeDigit[digit])
                    sumOfNonPrimes += digit;
                number /= 10;
            }
            System.out.println(sumOfNonPrimes);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static boolean isPrime(int num) {

        if (num == 0 || num == 1)
            return false;
        int numOfFactors = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                numOfFactors++;
        }
        return numOfFactors == 2;
    }

}
