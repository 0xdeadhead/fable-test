

import java.util.Arrays;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] trussLengths = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (trussLengths.length < 3)
                return;
            int s1 = Math.max(trussLengths[0], trussLengths[1]), s2 = Math.min(trussLengths[0], trussLengths[1]);
            for (int i = 2; i < trussLengths.length; i++) {
                if (trussLengths[i] > s1) {
                    s2 = s1;
                    s1 = trussLengths[i];
                }
            }
            double area = (s1 * s2) / 2.0;
            System.out.println(area);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
