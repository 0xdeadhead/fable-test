

import java.util.Arrays;
import java.util.Scanner;

public class Question5 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int length = Integer.parseInt(sc.nextLine());
            int k = Integer.parseInt(sc.nextLine());
            System.out
                    .println(Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).map(i -> i / k).sum());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
