package Solutions.Candies;

import java.util.Scanner;

/**
 * 2023/8/5
 *
 * @author Daniel Atlas
 */
public class Candies {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long l = 1, r = n;
        long ans = r;
        while (l <= r) {
            long k = (l + r) / 2;
            if (check(k, n)) {
                ans = k;
                r = k - 1;
            }
            else {
                l = k + 1;
            }
        }

        System.out.println(ans);
    }

    public static boolean check(long k, long n) {
        long sum = 0;
        long cur = n;
        while (cur > 0) {
            long o = Math.min(cur, k);
            sum += o;
            cur -= o;
            cur -= cur / 10;
        }
        return sum * 2 >= n;
    }
}
