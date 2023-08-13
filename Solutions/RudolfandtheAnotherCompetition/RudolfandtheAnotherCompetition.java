package Solutions.RudolfandtheAnotherCompetition;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 2023/8/12
 *
 * @author Daniel Atlas
 */
public class RudolfandtheAnotherCompetition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int h = sc.nextInt();
            int[][] result = new int[n][2];
            for(int i=0;i<n;i++){
                PriorityQueue<Integer> cur = new PriorityQueue<>();
                for(int j=0;j<m;j++){
                    cur.add(sc.nextInt());
                }
                int curTime = 0;
                int penalty = 0;
                int point = 0;
                int next = cur.poll();
                boolean hasNext = true;
                while(hasNext&&h-curTime-next>=0){
                    curTime += next;
                    penalty += curTime;
                    point++;
                    if(cur.isEmpty()){
                        hasNext = false;
                    }
                    else{
                        next = cur.poll();
                    }
                }
                result[i] = new int[]{point, penalty};
            }
            if(result.length==1){
                System.out.println(1);
                continue;
            }
            int placement = 1;
            for(int[] k : result){
                if(k[0]>result[0][0]){
                    placement++;
                }
                else if(k[0]==result[0][0]&&k[1]<result[0][1]){
                    placement++;
                }
            }
            System.out.println(placement);
        }
    }
}
