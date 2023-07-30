package Solutions.Starsky;

import java.util.Scanner;

/**
 * 2023/7/30
 *
 * @author Daniel Atlas
 */
public class Starsky {
    static final int C = 101;
    static final int P = 11;

    static int n, q, c;
    static int[][][] cnt = new int[P][C][C];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt();
        c = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int s = sc.nextInt();
            cnt[s][x][y]++;
        }

        for (int p = 0; p <= c; p++) {
            for (int i = 1; i < C; i++) {
                for (int j = 1; j < C; j++) {
                    cnt[p][i][j] += cnt[p][i - 1][j] + cnt[p][i][j - 1] - cnt[p][i - 1][j - 1];
                }
            }
        }

        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int ans = 0;
            for (int p = 0; p <= c; p++) {
                int brightness = (p + t) % (c + 1);
                int amount = cnt[p][x2][y2] - cnt[p][x1 - 1][y2] - cnt[p][x2][y1 - 1] + cnt[p][x1 - 1][y1 - 1];
                ans += brightness * amount;
            }
            System.out.println(ans);
        }

        sc.close();
    }
}
