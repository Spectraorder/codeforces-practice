package Solutions.CaisaandPylons;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 2023/8/12
 *
 * @author Daniel Atlas
 */
public class CaisaandPylons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> cur = new PriorityQueue<>(Collections.reverseOrder());
        while(n-->0){
            cur.add(sc.nextInt());
        }
        System.out.println(cur.poll());
    }
}
