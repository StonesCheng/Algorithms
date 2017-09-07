package algorithms;

import java.util.Scanner;

/**
 * Created by RayCheng on 2017/8/21.
 */
public class Shell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] t = new int[n];
        for (int i = 0; i < n; i++)
            t[i] = scanner.nextInt();
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (t[j] < t[j - h]) {
                        int temp = t[j];
                        t[j] = t[j - h];
                        t[j - h] = temp;
                    }
                }
            }
            h=h/3;
        }
        for (int i = 0; i < n; i++)
            System.out.println(t[i]);
    }
}
