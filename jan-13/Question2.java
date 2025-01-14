

import java.util.Arrays;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int length = Integer.parseInt(sc.nextLine());
            int sum = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt)
                    .sum();

            double cubeRootDouble = Math.pow(sum, 1 / 3.0);
            int cubeRoot = (int) Math.round(cubeRootDouble);
            int cube = (cubeRoot * cubeRoot * cubeRoot);
            if (cube == sum)
                System.out.println("Yes");
            else {
                System.out.println(Math.pow(Math.ceil(cubeRootDouble), 3) - sum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
