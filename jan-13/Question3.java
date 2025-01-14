

import java.util.Arrays;
import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int length = Integer.parseInt(sc.nextLine());
            int[] dimensions = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int perfectCubes = 0;
            for (int dimension : dimensions) {
                int cubeRoot = (int) Math.round((Math.pow(dimension, 1 / 3.0)));
                if ((cubeRoot * cubeRoot * cubeRoot) == dimension)
                    perfectCubes++;
            }
            System.out.println(perfectCubes);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
