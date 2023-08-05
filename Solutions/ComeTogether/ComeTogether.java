package Solutions.ComeTogether;

import java.util.Scanner;

/**
 * 2023/8/4
 *
 * @author Daniel Atlas
 */
public class ComeTogether {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int[] a = new int[2];
            int[] b = new int[2];
            int[] c = new int[2];
            for(int i=0;i<2;i++){
                a[i] = sc.nextInt();
            }
            for(int i=0;i<2;i++){
                b[i] = sc.nextInt();
            }
            for(int i=0;i<2;i++){
                c[i] = sc.nextInt();
            }
            int[] walkB = {a[0]-b[0], a[1]-b[1]};
            int[] walkC = {a[0]-c[0], a[1]-c[1]};
            int step = 1;
            if(walkB[0]<0&&walkC[0]<0){
                step += Math.abs(Math.max(walkB[0], walkC[0]));
            }
            if(walkB[0]>0&&walkC[0]>0){
                step += Math.min(walkB[0], walkC[0]);
            }
            if(walkB[1]<0&&walkC[1]<0){
                step += Math.abs(Math.max(walkB[1], walkC[1]));
            }
            if(walkB[1]>0&&walkC[1]>0){
                step += Math.min(walkB[1], walkC[1]);
            }
            System.out.println(step);
        }
        sc.close();
    }
}
