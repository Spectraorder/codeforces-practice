package Solutions.Caninepoetry;

import java.util.Scanner;

/**
 * 2023/8/5
 *
 * @author Daniel Atlas
 */
public class Caninepoetry {
    public static final int N = 100000 + 7;
    public static int n;
    public static char[] in = new char[N];
    public static boolean[] used = new boolean[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            String s = sc.next();
            in = s.toCharArray();
            n = in.length - 1;
            for(int i=0;i<n;i++) {
                used[i] = false;
            }
            int ans = 0;
            for(int i=2;i<=n;i++) {
                boolean useNeed = in[i] == in[i - 1] && !used[i - 1];
                if(i > 2 && in[i] == in[i - 2] && !used[i - 2]) {
                    useNeed = true;
                }
                used[i] = useNeed;
                ans += used[i] ? 1 : 0;
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
