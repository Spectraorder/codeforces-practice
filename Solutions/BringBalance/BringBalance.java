package Solutions.BringBalance;

import java.util.*;

/**
 * 2023/8/19
 *
 * @author Daniel Atlas
 */
public class BringBalance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt() * 2;
            String str = sc.next();
            int left = 0, right = 0;
            ArrayDeque<int[]> interval = new ArrayDeque<>();
            boolean reverse = false;
            int[] disp = new int[2];
            for(int i=0;i<n;i++){
                char cur = str.charAt(i);
                if(!reverse){
                    if(cur=='('){
                        left++;
                    }
                    else if(left>0){
                        left--;
                    }
                    else{
                        reverse = true;
                        disp[0] = i+1;
                    }
                }
                if(reverse){
                    if(cur==')'){
                        right++;
                    }
                    else if(right>0){
                        right--;
                    }
                    else{
                        reverse = false;
                        disp[1] = i;
                        interval.add(new int[]{disp[0], disp[1]});
                        left++;
                    }
                }
            }
            if(disp[1]<disp[0]){
                disp[1] = n;
                interval.add(new int[]{disp[0], disp[1]});
            }
            canCombine(str, interval);
            System.out.println(interval.size());
            for(int[] cur : interval){
                System.out.println(cur[0]+" "+cur[1]);
            }
        }
    }

    public static void canCombine(String str, ArrayDeque<int[]> interval){
        while(interval.size()>=2){
            int[] interA = interval.removeFirst();
            int[] interB = interval.removeFirst();
            int[] output = (int[]) combine(str, interA, interB);
            if(output!=null){
                interval.addFirst(output);
            }
            else{
                interval.addFirst(interB);
                interval.addFirst(interA);
                break;
            }
        }
    }

    public static Object combine(String str, int[] interA, int[] interB){
        int maxP = 0;
        int left = 0;
        for(int i=interA[1];i<interB[0]-1;i++){
            char cur = str.charAt(i);
            if(cur=='('){
                left++;
                maxP = Math.max(maxP, left);
            }
            else{
                left--;
            }
        }
        int start = -1, end = -1;
        int pal = 0;
        for(int i=interA[0]-2;i>=0;i--){
            char cur = str.charAt(i);
            if(cur==')'){
                pal++;
            }
            else{
                pal--;
            }
            if(pal==maxP-1){
                start = i;
                break;
            }
        }
        pal = 0;
        for(int i=interB[1];i<str.length();i++){
            char cur = str.charAt(i);
            if(cur=='('){
                pal++;
            }
            else{
                pal--;
            }
            if(pal==maxP-1){
                end = i;
                break;
            }
        }
        if(start==-1||end==-1){
            return null;
        }
        else{
            return new int[]{start+1, end+1};
        }
    }
}
