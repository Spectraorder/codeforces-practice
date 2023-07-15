package Solutions.TwoArray;

import java.util.*;

/**
 * 2023/7/13
 *
 * @author Daniel Atlas
 */
public class TwoArray {
    static long MAX = 200000 + 7;
    static int n, m, va, vb;
    static int[] a = new int[(int)MAX];
    static int[] b = new int[(int)MAX];
    static int[] da = new int[(int)MAX];
    static int[] db = new int[(int)MAX];

    static boolean check(int x) {
        long sm = 0, f1 = 0, f2 = 0;
        for(int j = m; j >= 1; --j) {
            int i = 0;
            while(i < n && a[i+1] + b[j] <= x) {
                ++i;
            }
            db[j] = i;
            sm += db[j];
        }
        for(int i = n; i >= 1; --i) {
            int j = 0;
            while(j < m && a[i] + b[j+1] <= x) {
                ++j;
            }
            da[i] = j;
        }
        f1 = f2 = sm;
        for(int i = n, j = m; i >= 1; --i) {
            sm -= Math.min(j, da[i]);
            sm += m - Math.max(j, da[i]);
            f1 = Math.max(f1, sm);
            f2 = Math.max(f2, sm - (i <= va && j < vb ? 1 : 0));
            while(j > 0 && Math.min(db[j], i-1) <= n - Math.max(db[j], i-1)) {
                sm -= Math.min(db[j], i-1);
                sm += n - Math.max(db[j], i-1);
                --j;
                f1 = Math.max(f1, sm);
                f2 = Math.max(f2, sm - (i <= va && j < vb ? 1 : 0));
            }
        }
        return f1 == f2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; ++i){
            a[i] = sc.nextInt();
        }
        for(int j = 1; j <= m; ++j){
            b[j] = sc.nextInt();
        }
        va = a[1];
        vb = b[1];
        Arrays.sort(a, 1, n+1);
        Arrays.sort(b, 1, m+1);
        int l = a[1] + b[1];
        int r = va + vb;
        va = Arrays.binarySearch(a, 1, n+1, va);
        vb = Arrays.binarySearch(b, 1, m+1, vb);
        while(l < r) {
            int mid = (l + r) >> 1;
            if(check(mid)){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        System.out.println(l);
    }
}
