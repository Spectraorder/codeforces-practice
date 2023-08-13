package Solutions.ThreeSevens;

import java.util.*;

/**
 * 2023/8/12
 *
 * @author Daniel Atlas
 */
public class ThreeSevens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int m = sc.nextInt();
            Stack<int[]> participants = new Stack<>();
            while(m-->0){
                int n = sc.nextInt();
                int[] arr = new int[n];
                for(int i=0;i<n;i++){
                    arr[i] = sc.nextInt();
                }
                participants.add(arr);
            }
            HashSet<Integer> view = new HashSet<>();
            ArrayList<Integer> ans = new ArrayList<>();
            boolean isFalse = false;
            while(!participants.isEmpty()){
                int[] cur = participants.pop();
                int winner = -1;
                for(int k : cur){
                    if(!view.contains(k)){
                        winner = k;
                        view.add(k);
                    }
                }
                if(winner==-1){
                    System.out.println(-1);
                    isFalse = true;
                    break;
                }
                ans.add(0, winner);
            }
            if(!isFalse){
                for(int k : ans){
                    System.out.print(k + " ");
                }
                System.out.println();
            }
        }
    }
}
