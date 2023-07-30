package Solutions.RunningMiles;

import java.util.Scanner;

/**
 * 2023/7/30
 *
 * @author Daniel Atlas
 */
public class RunningMiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            int[] prefMx = new int[n];
            int[] suffMx = new int[n];
            for (int i = 0; i < n; i++) {
                prefMx[i] = b[i] + i;
                suffMx[i] = b[i] - i;
            }
            for (int i = 1; i < n; i++) {
                prefMx[i] = Math.max(prefMx[i], prefMx[i - 1]);
            }

            for (int i = n - 2; i >= 0; i--) {
                suffMx[i] = Math.max(suffMx[i], suffMx[i + 1]);
            }
            int ans = 0;
            for (int m = 1; m < n - 1; m++) {
                ans = Math.max(ans, b[m] + prefMx[m - 1] + suffMx[m + 1]);
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
