package Solutions.RemoveOneElement;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2023/8/12
 *
 * @author Daniel Atlas
 */
public class RemoveOneElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int ans = 1;
        int[] rg = new int[n];
        Arrays.fill(rg, 1);
        for(int i=n-2;i>=0;i--){
            if(a[i+1]>a[i]){
                rg[i] = rg[i+1]+1;
            }
            ans = Math.max(ans, rg[i]);
        }
        int[] lf = new int[n];
        Arrays.fill(lf, 1);
        for(int i=1;i<n;i++){
            if(a[i-1]<a[i]){
                lf[i] = lf[i-1] + 1;
            }
            ans = Math.max(ans, lf[i]);
        }

        for(int i=0;i<n-2;i++) {
            if(a[i]<a[i+2]){
                ans = Math.max(ans, lf[i]+rg[i+2]);
            }
        }

        System.out.println(ans);
    }
}
