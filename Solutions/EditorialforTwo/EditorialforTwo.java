package Solutions.EditorialforTwo;

import java.util.*;

/**
 * 2023/7/21
 *
 * @author Daniel Atlas
 */
public class EditorialforTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            long[] minK = getMinK(a, k);
            int minTime = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                long[] p = Arrays.copyOfRange(minK, 0, i);
                long[] m = Arrays.copyOfRange(minK, i, k);
                int pTime = 0;
                for(long x : p){
                    pTime += x;
                }
                int mTime = 0;
                for(long x : m){
                    mTime += x;
                }
                minTime = Math.min(minTime, Math.max(pTime, mTime));
            }
            System.out.println(minTime);
        }
        sc.close();
    }

    public static long[] getMinK(long[] arr, int k) {
        long[] minK = new long[k];
//        long[] temp = arr.clone();
//        Arrays.sort(temp);
        PriorityQueue<Long> all = new PriorityQueue<>();
        for(long cur : arr){
            all.add(cur);
        }
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(all.poll());
        }
        int pos = 0;
        for (long cur : arr) {
            if (pos == k) {
                break;
            }
            if (pq.contains(cur)) {
                minK[pos++] = cur;
                pq.remove(cur);
            }
        }
        return minK;
    }
}
