package Solutions.ScheduleManagement;

import java.util.Scanner;
import java.util.Vector;
import java.util.function.Function;

/**
 * 2023/8/5
 *
 * @author Daniel Atlas
 */
public class ScheduleManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            Vector<Integer> a = new Vector<>(m);
            for (int i = 0; i < m; i++){
                a.add(sc.nextInt() - 1);
            }
            Vector<Integer> cnt = new Vector<>(n);
            for (int i = 0; i < n; i++){
                cnt.add(0);
            }
            for (int i = 0; i < m; i++){
                cnt.set(a.get(i), cnt.get(a.get(i)) + 1);
            }
            Function<Integer, Boolean> check = (x) -> {
                long fr = 0;
                long need = 0;
                for (int i = 0; i < n; i++){
                    if (x >= cnt.get(i)){
                        fr += (x - cnt.get(i)) / 2;
                    }
                    else {
                        need += cnt.get(i) - x;
                    }
                }
                return need <= fr;
            };
            int l = 0;
            int r = 2 * m;
            int res = -1;
            while (l <= r){
                int k = (l + r) / 2;
                if (check.apply(k)){
                    res = k;
                    r = k - 1;
                }
                else {
                    l = k + 1;
                }
            }
            System.out.println(res);
        }
    }
}
