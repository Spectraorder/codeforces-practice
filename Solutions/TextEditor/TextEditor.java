package Solutions.TextEditor;

import java.util.Scanner;

/**
 * 2023/8/10
 *
 * @author Daniel Atlas
 */
public class TextEditor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String s = sc.next();
            String t = sc.next();

            int ans = Integer.MAX_VALUE;

            boolean bad = false;
            int[] lpos = new int[m];
            int[] rpos = new int[m];
            for (int i = 0; i < m; ++i) {
                if (i > 0) {
                    lpos[i] = lpos[i - 1] + 1;
                } else {
                    lpos[i] = 0;
                }
                while (lpos[i] < n && s.charAt(lpos[i]) != t.charAt(i)) {
                    ++lpos[i];
                }
                if (lpos[i] >= n) {
                    bad = true;
                    break;
                }
            }
            for (int i = m - 1; i >= 0; --i) {
                if (i + 1 < m) {
                    rpos[i] = rpos[i + 1] - 1;
                } else {
                    rpos[i] = n - 1;
                }
                while (rpos[i] >= 0 && s.charAt(rpos[i]) != t.charAt(i)) {
                    --rpos[i];
                }
                if (rpos[i] < 0) {
                    bad = true;
                    break;
                }
            }
            if (bad) {
                System.out.println(-1);
                continue;
            }

            for (int pos = 0; pos <= n; ++pos) {
                String tmp = s.substring(0, pos);
                tmp = new StringBuilder(tmp).reverse().toString();
                tmp += "#" + t;
                tmp = new StringBuilder(tmp).reverse().toString();
                int[] z = zf(tmp);
                for (int suf = 0; suf <= m; ++suf) {
                    if (pos - suf < 0) {
                        continue;
                    }
                    if (suf < m && rpos[suf] < pos) {
                        continue;
                    }
                    if (suf - 1 >= 0 && lpos[suf - 1] > pos) {
                        continue;
                    }
                    int rg = 0;
                    if (suf != 0) {
                        int sum = (pos - z[pos + 1 + m - suf]) + (pos - suf);
                        rg = (sum != 0) ? 1 + sum : 0;
                    } else {
                        rg = pos;
                    }
                    ans = Math.min(ans, (n - pos) + rg);
                }
            }
            System.out.println(ans);
        }

        sc.close();
    }

    public static int[] zf(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; ++i) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                ++z[i];
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }
}
