package Solutions.Promo;

import java.util.*;

/**
 * 2023/7/21
 *
 * @author Daniel Atlas
 */
public class Promo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] items = new int[n];
        for(int i = 0; i < n; i++){
            items[i] = sc.nextInt();
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) {
            pq.add(items[i]);
        }
        while(q-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            ArrayList<Integer> cur = new ArrayList<>();
            for(int i=0;i<x;i++){
                cur.add(pq.poll());
            }
            int sum = 0;
            for(int i=cur.size()-y;i<cur.size();i++){
                sum += cur.get(i);
            }
            System.out.println(sum);
            pq.addAll(cur);
        }
    }
}
