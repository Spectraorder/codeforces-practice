package Solutions.MagicTriplesEasyVersion;

import java.util.Scanner;

/**
 * 2023/8/6
 *
 * @author Daniel Atlas
 */
public class MagicTriplesEasyVersion {
    public static final int MAX_VAL = (int)1e6;

    public static int[] cnt = new int[MAX_VAL + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
                ++cnt[a[i]];
            }
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans += (cnt[a[i]] - 1) * (cnt[a[i]] - 2);
                for (int b = 2; a[i] * b * b <= MAX_VAL; ++b) {
                    ans += cnt[a[i] * b] * cnt[a[i] * b * b];
                }
            }
            System.out.println(ans);
            for (int i = 0; i < n; ++i) {
                --cnt[a[i]];
            }
        }
    }
}
