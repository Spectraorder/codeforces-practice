package Solutions.TwoTanks;

import java.util.Scanner;

/**
 * 2023/7/29
 *
 * @author Daniel Atlas
 */
public class TwoTanks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] v = new int[n];
        for(int i=0;i<n;i++) {
            v[i] = sc.nextInt();
        }
        int[][] ans = new int[a+1][b+1];
        for(int cd=0;cd<=a+b;cd++){
            int l = Math.max(0, cd-b);
            int r = Math.min(a, cd);
            int sum = 0;
            for(int x : v) {
                sum += x;
                l = Math.max(l, Math.max(cd+sum-b, sum));
                r = Math.min(r, Math.min(a+sum, cd+sum));
            }
            if(l>r){
                l = r = Math.max(0, cd-b);
            }

            int res = l;
            for(int x : v){
                if(x>0){
                    res -= Math.min(res, Math.min(x, b-(cd-res)));
                }
                else{
                    res += Math.min(cd-res, Math.min(-x, a-res));
                }
            }
            for(int c=0;c<=cd;c++) {
                if(c<=a&&cd-c<=b) {
                    ans[c][cd-c]= (c < l) ? res : (c>r ? res+r-l : res+c-l);
                }
            }
        }
        for(int i=0;i<=a;i++) {
            for(int j=0;j<=b;j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
