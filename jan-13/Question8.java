
import java.util.Arrays;
import java.util.Scanner;

public class Question8 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int length = Integer.parseInt(sc.nextLine());
            System.out
                    .println(Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).map(i -> i > 0 ? 1 : 0)
                            .sum());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
