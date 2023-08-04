package Solutions.RectangleShrinking;

import java.util.*;

/**
 * 2023/8/3
 *
 * @author Daniel Atlas
 */
public class RectangleShrinking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] r1 = new int[n];
            int[] c1 = new int[n];
            int[] r2 = new int[n];
            int[] c2 = new int[n];
            for (int i = 0; i < n; i++) {
                r1[i] = sc.nextInt();
                c1[i] = sc.nextInt();
                r2[i] = sc.nextInt();
                c2[i] = sc.nextInt();
                c1[i]--;
            }
            Integer[] order = new Integer[n];
            for (int i = 0; i < n; i++) {
                order[i] = i;
            }
            Arrays.sort(order, Comparator.comparingInt(i -> c1[i]));
            TreeSet<int[]> s = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
            int ans = 0;
            int p1 = -1;
            int p2 = -1;
            for (int i : order) {
                if (r1[i] == 1 && r2[i] == 2) {
                    if (p1 >= c2[i]) {
                        r1[i] = 2;
                    }
                    if (p2 >= c2[i]) {
                        r2[i] = 1;
                    }
                    if (r1[i] > r2[i]) {
                        continue;
                    }
                }
                if (r1[i] == 1 && r2[i] == 2) {
                    while (!s.isEmpty()) {
                        int[] last = s.pollLast();
                        if (last[0] >= c1[i]) {
                            c2[last[1]] = c1[i];
                            s.remove(last);
                        } else {
                            break;
                        }
                    }
                    ans += (c2[i] - Math.max(c1[i], p1)) + (c2[i] - Math.max(c1[i], p2));
                    p1 = p2 = c2[i];
                    int[] pair = new int[]{c2[i], i};
                    s.add(pair);
                    continue;
                }
                if (r1[i] == 1) {
                    c1[i] = Math.max(c1[i], p1);
                    p1 = Math.max(p1, c2[i]);
                } else {
                    c1[i] = Math.max(c1[i], p2);
                    p2 = Math.max(p2, c2[i]);
                }
                if (c1[i] < c2[i]) {
                    ans += c2[i] - c1[i];
                    int[] pair = new int[]{c2[i], i};
                    s.add(pair);
                }
            }
            System.out.println(ans);
            for (int i = 0; i < n; i++) {
                c1[i]++;
                if (r1[i] <= r2[i] && c1[i] <= c2[i]) {
                    System.out.println(r1[i] + " " + c1[i] + " " + r2[i] + " " + c2[i]);
                } else {
                    System.out.println("0 0 0 0");
                }
            }
        }
    }
}
