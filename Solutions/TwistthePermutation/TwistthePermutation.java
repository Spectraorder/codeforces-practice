package Solutions.TwistthePermutation;

import java.util.Scanner;

/**
 * 2023/7/29
 *
 * @author Daniel Atlas
 */
public class TwistthePermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int tt = 0; tt < tests; tt++) {
            solve(sc);
        }
    }

    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
        }
        int[] ans = new int[n];
        for (int i = n; i > 0; --i) {
            int ind = 0;
            for (int j = 0; j < i; ++j) {
                if (a[j] == i) {
                    ind = j;
                }
            }
            int[] b = new int[i];
            for (int j = 0; j < i; ++j) {
                b[(i - 1 - ind + j) % i] = a[j];
            }
            for (int j = 0; j < i; ++j) {
                a[j] = b[j];
            }
            ans[i - 1] = (i != 1) ? (ind + 1) % i : 0;
        }
        for (int i = 0; i < n; ++i) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
