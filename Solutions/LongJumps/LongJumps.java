package Solutions.LongJumps;

import java.util.Scanner;

/**
 * 2023/7/28
 *
 * @author Daniel Atlas
 */
public class LongJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int[] dp = new int[n];
            for(int i=n-1;i>=0;i--){
                score(arr, dp, i);
            }
            int maxV = Integer.MIN_VALUE;
            for(int cur : dp){
                maxV = Math.max(maxV, cur);
            }
            System.out.println(maxV);
        }
    }

    public static void score(int[] arr, int[] dp, int pos){
        int total = 0;
        int fill = pos;
        while(pos<dp.length&&dp[pos]==0){
            total += arr[pos];
            pos += arr[pos];
        }
        dp[fill] = pos<dp.length ? total+dp[pos] : total;
    }
}
