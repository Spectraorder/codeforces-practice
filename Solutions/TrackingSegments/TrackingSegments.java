package Solutions.TrackingSegments;

import java.util.Scanner;

/**
 * 2023/8/6
 *
 * @author Daniel Atlas
 */
public class TrackingSegments {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] segs = new int[m][];
            for (int i = 0; i < m; i++) {
                int l = sc.nextInt();
                l--;
                int r = sc.nextInt();
                segs[i] = new int[]{l, r};
            }
            int q = sc.nextInt();
            int[] ord = new int[q];
            for (int i = 0; i < q; i++) {
                ord[i] = sc.nextInt();
                ord[i]--;
            }
            int l = 0;
            int r = q + 1;
            while (r - l > 1) {
                int M = (l + r) / 2;
                int[] cur = new int[n];
                for (int i = 0; i < M; i++) {
                    cur[ord[i]] = 1;
                }
                int[] pr = new int[n + 1];
                for (int i = 0; i < n; i++) {
                    pr[i+1] = pr[i] + cur[i];
                }
                boolean ok = false;
                for (int[] i : segs) {
                    if (pr[i[1]] - pr[i[0]] > (i[1] - i[0]) / 2) {
                        ok = true;
                        break;
                    }
                }
                if (ok) {
                    r = M;
                } else {
                    l = M;
                }
            }
            if (r == q + 1) {
                r = -1;
            }
            System.out.println(r);
        }
        sc.close();
    }
}
