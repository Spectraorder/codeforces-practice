package Solutions.TheManwhobecameaGod;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 2023/8/4
 *
 * @author Daniel Atlas
 */
public class TheManwhobecameaGod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] village = new int[n];
            for(int i=0;i<n;i++){
                village[i] = sc.nextInt();
            }
            PriorityQueue<Integer> cur = new PriorityQueue<>();
            for(int i=0;i<n-1;i++){
                cur.offer(Math.abs(village[i]-village[i+1]));
            }
            int quan = cur.size();
            if(quan<k){
                System.out.println(0);;
            }
            else{
                int sum = 0;
                for(int i=0;i<quan-k+1;i++){
                    sum += cur.poll();
                }
                System.out.println(sum);
            }
        }
    }
}
