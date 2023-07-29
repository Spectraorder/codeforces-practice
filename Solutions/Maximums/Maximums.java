package Solutions.Maximums;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2023/7/28
 *
 * @author Daniel Atlas
 */
public class Maximums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int maxV = 0;
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
            a[i] += maxV;
            maxV = Math.max(maxV, a[i]);
            System.out.print(a[i] + " ");
        }
        sc.close();
    }
}
