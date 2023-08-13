package Solutions.Desorting;

import java.util.Scanner;

/**
 * 2023/8/11
 *
 * @author Daniel Atlas
 */
public class Desorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int minDiff = Integer.MAX_VALUE;
            for(int i=0;i<n-1;i++){
                minDiff = Math.min(arr[i+1]-arr[i], minDiff);
            }
            if(minDiff<0){
                System.out.println(0);
            }
            else{
                System.out.println(minDiff/2 + 1);
            }
        }
    }
}
